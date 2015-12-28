package lib.graphs;

/**
 * A weighted edge in an {@link EdgeWeightedDigraph}.
 * 
 * @author If
 *
 */
public class DirectedEdge implements Comparable<DirectedEdge> {

  private final int v;
  private final int w;
  private final double weight;

  public DirectedEdge(int v, int w, double weight) {
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public int from() {
    return v;
  }

  public int to() {
    return w;
  }

  public double weight() {
    return weight;
  }

  @Override
  public int compareTo(DirectedEdge o) {
    return Double.compare(weight, o.weight);
  }

  public String toString() {
    return v + "->" + w + " " + String.format("%5.2f", weight);
  }

  public static void main(String[] args) {
    DirectedEdge e = new DirectedEdge(12, 34, 5.67);
    System.out.println(e);
  }
}