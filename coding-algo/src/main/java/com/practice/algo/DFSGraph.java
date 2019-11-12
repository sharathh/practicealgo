import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

class DFSGraph {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    List<String> vertices = new LinkedList<String>();
    vertices.add("a");
    vertices.add("b");
    vertices.add("c");
    vertices.add("d");
    vertices.add("e");
    vertices.add("f");

    Graph g = new Graph(vertices);
    g.addGraphEdge("a", "b");
    g.addGraphEdge("b", "a");
    g.addGraphEdge("b", "c");
    g.addGraphEdge("b", "d");
    g.addGraphEdge("e", "f");
    g.addGraphEdge("f", "e");

    dfs(g);
    dfsFromNode("b",g);

  }

  public static void dfs(Graph g) {
    List<String> vertices = g.vertices;
    Map<String,Boolean> visited = new HashMap();
    for(String vertex: vertices){
      //not visited
      if(visited.get(vertex) == null){
        visit(vertex,visited, g);
      }
    }
  }

  public static void dfsFromNode(String vertex,Graph g) {
    Map<String,Boolean> visited = new HashMap();
    visit(vertex,visited, g);
  }

  public static void visit(String vertex,Map visited,Graph g) {
    //mark visited
    visited.put(vertex, true);
    System.out.println(vertex);
    //get all connections
    List edges = (List)g.getEdges(vertex);
    // System.out.println(edges);
    for(int i=0 ; i< edges.size();i++){
      if(visited.get((String)edges.get(i)) == null){
        visit((String)edges.get(i) , visited , g);
      }
    }
  }
}

class Graph{
  List<String> vertices;
  Map<String,List> edges;
  Graph(List<String> vertices){
    this.vertices = vertices;
    edges = new HashMap();
    for(int i=0 ; i< vertices.size() ; i++) {
        edges.put(vertices.get(i), new LinkedList<String>());
    }
  }
  public void addGraphEdge(String vertex , String value){
    if(edges.get(vertex)!= null){
      (edges.get(vertex)).add(value);
    }
  }

  public List getEdges(String vertex){
    return edges.get(vertex);
  }
}
