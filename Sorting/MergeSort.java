
import java.util.Arrays;

class MergeSort{
     static int[] mergesort(int[] arr) {
        int size=arr.length;

        if(size==1) return arr;
        int mid=size/2;

        int [] leftSorted=mergesort(Arrays.copyOfRange(arr,0,mid));
        int [] rightSorted=mergesort(Arrays.copyOfRange(arr,mid,size));

        return merge(leftSorted,rightSorted);

    }

    static int[] merge(int[] left,int[] right){
        int[] f = new int[left.length+right.length];
        int i=0,j=0,k=0;

        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                f[k]=left[i++];
            }else{
                f[k]=right[j++];
            }
            k++;
        }

        while(i<left.length){
            f[k++]=left[i++];
        }
        while(j<right.length){
            f[k++]=right[j++];
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println("Merge Sorting...");
        int[] arr=new int[]{3,5,2,7,5,6,9,1};
        System.out.println("Orginal Array :" + Arrays.toString(arr));
        int[] sortedArray=mergesort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

    }
}
