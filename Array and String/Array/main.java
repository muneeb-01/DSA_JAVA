import java.util.*;
public class main {
    public static void main(String[] args) {
    count_vowel_and_consonants("Muneeb Mughal");
    }

    static void count_vowel_and_consonants(String str) {
        str = str.toLowerCase().replaceAll("\\s", "");
        char[] char_arr = str.toCharArray();

        HashMap<Character, Integer> Vowel_map = new HashMap<>();
        HashMap<Character, Integer> Consonant_map = new HashMap<>();

        for(char c : char_arr) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                Vowel_map.put(c, Vowel_map.getOrDefault(c, 0)+1);
            }else{
                Consonant_map.put(c, Consonant_map.getOrDefault(c, 0)+1);
            }
        }
        System.out.println(Vowel_map);
        System.out.println(Consonant_map);

    }

    static void left_Rotate(){
        int[] arr = {1,2,3,4,5,6,7};
        int temp = arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;

        System.out.println(Arrays.toString(arr));
    }

    static void sum_to_target(int target){
        int[] arr = {1,2,3,4,5,6};

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    System.out.print("[" + arr[i] + "," + arr[j] + "]");
                }
            }
        }

    }

    static void remove_duplicate(int[] arr){
        Set<Integer> set = new LinkedHashSet<>();
        for(int i : arr){
            set.add(i);
        }
        int[] newArr = new int[set.size()];
        int i = 0;
        for(Integer integer : set){
            newArr[i++] = integer;
        }
        System.out.println(Arrays.toString(newArr));
    }

    static void reverse_anArray(int[] arr) {
        int temp = arr[0];
        int i = 0;
        int j = arr.length - 1;

        while(i<=j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        System.out.println(Arrays.toString(arr));
    }

    static void secondLargestVal(int[] arr1){
        int largest_val = arr1[0];
        int second_largest_val = arr1[0];

        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > largest_val) {
                second_largest_val = largest_val;
                largest_val = arr1[i];
            }
        }
        System.out.println(second_largest_val);
        System.out.println(largest_val);
    }

    static void mergeArrayy(char[] arr1, char[] arr2){
        int length = arr1.length + arr2.length;
        char[] newArray = new char[length];
        int i = 0, j = 0;

        while(true){
            if(i < arr1.length){
            newArray[i] = arr1[i];
            i++;
            }else if(j < arr2.length){
                newArray[i+j] = arr2[j];
                j++;
            }else{
                break;
            }
        }
        System.out.println(Arrays.toString(newArray));
    }
}
