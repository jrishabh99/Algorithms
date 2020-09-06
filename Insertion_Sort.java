import java.util.*;
class Insertion_Sort {

    // Method to sort an array
    public static void sortArray(int[] nums) {
        System.out.println("Array before sorting: "+Arrays.toString(nums));
        insertionSort(nums,nums.length);
        System.out.println("Array before sorting: "+Arrays.toString(nums));
    }

    // Method to sort an array using insertion sort
    private static void insertionSort(int nums[],int n)
    {

        // Iterate over all elements and insert them in the correct position
        for(int i=1;i<n;i++)
        {
            int j=i-1,temp=nums[i];

            // Iterate over the previous elements and if the number
            // is greater than the current element, then shift them 
            // to make room for the current element
            while(j>=0 && nums[j]>temp)
            {
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=temp;
        }
    }

    // Driver Code
    public static void main(String []args){
        int nums[]={3,0,-1,7,3};
        sortArray(nums);
    }
}