class Solution {
public:
    int getKnum(vector<int> nums1 , vector<int> nums2 , int k){
		int m = nums1.size() ,n = nums2.size();
        int index1=0,index2=0;
        while(true){
        	if(index1==m)
        		return nums2[index2+k-1];
        	if(index2==n)
        		return nums1[index1+k-1];
        	if(k==1)
        		return min(nums1[index1],nums2[index2]);
        	int p1=min(k/2+index1-1,m-1),p2=min(k/2+index2-1,n-1);
        	if(nums1[p1]<=nums2[p2]){
        		k-=p1-index1+1;
				index1=p1+1;
			}
        	else{
        		k-=p2-index2+1;
        		index2=p2+1;
			}
		}
	}
	
	
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        	int len=nums1.size()+nums2.size();
        	if(len%2==0)
        		return (getKnum(nums1,nums2,len/2)+getKnum(nums1,nums2,len/2+1))/2.0;
        	else
        		return getKnum(nums1,nums2,(len+1)/2);
	}
};