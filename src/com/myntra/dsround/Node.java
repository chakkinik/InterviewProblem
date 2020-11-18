package com.myntra.dsround;

public class Node {

  int x;
  int y;
  int dist;

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  Node(int x, int y, int dist) {
    this.x = x;
    this.y = y;
    this.dist = dist;
  }

  // As we are using class object as a key in a HashMap
  // we need to implement hashCode() and equals()

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Node node = (Node) o;

    if (x != node.x)
      return false;
    if (y != node.y)
      return false;
    return dist == node.dist;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    result = 31 * result + dist;
    return result;
  }

}
