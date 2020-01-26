package overriding_task;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class Rectangle extends Figure {
	private Point start;
	private int length;
	private int width;

	public Rectangle(Point start, int length, int width) {
		this.start = start;
		this.length = length;
		this.width = width;
	}

	@Override
	public double getDistance(Figure figure) {
		return figure.getDistance(this.start);
	}

	@Override
	public double getDistance(int x, int y) {
		double r = Math.sqrt( Math.pow(x - this.start.getX(),2) + Math.pow(y - this.start.getY(), 2));
		return Math.round(r*100.0)/100.0;
	}

	@Override
	public double getDistance(Point toCompare) {
		return getDistance(toCompare.getX(), toCompare.getY());
	}

	@Override
	public double getArea() {
		double r = this.length * this.width;
		return Math.round(r*100.0)/100.0;
	}

	@Override
	public String toString() {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
		otherSymbols.setDecimalSeparator('.');
		DecimalFormat format = new DecimalFormat("0.0",otherSymbols);
		
		return "starting=("+this.start.getX()+","+this.start.getY()+"),length="+format.format(this.length)+",width="+format.format(this.width);
	}

	@Override
	public double getPerimeter() {
		double r = (2*this.length + 2*this.width);
		return Math.round(r*100.0)/100.0;
	}
	
	public Point getStart() {
		return this.start;
	}

	

}
