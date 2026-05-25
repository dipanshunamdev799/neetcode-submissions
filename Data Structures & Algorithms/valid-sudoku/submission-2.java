class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] setsColumn = new HashSet[9];
        for (int i = 0; i < 9; i++) setsColumn[i] = new HashSet<>();

        HashSet<Character>[] setsRow = new HashSet[3];
        for(int j=0; j<3; j++) setsRow[j] = new HashSet<>();

        HashSet<Character> localSet = new HashSet<>();

        for(int i=0; i<9; i+=3){

            localSet.clear();
            
            for(int j=0; j<3; j++) setsRow[j].clear();

            for(int j=0; j<9; j++){
                if(j%3==0) localSet.clear();

                char x = board[i][j];

                if(x!='.'){
                    if(localSet.contains(x)) return false;
                    localSet.add(x);
                    if(setsColumn[j].contains(x)) return false;
                    setsColumn[j].add(x);
                    if(setsRow[i%3].contains(x)) return false;
                    setsRow[i%3].add(x);
                }

                char y = board[i+1][j];
                if(y!='.'){
                    if(localSet.contains(y)) return false;
                    localSet.add(y);
                    if(setsColumn[j].contains(y)) return false;
                    setsColumn[j].add(y);
                    if(setsRow[(i+1)%3].contains(y)) return false;
                    setsRow[(i+1)%3].add(y);
                }

                char z = board[i+2][j];
                if(z!='.'){
                    if(localSet.contains(z)) return false;
                    localSet.add(z);
                    if(setsColumn[j].contains(z)) return false;
                    setsColumn[j].add(z);
                    if(setsRow[(i+2)%3].contains(z)) return false;
                    setsRow[(i+2)%3].add(z);
                }
            }
        }
        return true;
    }
}
