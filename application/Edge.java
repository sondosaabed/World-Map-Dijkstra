package application;
/*
 * This class creates an edge for the map
 */
public class Edge {
    // fields
	private Vertex target;
    private double weight;

    public Edge(Vertex target, double weight) {
        this.target = target;
        this.weight = weight;
    }
    
    @ Override
    public String toString() {
    	return target + "" +weight;
    }
    /*
     * Getters and Settres
     */
	public double getWeight() {
		return weight;
	}

	public Vertex getTarget() {
		return target;
	}
}