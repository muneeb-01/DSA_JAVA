
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input: ");
        String input = scanner.nextLine().toLowerCase();

        String[] words = input.split("\\s+"); // split by spaces

        WordHashTable table = new WordHashTable();

        for (String word : words) {
            table.insert(word);
        }

        System.out.println("Output: " + table);
    }
}

class WordHashTable {
    private static final int SIZE = 100;
    private WordNode[] table;

    public WordHashTable() {
        table = new WordNode[SIZE];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void insert(String word) {
        int index = hash(word);
        WordNode current = table[index];

        while (current != null) {
            if (current.word.equals(word)) {
                current.count++;
                return;
            }
            current = current.next;
        }

        WordNode newNode = new WordNode(word);
        newNode.next = table[index];
        table[index] = newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        for (int i = 0; i < SIZE; i++) {
            WordNode current = table[i];
            while (current != null) {
                if (!first) sb.append(", ");
                sb.append(current.word).append("=").append(current.count);
                first = false;
                current = current.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }

    static class WordNode {
        String word;
        int count;
        WordNode next;

        public WordNode(String word) {
            this.word = word;
            this.count = 1;
            this.next = null;
        }
    }
}
