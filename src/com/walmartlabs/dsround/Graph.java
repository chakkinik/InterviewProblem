package com.walmartlabs.dsround;

import java.util.LinkedList;

public class Graph {

  int vertices;

  LinkedList<Integer> adj[];

  Graph(int vertices) {
    this.vertices = vertices;
    adj = new LinkedList[vertices];
    for (int i = 0; i < vertices; i++) {
      adj[i] = new LinkedList<Integer>();
    }
  }

  public void addEdges(int v, int w) {
    adj[v].add(w);
  }

}
