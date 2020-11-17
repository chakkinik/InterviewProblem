package com.walmartlabs.dsround;

import java.util.ListIterator;

public class TaskDependency {
  static Graph graph;

  public static void findOrder() {

    Boolean[] visited = new Boolean[graph.vertices];

    for (int i = 0; i < graph.vertices; i++) {
      visited[i] = false;
    }

    for (int i = 0; i < graph.vertices; i++) {
      if (visited[i] == false) {
        DFSUtils(i, visited);
      }
    }

  }


  private static void DFSUtils(int i, Boolean[] visited) {
    visited[i] = true;
    System.out.println("i==" + i);

    ListIterator<Integer> listIterator = graph.adj[i].listIterator();
    while (listIterator.hasNext()) {
      Integer next = listIterator.next();
      if (visited[next] == false) {
        DFSUtils(next, visited);
      }
    }

  }



  static void makeGraph(int[][] tasks) {
    graph = new Graph(4);
    for (int i = 0; i < tasks.length; i++) {
      graph.addEdges(tasks[i][0], tasks[i][1]);
    }
    System.out.println("graph==prepared");
  }

  public static void main(String[] args) {
    int[][] tasks = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

    makeGraph(tasks);

    findOrder();

  }
}
