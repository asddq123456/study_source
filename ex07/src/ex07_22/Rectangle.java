package ex07_22;

public class Rectangle extends Shape {

	double width;
	double height;

	Rectangle() {
		this(new Point(0, 0), 100, 100);
	}

	Rectangle(Point p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}

	boolean isSquare() {
		return width != 0 && height != 0 && width == height;
	}

	@Override
	double calcArea() {		
		return width*height;
	}

}





