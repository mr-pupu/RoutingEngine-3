package id.ac.itats.skripsi.shortestpath;

import id.ac.itats.skripsi.shortestpath.model.Vertex;


public interface AStarHeuristic {

	public double calcHeuristic(Vertex source, Vertex target);
}
