class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();

        for(int i=0; i<board.length; i++){

            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();

            if(i%3==0){
                s1.clear();
                s2.clear();
                s3.clear();
            }

            for(int j=0; j<board.length; j++){
                
                int y = Integer.valueOf(board[j][i]);
                int x = Integer.valueOf(board[i][j]);

                if(x!=46){
                if(j<3){
                    if(s1.contains(x)) return false;
                    s1.add(x);
                }else if(j<6){
                    if(s2.contains(x)) return false;
                    s2.add(x);
                }else{
                    if(s3.contains(x)) return false;
                    s3.add(x);
                }

                }

                if(x!=46 && row.contains(x)) return false;
                if(y!=46 && col.contains(y)) return false;
                if(x!=46)row.add(x);
                if(y!=46)col.add(y);
            }
        }

        return true;

    }
}
