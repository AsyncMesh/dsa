package Sorting;

import java.util.Arrays;

public class QuickSortNaivePartition {
    public static void main(String[] args) {
        System.out.println("Quick Sorting...");
        int[] arr=new int[]{3,5,2,7,5,6,9,1};
        System.out.println("Orginal Array :" + Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }

    static int NaivePartition(int[] arr,int low,int high){
        int[] temp=new int[arr.length];

        int pivot=arr[high];
        int i=0;
        int PI=high;

        for(int j=0;j<=high;j++){
            if(pivot>=arr[j]){
                temp[i++]=arr[j];
            }
        }

        PI=i-1;

        for(int j=low;j<=high;j++){
            if(pivot<arr[j]){
                temp[i++]=arr[j];
            }
        }

        for(int j=low;j<=high;j++){
            arr[j]=temp[j];

        }
        return PI;

    }

    static void quickSort(int[] arr,int low,int high){
        if(high<=low) return;

        int PivotIndex=NaivePartition(arr, low, high);
        quickSort(arr,low,PivotIndex-1);
        quickSort(arr,PivotIndex+1,high);
    }
}
