import java.util.*;

public class main {
public static void main(String[] args) {
    System.out.println("The given Strings are anagram. "+isAnagram("Muneeb","beanum"));
    System.out.println("The given Strings is Palindrome. "+isPalindrome("tibit"));
    Repeating_char_in_String("Muneeb mughal");
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
