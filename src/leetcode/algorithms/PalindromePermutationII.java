package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/palindrome-permutation-ii/
// Given a string s, return all the palindromic permutations (without duplicates) of it. Return an
// empty list if no palindromic permutation could be form.
// For example:
// Given s = "aabb", return ["abba", "baab"].
// Given s = "abc", return [].
// Hint:
// If a palindromic permutation exists, we just need to generate the first half of the string.
// To generate all distinct permutations of a (half of) string, use a similar approach from:
// Permutations II or Next Permutation.
public class PalindromePermutationII {
  public List<String> generatePalindromes(String s) {
    int odd = 0;
    String mid = "";
    List<String> res = new ArrayList<>();
    List<Character> list = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
      odd += map.get(c) % 2 != 0 ? 1 : -1;
    }
    if (odd > 1) {
      return res;
    }
    for (char key : map.keySet()) {
      int val = map.get(key);
      if (val % 2 != 0) {
        mid += key;
      }
      for (int i = 0; i < val / 2; i++) {
        list.add(key);
      }
    }
    getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);
    return res;
  }

  void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
    if (sb.length() == list.size()) {
      res.add(sb.toString() + mid + sb.reverse().toString());
      sb.reverse();
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
        continue;
      }
      if (!used[i]) {
        used[i] = true;
        sb.append(list.get(i));
        getPerm(list, mid, used, sb, res);
        used[i] = false;
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
