class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int m = matrix.length;
        int n = matrix[0].length;

        int lefti = 0;
        int righti = m;

        while(lefti<righti){
            int mid = (lefti+righti)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]>target) righti = mid -1;
            else lefti = mid;
        }

        int left = 0;
        int right = n;
        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[lefti][mid]==target) return true;
            else if(matrix[lefti][mid]>target) right = mid-1;
            else left = mid + 1;
        }
        return false;
    }
}
