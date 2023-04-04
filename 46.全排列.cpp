class Solution {
public:
    void backtrack(vector<vector<int> >& res,vector<int>& nums,int start,int len){
        if(start==len){
            res.emplace_back(nums);
            return;
        }
        for(int i=start;i<len;i++){
            swap(nums[i],nums[start]);
            backtrack(res,nums,start+1,len);
            swap(nums[i],nums[start]);
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        int start=0,len=nums.size();
        vector<vector<int> > res;
        backtrack(res,nums,start,len);
        return res;
    }
};
int main(){
	vector<int> nums={1,2,3};
    int target=0;
	Solution so;
	vector<vector<int> > res;
    res=so.permute(nums);
    for(vector<int> num:res){
        cout<<num[0]<<num[1]<<num[2]<<endl;
    }
	return 0;
}