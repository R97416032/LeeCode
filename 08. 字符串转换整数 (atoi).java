class Solution {
    public static int myAtoi(String s) {
        int i=0,max=Integer.MAX_VALUE/10,min=Integer.MIN_VALUE/10;
        int flag=1,res=0;
        while(i<s.length()&&s.charAt(i)==' ')
            i++;
        if(i<s.length()&&s.charAt(i)=='-'){
            flag=-1;
            i++;
        }
        else if(i<s.length()&&s.charAt(i)=='+'){
            flag=1;
            i++;
        }
        while(i<s.length()&&Character.isDigit(s.charAt(i))){
            if(res>max||res==max&&Integer.valueOf(s.charAt(i))-Integer.valueOf('0')>7)
                return Integer.MAX_VALUE;
            if(res<min||res==min&&Integer.valueOf('0')-Integer.valueOf(s.charAt(i))<-8)
                return Integer.MIN_VALUE;
            res=res*10+(Integer.valueOf(s.charAt(i))-Integer.valueOf('0'))*flag;
            i++;
        }
        return res;
    }
}