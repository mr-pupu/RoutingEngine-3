package id.ac.itats.skripsi.shortestpath.model;

import java.util.LinkedList;

import com.vividsolutions.jts.geom.Point;

public class Vertex implements Comparable<Vertex> {
	public final String name;
	public final Point point;

	public LinkedList<Edge> adjacencies = new LinkedList<Edge>();
	public double minDistance = Double.POSITIVE_INFINITY;
	public double costG = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public boolean onOpenList;
	public boolean onClosedList;

	

	public Vertex(String argName, Point argPoint) {
		name = argName;
		point = argPoint;
		onOpenList = false;
		onClosedList = false;
	}

	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

}
