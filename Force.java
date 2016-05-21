package main;

public class Force {
	public int d; 	//direction in degrees
					//direction is measured starting from "right" and counter-clockwise
					//someone please tell me the actual standard for measuring angle
	public int m; 	//magnitude in Newtons
	public int x;
	public int y;
	
	public Force() {}
	
	public Force(int x, int y, int d, int m) {
		this.x = x;
		this.y = y;
		d = d;
		m = m;
	}
}
