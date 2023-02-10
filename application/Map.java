package application;

import java.util.ArrayList;
/*
 *  This class creates a map that contains a list of vertices a vertex is a country which has many adjacent (edges)
 */
public class Map {
	// fields 
	private ArrayList<Vertex> vertices;
	
	public Map() {
		vertices = new ArrayList<>();
	}
	
	public void add(Vertex c) {
		// add a new vertex
		vertices.add(c);
	}
	
	public boolean search(Country country) {
		// check if the country is in the map or not
		for (int i=0; i<vertices.size();i++) {
			if(vertices.get(i).getLocation().getName().equals(country.getName()))
				return true;
		}
		return false;
	}
	
	public Vertex getVertex(Country country) {
		// search for the country and return it
		for (int i=0; i<vertices.size();i++) {
			if(vertices.get(i).getLocation().getName().equals(country.getName()))
				return vertices.get(i);
		}
		return null;
	}
	/*
	 * Getters and Setters
	 */
	public ArrayList<Vertex> getVetices() {
		return vertices;
	}
	public void setVetices(ArrayList<Vertex> vetices) {
		this.vertices = vetices;
	}
}