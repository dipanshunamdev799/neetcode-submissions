class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int updatedNewInterval[] = new int[2];
        updatedNewInterval[0] = newInterval[0];
        updatedNewInterval[1] = newInterval[1];
        while(i<n && newInterval[1] >= intervals[i][0]){
            updatedNewInterval[0] = Math.min(updatedNewInterval[0],intervals[i][0]);
            updatedNewInterval[1] = Math.max(updatedNewInterval[1],intervals[i][1]);
            i++;
        }
        res.add(updatedNewInterval);
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
