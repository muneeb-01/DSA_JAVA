public class FindPairsWithSum {

    public static String[] findPairs(int[] arr, int target) {
        int n = arr.length;
        String[] tempPairs = new String[n * n]; // max possible size
        int pairCount = 0;

        for (int i = 0; i < n; i++) {
            // Check pairs only once
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    tempPairs[pairCount++] = "(" + arr[i] + ", " + arr[j] + ")";
                }
            }
        }

        // Copy valid pairs to result array
        String[] result = new String[pairCount];
        for (int i = 0; i < pairCount; i++) {
            result[i] = tempPairs[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int target = 6;
        String[] output = findPairs(input, target);

        System.out.print("Pairs with sum " + target + ": ");
        for (String pair : output) {
            System.out.print(pair + " ");
        }
    }
}
