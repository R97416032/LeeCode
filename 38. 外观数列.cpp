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
//另一种方法正向生成，而不是层层递归
class Solution {
public:
    string countAndSay(int n) {
        string prev = "1";
        for (int i = 2; i <= n; ++i) {
            string curr = "";
            int start = 0;
            int pos = 0;

            while (pos < prev.size()) {
                while (pos < prev.size() && prev[pos] == prev[start]) {
                    pos++;
                }
                curr += to_string(pos - start) + prev[start];
                start = pos;
            }
            prev = curr;
        }
        
        return prev;
    }
};