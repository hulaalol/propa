package overriding_task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Circle extends Figure {
	private Point center;
	private int radius;

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(int x, int y, int radius) {
		this.center = new Point(x, y);
		this.radius = radius;
	}

	public Point getCenter() {
		return this.center;
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public double getDistance(Figure figure) {
		return figure.getDistance(this.center);
	}

	@Override
	public double getDistance(int x, int y) {
		double r = Math.sqrt( Math.pow(x - this.center.getX(),2) + Math.pow(y - this.center.getY(), 2));
		return Math.round(r*100.0)/100.0;
	}

	@Override
	public double getDistance(Point toCompare) {
		return getDistance(toCompare.getX(), toCompare.getY());
	}

	@Override
	public double getArea() {
		double r = Math.PI * Math.pow(this.radius,2);
		return Math.round(r*100.0)/100.0;
	}

	@Override
	public String toString() {
		return "radius="+this.radius+",center=("+this.center.getX()+","+this.center.getY()+")";
	}

	@Override
	public double getPerimeter() {
		double r = 2*Math.PI*this.radius;
		return Math.round(r*100.0)/100.0;
	}
	
	

}
