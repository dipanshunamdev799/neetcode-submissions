class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        int n = intervals.length;
        for(int i=1; i<n; i++){
            //overlap check
            if(prevEnd > intervals[i][0]){
                if( prevEnd > intervals[i][1]  ){
                    prevEnd = intervals[i][1];
                }
                res++;
            }else{
                prevEnd = intervals[i][1];
            }
        }
        return res;
    }
}