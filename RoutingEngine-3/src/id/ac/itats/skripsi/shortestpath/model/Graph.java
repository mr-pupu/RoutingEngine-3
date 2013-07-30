package id.ac.itats.skripsi.shortestpath.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.vividsolutions.jts.geom.Point;

public class Graph {
	private HashMap<String, Vertex> vertices = new HashMap<String, Vertex>();
	private List<Edge> edges = new LinkedList<Edge>();

	public void addEdge(String edgeId, String source, Point sourcePoint, String target, Point targetPoint, double weight ) {
		Vertex fromVertex = vertices.get(source);
		if (fromVertex == null) {
			fromVertex = new Vertex(source,sourcePoint);
			vertices.put(source, fromVertex);
		}
		Vertex toVertex = vertices.get(target);
		if (toVertex == null) {
			toVertex = new Vertex(target, targetPoint);
			vertices.put(target, toVertex);
		}
		Edge edge = new Edge(edgeId, toVertex, weight);
		edges.add(edge);
		fromVertex.adjacencies.add(edge);
		
	}

	public int getSize() {
		return this.vertices.size();
	}

	public Vertex toVertex(String id) {
		return vertices.get(id);
	}

	public HashMap<String, Vertex> getVertices() {
		return vertices;
	}

	public Collection<Vertex> getVerticesValue() {
		return vertices.values();
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
}
