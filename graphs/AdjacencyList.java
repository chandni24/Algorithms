/*
 * 
 * Graph - Adjacency List 
 * 
 * @author Chandni
 */

package graphImp;
import java.util.Scanner;


public class AdjacencyList {

	graphNode directedGraph = new graphNode();
	public class NodeList{
		int dest;
		NodeList next = null;
	}
	
	public class graphNode {
		int vertex;
		graphNode vList = null;
		NodeList hList = null;
	}
	public static void main(String[] args) throws Exception {
		
		AdjacencyList al = new AdjacencyList();
		Scanner sc = new Scanner(System.in); 
		int data;
		
		//al.directedGraph.vertex = sc.nextInt();
		//al.addEdge(sc.nextInt(), sc.nextInt());
		
		al.directedGraph.vertex = 0;
		al.addEdge(0, 1);
		al.addEdge(0, 2);
		al.addEdge(1, 2);
		al.addEdge(2, 0);
		al.addEdge(2, 3);
		al.addEdge(3, 3);
		al.addEdge(2, 4);
		al.addEdge(4, 3);
		al.addEdge(4, 5);
		
		al.printGraph();
		
		BFS bfs = new BFS(al.directedGraph);
		//System.out.println("\n\nPrinting breadth first with first vertex");
		//bfs.breadthFirst(2);
		System.out.println("\n\nPrinting depth first with first vertex");
		bfs.depthFirst(2);
	}

	public void addEdge(int a, int b) {
		graphNode g;
		if((g = vertexPresent(b)) == null)
			g = addVertex(b);
		if((g = vertexPresent(a)) == null)
			g = addVertex(a);
		System.out.println("Adding edge "+g.vertex+" and "+b);
		addEdgeVertex(g, b);
		
	}
	
	public graphNode vertexPresent(int v) {
		graphNode g = directedGraph;
		//System.out.println("Checking node "+n.vertex);
		while(g != null) {
			//System.out.println("Checking node "+g.vertex);
			if(g.vertex == v)
				return g;
			g = g.vList;
		}
		return null;
	}
	
	public graphNode addVertex(int a) {
		System.out.println("Adding vertex "+a);
		graphNode g1 = new graphNode();
		g1.vertex = a;
		graphNode g = directedGraph;
		while(g.vList != null)
			g = g.vList;
		g.vList = g1;
		return g1;
	}
	
	public void addEdgeVertex(graphNode node, int b) {
		NodeList n = node.hList;
		if (n==null) {
			node.hList = new NodeList();
			node.hList.dest = b;
			return;
		}
		while(n.next != null) {
			n = n.next;
		}
		NodeList n1 = new NodeList();
		n1.dest = b;
		n.next = n1;
	}

	public void printGraph() {
		System.out.println("\nPrinting graph");
		graphNode vl = directedGraph;
		while(vl != null) {
			System.out.println("Adjacent vertices for node "+vl.vertex+":");
			NodeList hl = vl.hList;
			while(hl != null) {
				System.out.print(hl.dest+"\t");
				hl = hl.next;
			}
			System.out.println();
			vl = vl.vList;
		}
	}
}
