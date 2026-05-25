class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        int res = 0;
        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int[] interval = intervals[i];
            if(prevEnd > interval[0]){
                //overlap
                if(prevEnd > interval[1]){
                    //remove the previous one
                    prevEnd = interval[1];
                }
                //overlap implies remove one
                res++;
            }else{
                //not overlapping
                prevEnd = interval[1];
                //just updating the prevEnd
            }
        }
        return res;
    }
}
