/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        boolean[] time = new boolean[1000000];

        for (Interval i: intervals) {
            for (int j = i.start; j < i.end; j++) {
                if (time[j]) {
                    return false;
                } else {
                    time[j] = true;
                }
            }
        }

        return true;
    }
}