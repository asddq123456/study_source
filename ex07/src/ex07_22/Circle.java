package ex07_22;

public class Circle extends Shape {

	double r;

	Circle(){		
		this(0,0,100);
	}
	Circle(double r){
		this.r=r;
	}
	Circle(Point p, double r){
		super(p);
		this.r=r;
	}
	Circle(int x, int y, double r){
		super(new Point(x,y));
		this.r=r;
	}
	
	@Override
	double calcArea() {
		return r * r * Math.PI;
	}

}
