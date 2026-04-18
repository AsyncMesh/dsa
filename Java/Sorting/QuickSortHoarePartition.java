package Sorting;

import java.util.Arrays;

//most balanced quick sort we less no. of swaps and mid pivot selection
public class QuickSortHoarePartition {
    public static void main(String[] args) {
        System.out.println("Quick Sorting...");
        int[] arr=new int[]{3,5,2,7,5,6,9,1};
        System.out.println("Orginal Array :" + Arrays.toString(arr));
        HoarePartition(arr,0,arr.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }

    //just recursive partition sorts array
    static void HoarePartition(int[] arr,int low,int high){
        if (low >= high) return;
        int s=low;
        int e=high;
        int mid=(s+e)/2;
        int pivot=arr[mid];

        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }

            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }

        HoarePartition(arr,low,e);
        HoarePartition(arr,s,high);
    }


}
