package application;
/*
 * Creates a country and saves it's information
 */
public class Country {
	//Fields
	private String name;
	private int x;
	private int y;
    
	public Country(String string) {
		this.name=string;
	}
	
	public Country(String anme, int x,int y) {
		setName(anme);
		setX(x);
		setY(y);
	}
	
	@Override
	public String  toString() {
		return name +", " +x +", "+y;
	}
	/*
	 * Getters and Setters
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}

	public void setX(int logitude) {
		this.x = logitude;
	}

	public int getY() {
		return y;
	}

	public void setY(int latitude) {
		this.y = latitude;
	}
}