package Sorting;

import java.util.Arrays;

//Not a complete Inplace because we are creating one arr in each merging

public class MergeSortInPlace {
    static void mergesort(int[] arr , int s, int e) {


        if(e-s==1) return;
        int mid=(e+s)/2;

        mergesort(arr,s,mid);
        mergesort(arr,mid,e);

        merge(arr,s,mid,e);

    }

    static void merge(int[] arr,int s,int mid,int e){
        int[] f = new int[e-s];
        int i=s,j=mid,k=0;

        while(i<mid && j<e){
            if(arr[i]<arr[j]){
                f[k]=arr[i++];
            }else{
                f[k]=arr[j++];
            }
            k++;
        }

        while(i<mid){
            f[k++]=arr[i++];
        }
        while(j<e){
            f[k++]=arr[j++];
        }

        for(int l=0;l<f.length;l++){
            arr[s+l]=f[l];
        }
    }

    public static void main(String[] args) {
        System.out.println("Merge Sorting...");
        int[] arr=new int[]{3,5,2,7,5,6,9,1};
        System.out.println("Orginal Array :" + Arrays.toString(arr));
        mergesort(arr,0,arr.length);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }
}
