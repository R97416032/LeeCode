class Solution {
    public int reverse(int x) {
        int max=Integer.MAX_VALUE/10,min=Integer.MIN_VALUE/10;
        int temp=0,res=0;
        while(x!=0){
            temp=x%10;
            if(res>max||res==max&&temp>7){
                return 0;
            }
            if(res<min||res==min&&temp<-8){
                return 0;
            }
            res=res*10+temp;
            x=x/10;
        }
        return res;
    }
}