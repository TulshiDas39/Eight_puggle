package clone;

import java.awt.Color;

public class Puzzle implements Cloneable{
 
	private int x;
	private int y;
	private int radius;
	private String number;
	private Color color;
	
	public Puzzle(int x, int y, int radius,String number, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		this.number = number;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	} 
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public String getNumber(){
		return this.number;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
