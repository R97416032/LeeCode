class Solution {
public:
    //flag用来寻找第一个的大于等于target的下标和第一个大于target的下标，当right为第一个大于target下标-1时，nums[ringht]必定小于等于target于是找到上下边界
    int binarySearch(vector<int>&nums,int target,bool flag){
        int l=0,r=nums.size()-1,mid=(l+r)/2,ans=nums.size();
        while(l<=r){
            if(nums[mid]>target||(flag&&nums[mid]>=target)){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
            mid=(l+r)/2;
        }
        return ans;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        int left=binarySearch(nums,target,true);
        int right=binarySearch(nums,target,false)-1;
        if(left<=right&&right<=nums.size()-1&&nums[left]==target&&nums[right]==target)
            return vector<int>{left,right};
        return vector<int>{-1,-1};
    }
};