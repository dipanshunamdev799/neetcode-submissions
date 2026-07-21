class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word.charAt(0)==board[i][j]){
                    res = res || helper(board,i,j,1,word);
                }
            }
        }
        return res;
    }
    private boolean helper(char[][] board,int p,int q,int idx,String word){
        if(idx==word.length()) return true;
        int m = board.length;
        int n = board[0].length;

        boolean res = false;
        
        int[] up = new int[2];
        up[0] = p - 1;
        up[1] = q;
        if(isValid(up,board)){
            if(get(board,up)==word.charAt(idx)){
                return helper(board,up[0],up[1],idx+1,word);
            }else{
                res = res || false;
            }
        }


        int[] down = new int[2];
        down[0] = p + 1;
        down[1] = q;
        if(isValid(down,board)){
            if(get(board,down)==word.charAt(idx)){
                return helper(board,down[0],down[1],idx+1,word);
            }else{
                res = res || false;
            }
        }

        int[] left = new int[2];
        left[0] = p;
        left[1] = q-1;
        if(isValid(left,board)){
            if(get(board,left)==word.charAt(idx)){
                return helper(board,left[0],left[1],idx+1,word);
            }else{
                res = res || false;
            }
        }

        int[] right = new int[2];
        right[0] = p;
        right[1] = q+1;
        if(isValid(right,board)){
            if(get(board,right)==word.charAt(idx)){
                return helper(board,right[0],right[1],idx+1,word);
            }else{
                res = res || false;
            }
        }

        return res;
    }
    private boolean isValid(int[] coordinate,char[][] board){
        int row = coordinate[0];
        int col = coordinate[1];
        return (row>=0 && row<board.length) && (col>=0 && col<board[0].length);
    }
    private char get(char[][] board,int[] coordinate){
        int row = coordinate[0];
        int col = coordinate[1];
        return board[row][col];
    }
}
