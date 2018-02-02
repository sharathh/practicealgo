package com.practice.algo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFSGraph {

    private int vertices;
    private LinkedList<Integer>[] adjacenyList;

    public BFSGraph(int vertices) {
        this.vertices = vertices;
        adjacenyList = new LinkedList[vertices];
        for(int i=0 ; i< vertices ; i++) {
            adjacenyList[i] = new LinkedList<Integer>();
        }
    }

    public void addGraphEdge(int vertex , int value){
        //TODO check for null if
        adjacenyList[vertex].add(value);
    }
    public void printBFSGraphFromGivenVertex(int sourceVertex) {
        //initialize with false for vertex not visited
        boolean visitedVertex[] = new boolean[vertices];
        LinkedList<Integer> bfsQueue = new LinkedList<Integer>();
        //the source vertex is marked as visited
        visitedVertex[sourceVertex] = true;
        bfsQueue.add(sourceVertex);

        while(bfsQueue.size() != 0){
            int queueElement = bfsQueue.poll();
            System.out.println(queueElement + " ");
            //get the respective adjacent vertices
            if(adjacenyList[sourceVertex] != null){
                Iterator<Integer> adjVertices =adjacenyList[sourceVertex].listIterator();
                while(adjVertices.hasNext()){
                    int num = adjVertices.next();
                    if(!visitedVertex[num]){
                        visitedVertex[num] = true;
                        bfsQueue.add(num);
                    }
                }
            }

        }
    }
    public static void main(String[] args) {

        BFSGraph graph = new BFSGraph(4);
        graph.addGraphEdge(0,1);
        graph.addGraphEdge(0,2);
        graph.addGraphEdge(1,2);
        graph.addGraphEdge(2,0);
        graph.addGraphEdge(2,3);
        graph.addGraphEdge(3,3);

        int startVertex = 2;
        System.out.println("BFS Traversal for the given input graph starting from :"+startVertex);
        graph.printBFSGraphFromGivenVertex(startVertex);
    }
}
