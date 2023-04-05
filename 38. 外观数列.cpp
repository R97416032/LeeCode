class Solution {
public:
    string countAndSay(int n) {
        if(n==1){
            return "1";
        }
        else{
            string temp=countAndSay(n-1),res="";
            int i=0,j=0;
            for(;i<temp.size();i=j){
                int count=1;
                for(j=i+1;j<temp.size();){
                    if(temp[i]==temp[j]){
                        count++;
                        j++;
                    }
                    else{
                        break;
                    }
                }
                res=res+to_string(count)+temp[i];
            }
            return res;
        }
    }
};