package leetcode.algorithms;

import java.util.Arrays;

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    char[] sc = s.toCharArray();
    char[] tc = t.toCharArray();
    Arrays.sort(sc);
    Arrays.sort(tc);
    return (new String(sc)).equals(new String(tc));
  }
}
