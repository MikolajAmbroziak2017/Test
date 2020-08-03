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
        //if it's first vertices to check and there is no graph
        // object in list, checked vertices become a first graph
        if (graphs.size() == 0)
            graphs.add(new Graph(verticesToCheck));
        else {
            int size = graphs.size();
            boolean isNewGraph = false;

            // looking for graph with the same vertex
            for (int i = 0; i < size; i++) {

                //if exist vertices will be add to graph, else will be created new one
                if (graphs.get(i).isVerticesExistInGraph(verticesToCheck)) {
                    graphs.get(i).addVert(verticesToCheck);
                    isNewGraph = false;
                    break;
                } else {
                    isNewGraph = true;
                }
            }

            if (isNewGraph)
                graphs.add(new Graph(verticesToCheck));
        }
    }

    public void firstVerticleAdd(int firstVer) {
        ArrayList<Integer> template = new ArrayList<>();
        ArrayList<Graph> graphsToDelete = new ArrayList<>();
        for (Graph g : graphs) {

            if (g.isfirstVertInGraph(firstVer)) {
                g.getGraphVertices().forEach(integer -> template.add(integer));
                graphsToDelete.add(g);
            }
        }
        for (Graph g : graphsToDelete) {
            graphs.remove(g);
        }
        graphs.add(new Graph(template));
    }

    public int countGraph() {
        return graphs.size();
    }
}
