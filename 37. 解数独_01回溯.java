class Solution {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean flag = false;
    private List<int[]> space = new ArrayList<int[]>();
    /*
        1.List是一个接口，而ArrayList是一个类，它实现了List接口。
        所以List不能被构造，List list=new List()这种写法是错误的，而ArrayList就可以被构造。
        List list = new ArrayList();这句创建了一个ArrayList的对象后把向上转型成了List。此时它是一个List对象了，
        有些ArrayList有但是List没有的属性和方法，它就不能再用了。
        而ArrayList list=new ArrayList();创建一对象则保留了ArrayList的所有属性。


        2.ArrayList t类型不安全，因为加入的数据为object类型，所以需要装箱与拆箱，效率较低。
        List：声明时就决定了类型，所以是类型安全的，省掉了装箱与拆箱的过程，效率比ArrayList要高。


        3.ArrayList就是一个List而已。
        泛型集合的优势就是类型安全和无装箱。
     */
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    space.add(new int[]{i, j});
                } else {
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = column[j][num] = block[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board, 0);
        // return;

    }
    public void dfs(char[][] board, int pos) {
        if (pos == space.size()) {
            flag = true;
            return;
        }
        int[] xy = space.get(pos);
        int x = xy[0], y = xy[1];
        for (int num = 0; num < 9 && !flag; num++) {
            if (!row[x][num]&&!column[y][num]&&!block[x/3][y/3][num]){
                row[x][num]=column[y][num]=block[x/3][y/3][num]=true;
                board[x][y]=(char)(num+'0'+1);
                dfs(board,pos+1);
                row[x][num]=column[y][num]=block[x/3][y/3][num]=false;
            }
        }
    }
}