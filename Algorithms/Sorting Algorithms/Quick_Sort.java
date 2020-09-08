import java.util.*;
class Quick_Sort {
    
    // Function to swap the values at 
    // index i and j of nums
    public static void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    // places the value at nums[high] at the correct position
    // and all values to the left of it are < than nums[high]
    // and all values to the right of it are >= nums[high]
    // return the correct index of nums[high]
    public static int findPivot(int nums[],int low,int high)
    {
        int pivot=nums[high];  // the pivot element
        int count=low;         // the index of smaller element
        for(int i=low;i<high;i++)
        {
            // if the value at nums[i] is less than pivot, 
            // then swap it with the value and increment 
            // the index of smaller element
            if(nums[i]<pivot)
                swap(nums,i,count++);
        }

        // finally put nums[high] at correct position
        swap(nums,high,count);
        return count;
    }

    // performs quicksort to sort the array
    public static void quickSort(int nums[],int low,int high)
    {
        if(low<high)
        {
            int pivot=findPivot(nums,low,high);
            quickSort(nums,low,pivot-1);
            quickSort(nums,pivot+1,high);
        }
    }

    public static void sortArray(int[] nums) {
        System.out.println("Array before sorting: "+Arrays.toString(nums));
        quickSort(nums,0,nums.length-1);
        System.out.println("Array after sorting: "+Arrays.toString(nums));
    }

    public static void main(String []args)
    {
        int nums[]={0,4,-1,-9,5,3};
        sortArray(nums);
    }
}