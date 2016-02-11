/*
 * 
 * Graph - Breadth first search (BFS)
 * 
 * @author Chandni
 */

package graphImp;
import graphImp.AdjacencyList.NodeList;
import graphImp.AdjacencyList.graphNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {

	graphNode directedGraph;
	LinkedList visitedNodes = new LinkedList();

	public BFS(graphNode dg) {
		directedGraph = dg;
	}
	public void breadthFirst(int bVertex) {
		Queue q = new LinkedList();
		graphNode g = directedGraph;
		if(!visitedNodes.contains(bVertex)) {
			System.out.print(bVertex+"\t");
			visitedNodes.add(bVertex);
		}
		while(g.vertex != bVertex) {
			g = g.vList;
		}
		NodeList n = g.hList;
		while(n != null) {
			if(!visitedNodes.contains(n.dest)) {
				System.out.print(n.dest+"\t");

				visitedNodes.add(n.dest);
			}
			n = n.next;
		}
		if(!q.isEmpty()) {
			n = (NodeList) q.remove();
			//System.out.println("Calling for "+n.dest);
			breadthFirst(n.dest);
		}
	}

	public void depthFirst(int bVertex) {
		//Stack s = new Stack();
		graphNode g = directedGraph;
		if(!visitedNodes.contains(bVertex)) {
			System.out.print(bVertex+"\t");
			visitedNodes.add(bVertex);
		}
		while(g.vertex != bVertex) {
			g = g.vList;
		}
		//System.out.println("Adding to stack "+g.vertex);
		//s.add(g);
		NodeList n = g.hList;
		while(n != null) {
			if(!visitedNodes.contains(n.dest)) {
				//System.out.println("Calling for "+n.dest);
				depthFirst(n.dest);
			}
			//System.out.println("check "+n.dest+"\t"+g.vertex);
			n = n.next;
		}
	}


}
