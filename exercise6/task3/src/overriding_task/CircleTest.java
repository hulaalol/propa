package overriding_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircleTest {

	@Test
	void test() {
		Figure circle = new Circle(new Point(1,6),5);
		String description = "radius=5,center=(1,6)";
		assertEquals(description, circle.toString());
		
		double area = 78.54;
		assertEquals(area,circle.getArea());
		
		double perimeter = 31.42;
		assertEquals(perimeter,circle.getPerimeter());
		
		assertEquals(0,circle.getDistance(1,6));
		assertEquals(5.0,circle.getDistance(new Point(1,1)));
		assertEquals(1.41,circle.getDistance(new Circle(2,7,5)));
		
		
		
		
	}

}
