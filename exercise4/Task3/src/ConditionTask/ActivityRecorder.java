package ConditionTask;

public class ActivityRecorder {

	public static int activityRecorder(String[] activities, int year) {

		int total = 0;
		for (String activity : activities) {

			if (activity.equals("TypeA")) {
				total += 7 + 6 + 4 + 3;
				continue;
			}

			if (activity.equals("TypeC")) {
				total += 6 + 4 + 3;
				continue;
			}

			if (activity.equals("TypeE") || activity.equals("TypeG") || activity.equals("TypeH")) {
				total += 4 + 3;
				continue;
			}

			if (activity.equals("TypeJ") || activity.equals("TypeL")) {
				total += 3;
				continue;
			}

			if (activity.equals("TypeD") || activity.equals("TypeF")) {
				total += 1 + 9;
				continue;
			}

			if (activity.equals("TypeK")) {
				total += 9;
				continue;
			}

			if (activity.equals("TypeB")) {
				if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
					total += 3;
				} else {
				}
				total += 2;
				continue;
			}
			
			total +=20;
		}
		return total;

	}
}
