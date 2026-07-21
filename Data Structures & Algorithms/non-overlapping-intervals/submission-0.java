class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        int prevStart = intervals[0][0];
        int n = intervals.length;
        for(int i=1; i<n; i++){
            if(prevEnd > intervals[i][0]){
                if( (prevEnd - prevStart) > (intervals[i][1] - intervals[i][0]) ){
                    prevEnd = intervals[i][1];
                    prevStart = intervals[i][0];
                }
                res++;
            }
        }
        return res;
    }
}