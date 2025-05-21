import java.util.Arrays;

public class ArrayRotation {
    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int k = 2;
        int[] output = rotateArray(input, k);
        System.out.println("Rotated Array: " + Arrays.toString(output));
    }
}
