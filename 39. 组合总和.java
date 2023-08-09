class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> combine=new ArrayList<Integer>();
        dfs(candidates,target,0,ans,combine);
        HashSet<List<Integer>> hs=new HashSet<List<Integer>>();
        for(List<Integer> a:ans){
            hs.add(a);
        }
        ans.clear();
        for(List<Integer> h:hs){
            ans.add(h);
        }
        return ans;
    }
    public void dfs(int[] candidates,int target,int idx,List<List<Integer>> ans,List<Integer> combine){
        if(idx==candidates.length)
            return ;
        if(target==0){
            ans.add(new ArrayList<Integer>(combine));
        }
        dfs(candidates,target,idx+1,ans,combine);
        if(target-candidates[idx]>=0){
            combine.add(candidates[idx]);
            dfs(candidates,target-candidates[idx],idx,ans,combine);
            combine.remove(combine.size()-1);
        }
    }
}