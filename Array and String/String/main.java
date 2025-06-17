import java.util.*;

public class main {
    public static void main(String[] args) {
        removeElemlessThanK(2, "Muneeb");
    }

    static void removeElemlessThanK(int k, String str) {
        str = str.toLowerCase().replaceAll("\\s", "");
        char[] charArray = str.toCharArray();

        // Count frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Build new string with only chars having freq >= k
        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            if (map.get(c) >= k) {
                result.append(c);
            }
        }

        // Output
        System.out.println("Filtered string (only chars with freq >= " + k + "): " + result);
    }


    static void mostFrequentChar(String str) {
        str = str.toLowerCase().replaceAll("\\s", "");

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character> mostFrequent = new ArrayList<>();
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();

            if(count > maxCount) {
                mostFrequent.clear();
                mostFrequent.add(entry.getKey());
                maxCount = count;
            }else if(count == maxCount){
                mostFrequent.add(entry.getKey());
            }

        }

        System.out.println(mostFrequent + " = " + maxCount);

    }


    static void Repeating_char_in_String(String str) {
        str = str.toLowerCase().replaceAll("\\s", "");
        if(str.length() == 0){
            System.out.println("Empty string");
        }
        char[] str_char = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str_char){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1)
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    static boolean isPalindrome (String str) {
    str = str.toLowerCase();

    char[] str_char = str.toCharArray();
    int i = 0;
    int j = str_char.length - 1;
    while (i < j) {
        if (str_char[i] != str_char[j]) {
            return false;
        }
        i++;
        j--;
    }

    return  true;
    }

    static boolean isAnagram(String a, String b) {
    a = a.replace("\\s","").toLowerCase();
    b = b.toLowerCase();
    if(a.length() != b.length()) {
        System.out.println("Not an anagram");
        return false;
    }

        char[] arr1 = a.toCharArray();
        char[] arr2 = a.toCharArray();


    return Arrays.equals(arr1, arr2);
    }
}
