
public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{12,13,15,18,28,55,66,95,54,62};
        Search search = new Search(array);
        try{
            System.out.println("Binary Search index : "+search.Binary_Search(13));
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("Linear Search element index : "+search.linear_Search(95));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());;
        }

        try{
            System.out.println("Ternary Search index : "+search.ternary_search(13));
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

}
class Search {
    int[] arr;

    Search(int[] arr) {
        this.arr = arr;
    }

    void sort(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    int linear_Search(int x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x){
                return i;
            }
        }
        throw new RuntimeException("Element not found");
    }

    //only work with the sorted array
    int Binary_Search(int x) {
        sort();
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == x) {
                return mid;
            }else if (arr[mid] < x) {
                start = mid + 1;
            }else if (arr[mid] > x) {
                end = mid - 1;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Element not found.");
    }

    int ternary_search(int x) {
        sort();
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid1 = left + (right - left) / 3;
            int mid2 = right - (right - left) / 3;

            if(arr[mid1] == x) return mid1;
            if(arr[mid2] == x) return mid2;

            if(x<arr[mid1]){
                right = mid1 - 1;
            }else if(x > arr[mid2]){
                left = mid2 - 1;
            }else {
                left = mid1+1;
                right = mid2-1;
            }
        }
        throw new RuntimeException("Element not found.");
    }

}
