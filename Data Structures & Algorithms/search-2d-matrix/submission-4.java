class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        boolean res = false;

        int m = matrix.length;
        int n = matrix[0].length;

        int lefti = 0;
        int righti = m-1;
        int row = -1;

        while(lefti<=righti){
            int mid = (lefti+righti)/2;
            if(matrix[mid][0]<=target && matrix[mid][n-1]>=target){
                row = mid;
                break;
            }
            else if(matrix[mid][n-1]<target) lefti = mid + 1;
            else if(matrix[mid][0] > target) righti = mid - 1;
            else return false;
        }

        if(row==-1) return false;

        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]>target) right = mid-1;
            else left = mid + 1;
        }

        return false;
    }
}
