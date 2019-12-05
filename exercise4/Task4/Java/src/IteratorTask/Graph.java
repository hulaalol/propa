package IteratorTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * @author SOLA
 * Class representing a graph structure.
 * **/
public class Graph implements Iterable<Edge> {

	// Store vertices and their respective edges
	private Map<Integer, List<Integer>> vertex_edge_map = null;

	public Graph() {
		vertex_edge_map = new HashMap<>();
	}

	/**
	 * Function to add new vertex to the graph
	 */
	public void addVertex(int vertex) {
		if (!vertex_edge_map.containsKey(vertex)) {
			vertex_edge_map.put(vertex, new LinkedList<Integer>());
		}
	}

	/**
	 * Function to add new edge to the graph
	 */
	public void addEdge(Edge edge) {
		int source = edge.getSource();
		int destination = edge.getDestination();

		if (!vertex_edge_map.containsKey(source))
			addVertex(source);
		if (!vertex_edge_map.containsKey(destination))
			addVertex(destination);
		if (!vertex_edge_map.get(source).contains(destination))
			vertex_edge_map.get(source).add(destination);
	}

	@Override
	public Iterator<Edge> iterator() {
		return new GraphIterator(this);
	}

	private class GraphIterator implements Iterator<Edge> {

		public GraphIterator(Graph graph) {
			this.g = graph;
			this.sources = new Stack<Integer>();
			this.destinations = new Stack<Integer>();
			for (Integer s : graph.vertex_edge_map.keySet()) {
				this.sources.push(s);
			}
		}
		private Graph g;
		private Stack<Integer> sources;
		private int nextSource;
		private Stack<Integer> destinations;

		public Edge next() {
			while (destinations.isEmpty()) {
				this.nextSource = sources.pop();
				List<Integer> dest = g.vertex_edge_map.get(this.nextSource);
				for (Integer i : dest) {
					destinations.push(i);
				}
			}
			return new Edge(nextSource, destinations.pop());
		}

		public boolean hasNext() {
			return !(this.sources.isEmpty() && this.destinations.isEmpty());
		}
	}
}
