package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import lib.graphs.Graph;

public class LongtailHedgehog {

  static BufferedReader in;
  static PrintWriter out;
  static StringTokenizer tok;

  static Graph graph;
  static long[] tail;

  static void solve() throws Exception {
    int n = nextInt(), m = nextInt();
    graph = new Graph(n);
    for (int i = 0; i < m; i++) {
      graph.addEdge(nextInt() - 1, nextInt() - 1);
    }
    tail = new long[n];
    for (int v = 0; v < n; v++) {
      comp(v);
    }
    long ans = 0;
    for (int v = 0; v < n; v++) {
      ans = Math.max(ans, (tail[v] + 1) * graph.degree(v));
    }
    out.println(ans);
  }

  static void comp(int v) {
    for (int w : graph.adj(v)) {
      if (w > v) {
        tail[w] = Math.max(tail[w], tail[v] + 1);
      }
    }
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
