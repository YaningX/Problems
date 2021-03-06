package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RoutineProblem {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static void solve() throws Exception {
    int a = nextInt(), b = nextInt(), c = nextInt(), d = nextInt();
    int l = a * d, r = b * c;
    if (l == r)
      out.println("0/1");
    else if (l > r) {
      int p = l - r;
      int q = l;
      int g = gcd(p, q);
      p /= g;
      q /= g;
      out.println(p + "/" + q);
    } else {
      int p = r - l;
      int q = r;
      int g = gcd(p, q);
      p /= g;
      q /= g;
      out.println(p + "/" + q);
    }
  }

  static int gcd(int a, int b) {
    while (b > 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  public static void main(String args[]) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(new OutputStreamWriter(System.out));
      solve();
      in.close();
      out.close();
    } catch (Throwable e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(next());
  }

  static int[] nextIntArray(int len, int start) throws IOException {
    int[] a = new int[len];
    for (int i = start; i < len; i++)
      a[i] = nextInt();
    return a;
  }

  static long nextLong() throws IOException {
    return Long.parseLong(next());
  }

  static long[] nextLongArray(int len, int start) throws IOException {
    long[] a = new long[len];
    for (int i = start; i < len; i++)
      a[i] = nextLong();
    return a;
  }

  static String next() throws IOException {
    while (tok == null || !tok.hasMoreTokens()) {
      tok = new StringTokenizer(in.readLine());
    }
    return tok.nextToken();
  }

}
