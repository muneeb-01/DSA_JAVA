import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,5,6,7,8,9,5,6,3,5,3,2,5,6};
        Sorting sort = new Sorting();

        sort.countingSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}

class Sorting {
    void Bubble_Sort(int order,int[] arr){
        if(order == 1){
            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr.length; j++){
                    if(arr[j] > arr[i]){
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        } else if (order == -1) {
            for(int i = 0; i<arr.length; i++){
                for(int j = 0; j<arr.length; j++){
                    if(arr[j] < arr[i]){
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                    }
                }
            }
        }else{
            throw new RuntimeException("Invalid order");
        }
    }
    void selection_Sorting(int order,int[] arr){

        for(int i = 0; i<(arr.length-1); i++){
            int min = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    void insertion_sort(int[] arr){
        for(int i = 1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    void mergeSort(int[] array){
        if(array.length < 2){
            return;
        }

        int mid = array.length/2;

        int[] leftArray  = Arrays.copyOfRange(array, 0, mid);
        int [] rightArray = Arrays.copyOfRange(array,mid,array.length);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
    }
    private void merge(int[] array, int[] left, int[] right){
        int i = 0, j = 0 , k = 0;

        while(i < left.length && j < right.length){
            if(left[i]< right[j]){
                array[k++] = left[i++];
            }else{
                array[k++] = right[j++];
            }
        }

        while(i < left.length){
            array[k++] = left[i++];
        }
        while(j < right.length){
            array[k++] = right[j++];
        }
    }
    void countingSort(int[] array){
        //find the maximum value
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(max < array[i]){
                max = array[i];
            }
        }

        int[] count = new int[max+1];

        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Create an output array to store sorted elements
        int[] output = new int[array.length];

        // Place elements in the output array in sorted order
        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            output[count[num] - 1] = num;
            count[num]--;
        }

        System.arraycopy(output,0,array,0,array.length);
    }
}
