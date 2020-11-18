package com.myntra.dsround;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathKnight {

  static int steps = 0;
  // Below arrays details all 8 possible movements
  // for a knight
  private static int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
  private static int[] col = {-1, 1, 1, -1, 2, -2, 2, -2};

  public static boolean isValidMove(int x, int y) {
    if (x > 0 && x < 8 && y > 0 && y < 8) {
      return true;
    }
    return false;
  }

  public static int findShortPath(Node src, Node dest, int n) {

    Set<Node> visited = new HashSet<>();
    visited.add(src);
    Queue<Node> q = new LinkedList<>();

    q.add(src);

    while (!q.isEmpty()) {
      Node node = q.poll();
      int x = node.x;
      int y = node.y;
      int dist = node.dist;

      if (x == 7 && y == 7) {
        return dist;
      }

      if (!visited.contains(node)) {
        // mark current node as visited
        visited.add(node);

        // check for all 8 possible movements for a knight
        // and enqueue each valid movement into the queue
        for (int i = 0; i < 8; ++i) {
          // Get the new valid position of Knight from current
          // position on chessboard and enqueue it with +1 distance
          int x1 = x + row[i];
          int y1 = y + col[i];

          if (isValidMove(x1, y1))
            q.add(new Node(x1, y1, dist + 1));
        }
      }


    }

    return Integer.MAX_VALUE;

  }

  public static void main(String[] args) {
    Node[][] chess = new Node[8][8];

    Node source = new Node(0, 0);
    Node dest = new Node(7, 7);

    int shortPath = findShortPath(source, dest, 8);

    System.out.println(shortPath);

  }

}
