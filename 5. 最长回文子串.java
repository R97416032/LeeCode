class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2)
            return s;
        int maxLen=1;
        int start=0,end=0;
        boolean[][] dp=new boolean[len][len];
        for(int right=1;right<len;right++){
            for(int left=0;left<right;left++){
                if(s.charAt(left)!=s.charAt(right)){
                    continue;
                }
                if(right-left<3){
                    dp[left][right]=true;
                }
                else{
                    dp[left][right]=dp[left+1][right-1];
                }
                if(dp[left][right]&&right-left+1>maxLen){
                    maxLen=right-left+1;
                    start=left;
                    end=right;
                }
            }
        }
        return s.substring(start,end+1);
    }
}