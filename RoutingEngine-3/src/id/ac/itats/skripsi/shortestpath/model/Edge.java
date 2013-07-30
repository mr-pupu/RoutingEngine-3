package id.ac.itats.skripsi.shortestpath.model;

public class Edge {
	public final String id;
	public final Vertex target;
	public final double weight;
	
	public Edge(String argId, Vertex argTarget, double argWeight) {
		id = argId;
		target = argTarget;
		weight = argWeight;
		
	}

	@Override
	public String toString() {
		return "Edge [id=" + id + ", target=" + target + ", weight=" + weight
				+ "]";
	}
	
	
}
