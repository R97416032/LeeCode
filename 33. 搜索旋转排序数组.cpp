class Solution {
public:
    int search(vector<int>& nums, int target) {
        int l=0,r=nums.size()-1,mid=(l+r)/2;
        while(l<r){
            if(nums[mid]==target)
                return mid;
            if(nums[l]>nums[r]){
                if(nums[l]<=target&&target<nums[mid]||nums[mid]<nums[r]&&target>nums[r]){
                r=mid-1;
                mid=(l+r)/2;
                }
                else if(target<=nums[r]&&target>nums[mid]||target<nums[l]&&nums[mid]>nums[l]){
                    l=mid+1;
                    mid=(l+r)/2;
                }
            }
            else{
                if(nums[mid]>target){
                    r=mid-1;
                    mid=(l+r)/2;
                }
                else{
                    l=mid+1;
                    mid=(l+r)/2;
                }
            }
        }
        return -1;
    }
};