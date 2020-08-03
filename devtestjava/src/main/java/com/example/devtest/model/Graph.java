package com.example.devtest.model;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Integer> graphVertices;

    public Graph(int[] ver) {
        this.graphVertices = new ArrayList<>();
        graphVertices.add(ver[0]);
        graphVertices.add(ver[1]);
    }

    public ArrayList<Integer> getGraphVertices() {
        return graphVertices;
    }

    private void setGraphVertices(ArrayList<Integer> graphVertices) {
        this.graphVertices = graphVertices;
    }

    public boolean isVerticesExistInGraph(int[] vertices) {
        for (int i=0;i<graphVertices.size();i++) {
            if (graphVertices.get(i) == vertices[0])
                return true;
            if (graphVertices.get(i) == vertices[1])
                return true;
        }
        return false;
    }

        public boolean firstVertIsInGraph (int firstVert){
            if (graphVertices.stream().filter(integer -> integer == firstVert).findFirst().isPresent())
                return true;
            return false;
        }
        public void addVert(int[] vertices){
            graphVertices.add(vertices[0]);
            graphVertices.add(vertices[1]);
        }
    }
