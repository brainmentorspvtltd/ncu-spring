package com.brainmentors.apps.configdemo;

public class B implements IB{ 
	private int x;
	private int y;
	static int z ;
	static {
		z = 1000;
	}
	private B(){
		x = z + 10;
	}
	B(int y){
		this();
		this.y = this.x + z + y;
	}
	@Override
	public void calc() {
		y = y + x + x + z;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public void print() {
		System.out.println("B Print "+x + " "+y +" "+z);
	}
	

}
