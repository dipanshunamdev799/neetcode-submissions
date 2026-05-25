class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        for(int i=0; i<n; i++){
            if(res.size()==0){
                res.add(intervals[i]);
            }else{
                int [] interval = res.get(res.size()-1);
                if(interval[1]>= intervals[i][0]){
                    interval[0] = Math.min(interval[0],intervals[i][0]);
                    interval[1] = Math.max(interval[1],intervals[i][1]);
                    res.set(res.size()-1,interval);
                }else{
                    res.add(intervals[i]);
                }
            }
        }
        return res.toArray(new int[res.size()][]);       
    }
}
