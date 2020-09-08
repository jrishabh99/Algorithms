import java.util.*;
class Merge_Sort {

    public static void sortArray(int[] nums) {
        System.out.println("Array before sorting: "+Arrays.toString(nums));
        mergeSort(nums,0,nums.length-1);
        System.out.println("Array after sorting: "+Arrays.toString(nums));
    }

    // Function that performs merge sort
    public static void mergeSort(int nums[],int low,int high)
    {

        // if the sub-problem contains atleast 1 element
        if(low<high)
        {

            int p=(low+high)/2;

            // split the range into two halves
            mergeSort(nums,low,p);
            mergeSort(nums,p+1,high);

            // merge the sorted halves
            merge(nums,low,p,high);
        }
    }

    // Helper method to merge two sorted ranges
    // the left half is from index low to index p(both inclusive)
    // the right half is from index p+1 to index high(both inclusive)
    private static void merge(int nums[],int low,int p,int high)
    {
        int size_left=p-low+1,size_right=high-p;

        // temporary arrays to store the left and the right halves
        int left[]=new int[size_left];
        int right[]=new int[size_right];

        // fill the left and right arrays
        int count=0;
        for(int i=low;i<=p;i++)
            left[count++]=nums[i];
        count=0;
        for(int i=p+1;i<=high;i++)
            right[count++]=nums[i];

        // merge the two arrays
        int i=0,j=0,k=low;
        while(i<size_left && j<size_right)
        {
            if(left[i]<right[j])
                nums[low++]=left[i++];
            else
                nums[low++]=right[j++];
        }

        while(i<size_left)
        {
            nums[low++]=left[i++];
        }

        while(j<size_right)
        {
            nums[low++]=right[j++];
        }
    }

    public static void main(String []args)
    {
        int nums[]={5, 2, 9, 11, 1};
        sortArray(nums);
    }
}