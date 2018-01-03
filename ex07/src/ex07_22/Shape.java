package ex07_22;

public abstract class Shape {
	Point p;
	
	Shape(){
		this(new Point(0,0));
	}
	Shape(Point p){
		this.p=p;
	}
	
	abstract double calcArea();
	
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	
	
}
