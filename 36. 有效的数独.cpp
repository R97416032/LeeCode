class Solution {
public:
    bool check33(vector<vector<char> >&board,int i,int j){
        int box[9][1]={0};
        for(int p=i*3;p<i*3+3;p++){
            for(int q=j*3;q<j*3+3;q++){
                if(board[p][q]=='.')
                    continue;
                if(box[board[p][q]-'1'][0])
                    return false;
                else{
                    box[board[p][q]-'1'][0]=1;
                }
            }
        }
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        for(int i=0;i<9;i++){
            int row[1][9]={0},col[9][1]={0};
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'&&row[0][board[i][j]-'1']==1||board[j][i]!='.'&&col[board[j][i]-'1'][0]==1)
                    return false;
                else{
                    if(board[i][j]!='.')
                        row[0][board[i][j]-'1']=1;
                    if(board[j][i]!='.')
                        col[board[j][i]-'1'][0]=1;
                }
            }
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(!check33(board,i,j))
                        return false;
                }
            }
        }
        return true;
        
    }
};