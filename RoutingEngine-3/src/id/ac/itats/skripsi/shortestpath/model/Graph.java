package id.ac.itats.skripsi.shortestpath.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Graph {
	List<Edge> edges = new LinkedList<Edge>();
	private HashMap<Long, Vertex> vertices = new HashMap<Long, Vertex>();
	
	public void addEdge(String edgeId, long fromNode, String fromLat, String fromLon, long toNode, String toLat, String toLon, double weight) {
		Vertex fromVertex = vertices.get(fromNode);
		if (fromVertex == null) {
			fromVertex = new Vertex(fromNode, fromLat, fromLon);
			vertices.put(fromNode, fromVertex);
		}
		Vertex toVertex = vertices.get(toNode);
		if (toVertex == null) {
			toVertex = new Vertex(toNode, toLat, toLon);
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

	public Vertex getVertex(long id) {

		return vertices.get(id);
	}

}
