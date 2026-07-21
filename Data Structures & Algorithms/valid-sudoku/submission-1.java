class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] sets = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            sets[i] = new HashSet<>();
        }

        for(int i=0; i<9; i+=3){
            HashSet<Character> localSet = new HashSet<>();
            for(int j=0; j<9; j++){
                if(j%3==0) localSet.clear();

                char x = board[i][j];
                if(x!='.'){
                    if(localSet.contains(x)) return false;
                    localSet.add(x);
                    if(sets[j].contains(x)) return false;
                    sets[j].add(x);
                }

                char y = board[i+1][j];
                if(y!='.'){
                    if(localSet.contains(y)) return false;
                    localSet.add(y);
                    if(sets[j].contains(y)) return false;
                    sets[j].add(y);
                }

                char z = board[i+2][j];
                if(z!='.'){
                    if(localSet.contains(z)) return false;
                    localSet.add(z);
                    if(sets[j].contains(z)) return false;
                    sets[j].add(z);
                }
            }
        }
        return true;
    }
}
