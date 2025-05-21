import java.util.Arrays;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] arr) {
        if (arr.length == 0) return new int[0];

        // First pass: count unique elements
        int uniqueCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqueCount++;
            }
        }

        // Second pass: store unique elements
        int[] result = new int[uniqueCount];
        result[0] = arr[0];
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[index++] = arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 4, 4, 5};
        int[] output = removeDuplicates(input);
        System.out.println("Unique Elements: " + Arrays.toString(output));
    }
}
