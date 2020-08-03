package com.example.devtest.Utility;

import com.example.devtest.model.Graph;

import java.util.ArrayList;
import java.util.Optional;

public class GraphCounter {
    private ArrayList<Graph> graphs;

    public GraphCounter() {
        this.graphs = new ArrayList<>();
    }

    public void setNewVertices(int[] verticesToCheck) {
        if (graphs.size() == 0)
            graphs.add(new Graph(verticesToCheck));
        else {
            for (int i = 0; i < graphs.size(); i++) {
                if (graphs.get(i).isVerticesExistInGraph(verticesToCheck)) {
                    graphs.get(i).addVert(verticesToCheck);
                    break;
                }else{
                    graphs.add(new Graph(verticesToCheck));

                }
            }
        }
    }

    public void firstVerticleAdd(int firstVer) {
        ArrayList<Integer> template = new ArrayList<>();
        for (Graph g : graphs) {
            if (g.firstVertIsInGraph(firstVer)) {
                if (g.getGraphVertices().get(0) == firstVer)
                    template.add(g.getGraphVertices().get(1));
                if (g.getGraphVertices().get(1) == firstVer)
                    template.add(g.getGraphVertices().get(0));
                graphs.remove(g);
            }
            template.add(firstVer);
        }
    }

    public int countGraph() {
        return graphs.size();
    }
}
