package id.ac.itats.skripsi.shortestpath.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Graph {
	List<Edge> edges = new LinkedList<Edge>();
	private HashMap<Long, Vertex> vertices = new HashMap<Long, Vertex>();

	public void addEdge(String edgeId, long fromNode, long toNode, double weight) {
		Vertex fromVertex = vertices.get(fromNode);
		if (fromVertex == null) {
			fromVertex = new Vertex(fromNode);
			vertices.put(fromNode, fromVertex);
		}
		Vertex toVertex = vertices.get(toNode);
		if (toVertex == null) {
			toVertex = new Vertex(toNode);
			vertices.put(toNode, toVertex);
		}
		Edge edge = new Edge(edgeId, toVertex, weight);
		fromVertex.adjacencies.add(edge);
		edges.add(edge);
	}

	public int getSize() {
		return vertices.size();
	}

	public Collection<Vertex> getVerticeValues() {
		return vertices.values();
	}

	public Collection<Edge> getEdges() {

		return edges;
	}

	public Vertex fromVertex(String id) {

		return vertices.get(id);
	}

	public Vertex toVertex(String id) {
		return vertices.get(id);
	}

	// princeton
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
}
