package overriding_task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void test() {
		Figure rectangle = new Rectangle(new Point(1, 6), 5, 6);

		String description = "starting=(1,6),length=5.0,width=6.0";
		assertEquals(description, rectangle.toString());

		assertEquals(30, rectangle.getArea());

		assertEquals(22, rectangle.getPerimeter());

		assertEquals(0, rectangle.getDistance(new Rectangle(new Point(1, 6), 5, 6)));

		assertEquals(11.05, rectangle.getDistance(new Point(12, 5)));
		assertEquals(6.08, rectangle.getDistance(7, 5));

	}

}
