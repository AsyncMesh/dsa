package Sorting;

import java.util.Arrays;

public class QuickSortLumutoPartition {
    public static void main(String[] args) {
        System.out.println("Quick Sorting...");
        int[] arr=new int[]{3,5,2,7,5,6,9,1};
        System.out.println("Orginal Array :" + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }

    static int LumutoPartition(int[] arr,int low,int high){


        int pivot=arr[high];
        int i=low-1;
        int PI=high;

        for(int j=low;j<high;j++){
            if(pivot>=arr[j]){
                i=i+1;
                swap(arr,i,j);
            }
        }

        PI=i+1;
        swap(arr,PI,high);

        return PI;

    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;

    }
    static void quickSort(int[] arr,int low,int high){
        if(high<=low) return;

        int PivotIndex=LumutoPartition(arr, low, high);
        quickSort(arr,low,PivotIndex-1);
        quickSort(arr,PivotIndex+1,high);
    }
}
