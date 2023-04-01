class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l=0,r=nums.size()-1,mid=(l+r)/2;
        if(r==0)
            return nums[0]==target?0:-1;
        while(l<=r){                                                                               
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[l]){
                if(target<nums[mid]&&target>=nums[l]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            mid=(l+r)/2;
        }
        return -1;
    }
};