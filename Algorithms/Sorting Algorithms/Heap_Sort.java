import java.util.*;
class Heap_Sort {

    public static void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    // for the index i, check if a descendent is greater than it and swap
    // it with the greater child
    public static void heapify(int nums[],int index,int high)
    {
        int temp=nums[index];
        while(index*2<high)
        {
            int child=index*2;
            if(child+1<high && nums[child]<nums[child+1])
                child++;
            if(nums[child]>nums[index])
                swap(nums,child,index);
            else
                break;
            index=child;
        }
    }

    public static void heapSort(int nums[],int n)
    {
        
        // Create a max heap
        for(int i=n-1;i>=1;i--)
            heapify(nums,i,nums.length);
        
        // remove elements from root and call heapify
        for(int i=n-1;i>=1;i--)
        {
            swap(nums,1,i);
            heapify(nums,1,i);
        }
    }
    public static void sortArray(int[] nums) {
        System.out.println("Array before sorting: "+Arrays.toString(nums));
        int arr[]=new int[nums.length+1];
        for(int i=1;i<=nums.length;i++)
            arr[i]=nums[i-1];
        heapSort(arr,arr.length);
        for(int i=0;i<nums.length;i++)
            nums[i]=arr[i+1];
        System.out.println("Array after sorting: "+Arrays.toString(nums));
    }

    public static void main(String[]args)
    {
        int nums[]={5,3,0,-1,6,4};
        sortArray(nums);
    }
}
