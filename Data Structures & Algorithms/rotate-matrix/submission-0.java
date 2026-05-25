class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //Transpose
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse the rows -- clockwise
        //Reverse the columns -- anticlockwise
        for(int i=0; i<n; i++){
            int jmin = 0;
            int jmax = n-1;
            while(jmin<jmax){
                int temp = matrix[i][jmin];
                matrix[i][jmin] = matrix[i][jmax];
                matrix[i][jmax] = temp;
                jmax--;
                jmin++;
            }
        }
    }
}
