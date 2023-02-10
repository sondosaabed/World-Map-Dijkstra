package application;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
 * This class is Dijkstra solution that uses priority queue
 */
public class Dijkstra {
    // fields
	private double distance;
	private PriorityQueue<Vertex> vertexQueue;
	private List<Vertex> path;
	private List<Country> pathCountries;

	public Dijkstra(Vertex source, Vertex target) {
		getShortestDistance(source,target);
	}
	
	private void getShortestDistance(Vertex source, Vertex target) {
	    computePaths(source);
		getShortestPathTo(target);
	    setDistance(target.getMinDistance());
	}
	
	public void computePaths(Vertex source) {
        // Compute the paths of the source 
		source.setMinDistance(0);
        
        vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            for (Edge e : u.getAdjacencies()) {
                Vertex v = e.getTarget();
                double weight = e.getWeight();
                double distanceThroughU = u.getMinDistance() + weight;
                if (distanceThroughU < v.getMinDistance()) {
                    vertexQueue.remove(v);
                    v.setMinDistance(distanceThroughU);
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }				
            }
        }
    }
    
	public List<Vertex> getShortestPathTo(Vertex target) {
		// Return the shortest path vertices
        path = new ArrayList<>();
        pathCountries = new ArrayList<>();

        for (Vertex vertex = target; vertex != null; vertex = vertex.getPrevious()) {
            path.add(0, vertex);
        	pathCountries.add(0, vertex.getLocation());
        }
        return path;
    }
    /*
     * Getters and setters
     */
	public List<Country> getPathCountries() {
		return pathCountries;
	}

	public void setPathCountries(List<Country> pathCountries) {
		this.pathCountries = pathCountries;
	}
	
	public List<Vertex> getPath() {
		return path;
	}

	public void setPath(List<Vertex> path) {
		this.path = path;
	}
	
	public PriorityQueue<Vertex> getVertexQueue() {
		return vertexQueue;
	}

	public void setVertexQueue(PriorityQueue<Vertex> vertexQueue) {
		this.vertexQueue = vertexQueue;
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}