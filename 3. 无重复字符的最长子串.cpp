class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int len=0,begin=0;
        int str[128];
        for(int i=0;i<128;i++)
            str[i]=-1;
        for(int i=0;i<s.size();i++){
            begin=max(begin,str[s[i]]+1);
            len=max(len,i-begin+1);
            str[s[i]]=i;
        }
        return len; 
    }
};
