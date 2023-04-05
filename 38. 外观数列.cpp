class Solution {
public:
    string countAndSay(int n) {
        if(n==1){
            return "1";
        }
        else{
            string temp=countAndSay(n-1),res="";
            int i=0,j=0;
            while(j<temp.size()){
                while(j<temp.size()&&temp[i]==temp[j]){
                    j++;
                }
                res=res+to_string(j-i)+temp[i];
                i=j;
            }
            return res;
        }
    }
};
