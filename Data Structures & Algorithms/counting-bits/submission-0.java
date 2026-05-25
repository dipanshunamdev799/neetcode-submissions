class Solution {
    public int[] countBits(int n) {
        int count[] = new int[n+1];
        count[0] = 0;
        for(int i=1; i<=n; i++){
            count[i] = count[i>>1] + (i&1);
        }
        return count;
    }
}
