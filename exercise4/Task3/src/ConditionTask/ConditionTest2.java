package ConditionTask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConditionTest2 {

	@Test
	void test() {
		String[] activities = {"TypeA","TypeC"};
		int year = 2020;
		int result = ActivityRecorder.activityRecorder(activities, year);
		
		assertEquals(result, 33);
	}

}
