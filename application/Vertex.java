package application;

import java.util.ArrayList;
import java.util.List;
/*
 * This class creates a vertex and initialize its minimum distance to positive infinity
 */
public class Vertex implements Comparable<Vertex>{
    // fields
	private double minDistance = Double.POSITIVE_INFINITY;
    private Vertex previous;
    private List<Edge> adjacencies;
    private Country location;

    public Vertex(Country location) {
        this.setLocation(location);
        this.setAdjacencies(new ArrayList<>());
    }
    
    @Override
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
	
	@ Override
    public String toString() {
    	return location.toString();
    }
	/*
	 * Getters and setters
	 */
	public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public void setAdjacencies(List<Edge> adjacencies) {
		this.adjacencies = adjacencies;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public Country getLocation() {
		return location;
	}

	public void setLocation(Country location) {
		this.location = location;
	}
}