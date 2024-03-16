class Solution {
    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums,nums.length);//length是个底层属性
        for(int i=nums.length-1;i>=nums.length-1+k;i--){
            swap(nums,0,i);
            buildMaxHeap(nums,i);
        }
        return nums[0];
    }
    public void buildMaxHeap(int[] a,int heapSize){
        for(int i=heapSize/2;i>=0;i--){
            maxHeapAdujst(a,i,heapSize);
        }
    }
    public void maxHeapAdujst(int[] a,int i,int heapSize){
        int left=2*+1,right=2*i+2,largest=i;
        if(left<heapSize&&a[left]>a[largest]){
            largest=left;
        }
        if(right<heapSize&&a[right]>a[largest]){
            largest=right;
        }
        if(i!=largest){
            swap(a,i,largest);
            maxHeapAdujst(a,largest,heapSize);
        }
    }
    public void swap(int[] a,int i,int largest){
        int temp=a[largest];
        a[largest]=a[i];
        a[i]=temp;
    }
}

class Demo{
    public static void main(String[] args){
        Solution s=new Solution();
        int[] nums=new int [3,2,1,5,6,4];
        System.out.println(s.findKthLargest(nums,2));
    }
}