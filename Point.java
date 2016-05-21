package main;

import java.util.HashSet;

/*
 * The point class is the parent class of all objects in this PE.
 * The reason being is that every object will have an origin.
 * The area that it encompasses will be calculated from the origin.
 * This approach is an attempt to avoid using a grid to represent area.
 */


public class Point {
	
	private int x;
	private int y;
	private HashSet<Force> forces;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//must be overridden every time
	public boolean area(int testx, int testy) { //lol testies
		return x == testx && y == testy;
	}
	
	//adds a force to act upon the object
	public void addForce(Force f) throws InvalidCoordinate {
		if(area(f.x,f.y)) {
			forces.add(f);
		} else {throw new InvalidCoordinate();}
	}
	
	public void removeForce(Force f) {
		forces.remove(f);
	}
	
	
	//move method for a point
	//will be overridden for each child class
	//this setup is tentative, maybe I'll figure out a way to make a universal move method
	public void move(int time) { //time in seconds
		
		int ysum = 0;
		int xsum = 0;
		for(Force f : forces) {
			xsum += f.m*Math.cos(f.d);
			ysum += f.m*Math.sin(f.d);
		}
		
		x += xsum*time;
		y += ysum*time;
	}
	
}
