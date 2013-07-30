package id.ac.itats.skripsi.shortestpath;

import id.ac.itats.skripsi.shortestpath.model.Edge;
import id.ac.itats.skripsi.shortestpath.model.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {

	private Vertex target;

//	public void computePaths(Vertex source, Vertex target) {
//		this.target = target;
//
//		PriorityQueue<Vertex> openList = new PriorityQueue<Vertex>();
//		PriorityQueue<Vertex> closedList = new PriorityQueue<Vertex>();
//
//		source.costG = 0.;
//		source.minDistance = source.costG
//				+ calcHeuristic(source, target);
//
//		openList.add(source);
//		source.onOpenList = true;
//
//		while (!openList.isEmpty()) {
//			Vertex current = openList.poll();
//			closedList.add(current);
//			current.onClosedList = true;
//
//			// currentNeighborhood
//			for (Edge e : current.adjacencies) {
//				Vertex next = e.target;
//
//				double tentativeG = current.costG + e.weight;
//
//				if (next.onClosedList && tentativeG >= next.costG) {
//					continue;
//				}
//				if (!next.onOpenList || tentativeG < next.costG) {
//					next.previous = current;
//					next.costG = tentativeG;
//					next.minDistance = next.costG
//							+calcHeuristic(next, target);
//
//					if (!next.onOpenList) {
//						openList.add(next);
//					}
//				}
//
//			}
//		}
//	}

//	public List<Vertex> getShortestPath() {
//		List<Vertex> path = new ArrayList<Vertex>();
//		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
//			path.add(vertex);
//
//		Collections.reverse(path);
//
//		return path;
//	}
//
//	private double calcHeuristic(Vertex source, Vertex target) {
//
//		double x = source.point.getX() - target.point.getX();
//		double y = source.point.getY() - target.point.getY();
//
//		return Math.sqrt(x * x + y * y);
//	}

}
