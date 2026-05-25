/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,Comparator.comparingInt(i -> i.start));
        int n = intervals.size();
        for(int i=0; i<n-1; i++){
            int nextStart = intervals.get(i+1).start;
            int end = intervals.get(i).end;
            if(end>nextStart){
                return false;
            }
        }
        return true;
    }
}
