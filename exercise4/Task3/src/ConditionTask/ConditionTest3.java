package ConditionTask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConditionTest3 {

	@Test
	void test() {
		String[] activities = {"TypeX","TypeY"};
		int year = 2020;
		int result = ActivityRecorder.activityRecorder(activities, year);
		
		assertEquals(result, 40);
	}

}
