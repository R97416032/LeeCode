class Solution {
    public int maxProduct(int[] nums) {
        int maxdp=nums[0],mindp=nums[0],ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int mx=maxdp,mn=mindp;
            maxdp=Math.max(mx*nums[i],Math.max(mn*nums[i],nums[i]));
            mindp=Math.min(mx*nums[i],Math.min(mn*nums[i],nums[i]));
            ans=Math.max(maxdp,ans);
        }
        return ans;
    }
}