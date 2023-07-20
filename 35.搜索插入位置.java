/*
    二分法注意终止条件有没有 = ，有无=的处理略有差异
    在java中length是数组的一个属性
    size()是集合的一个方法（List,Set,Map）
    没有length()
*/
//终止条件无=
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        int mid=0;
        if(target<=nums[0]){
            return 0;
        }
        else if(target>nums[right-1]){
            return right;
        }
        else{
            while(left<right){
                mid=(right+left)/2;
                if(target==nums[mid]){
                    return mid;
                }
                else if(target>nums[mid]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }
            return left;
        }

    }
}

//终止条件有=
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=0;
        if(target<=nums[0]){
            return 0;
        }
        else if(target>nums[right]){
            return right+1;
        }
        else{
            while(left<=right){
                mid=(right+left)/2;
                if(target==nums[mid]){
                    return mid;
                }
                else if(target>nums[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            return left;
        }

    }
}