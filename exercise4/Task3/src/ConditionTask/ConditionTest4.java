package ConditionTask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConditionTest4 {

	@Test
	void test() {
		String[] activities = {"TypeD","TypeA","TypeF"};
		int year = 2020;
		int result = ActivityRecorder.activityRecorder(activities, year);
		
		assertEquals(result, 40);
	}

}
