package id.ac.itats.skripsi.shortestpath.model;

import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {

	public LinkedList<Edge> adjacencies = new LinkedList<Edge>();

	public double minDistance = Double.POSITIVE_INFINITY;

	public Vertex previous;

	private final long id;

	public Vertex(long node) {
		this.id = node;
	}

	public String toString() {
		return "" + id;
	}

	public int compareTo(Vertex other) {

		return Double.compare(minDistance, other.minDistance);
	}

}
