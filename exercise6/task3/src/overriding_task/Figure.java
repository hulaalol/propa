package overriding_task;

public abstract class Figure {
	public Figure() {
		
	}

	
	// abstract methods required by the subclasses to implement
	public abstract double getDistance(Figure figure);
	public abstract double getDistance(int x, int y);
	public abstract double getDistance(Point toCompare);
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract String toString();
	

}
