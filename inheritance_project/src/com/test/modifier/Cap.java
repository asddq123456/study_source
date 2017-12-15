package com.test.modifier;

public class Cap {
	
	private int x;
	private int y;
	private int z;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		if(x>=10){
			this.x=10;
		}else{
			this.x = x;
		}			
		
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		if(y>=10){
			this.y=10;
		}else{
			this.y = x;
		}	
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		if(z>=10){
			this.z=10;
		}else{
			this.z = z;
		}	
	}
	
	
	
}
