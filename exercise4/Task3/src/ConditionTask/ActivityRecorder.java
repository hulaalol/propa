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

	public static int activityRecorder2(String[] activities, int year) {
		int total = 0;
		for (String activity : activities) {
			switch (activity) {
			case "TypeA":
				total += 7;
			case "TypeC":
				total += 6;
			case "TypeE":
			case "TypeG":
			case "TypeH":
				total += 4;
			case "TypeJ":
			case "TypeL":
				total += 3;
				break;
			case "TypeD":
				total += 0;
			case "TypeF":
				total += 1;
			case "TypeI":
			case "TypeK":
				total += 9;
				break;
			case "TypeB":
				if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
					total += 3;
				else
					total += 2;
				break;
			default:
				total = 20;
				break;
			}
		}

		return total;
	}

}
