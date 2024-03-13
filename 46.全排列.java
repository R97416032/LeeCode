import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len=nums.length;
        List<List<Integer> > res=new ArrayList<List<Integer> >();
        if(len==0){
            return res;
        }
        boolean[] used=new boolean[len];
        List<Integer> path=new ArrayList<>();

        dfs(nums,path,0,len,used,res);
        System.out.println(Integer.toHexString(System.identityHashCode(path)));
        System.out.println(Integer.toHexString(System.identityHashCode(res)));
        return res;
    }
    private void dfs(int[] nums,List<Integer> path,int depth,int len,boolean[] used,List<List<Integer> > res){
        if(depth==len){
            System.out.println("path>>>>"+Integer.toHexString(System.identityHashCode(path)));
            res.add(new ArrayList<>(path));

            return;
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);

                used[i]=true;
                dfs(nums,path,depth+1,len,used,res);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
      public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permute(nums);
        // System.out.println(lists);
    }

}