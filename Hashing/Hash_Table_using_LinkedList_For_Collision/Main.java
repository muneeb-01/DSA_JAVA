public class Main {
    public static void main(String[] args) {
        Hash_Table table = new Hash_Table();
        table.insert(53);
        table.insert(54);
        table.insert(73);
        table.insert(102);
        table.remove(53);
        table.traverse();

        System.out.println("Search 73: " + table.search(73)); // true
        System.out.println("Search 100: " + table.search(100)); // false
        System.out.println("Get 74: " + table.get_val(74));
        System.out.println("Get 54: " + table.get_val(54));
    }
}


class Hash_Table {
    int table_length = 10;
    LinkedList[] table;

    Hash_Table(int table_length){
        this.table_length = table_length;
        table = new LinkedList[table_length];
        for(int i = 0; i < table_length; i++){
            table[i] = new LinkedList();
        }
    }

    Hash_Table(){
        table = new LinkedList[table_length];
        for(int i = 0; i < table_length; i++){
            table[i] = new LinkedList();
        }
    }

    void insert(int val){
        int key = val % table_length;
        table[key].insert_at_end(val);
    }

    boolean search(int val){
        int key = val % table_length;
        return table[key].search(val);
    }

    void traverse(){
        for(int i = 0; i < table_length; i++){
            System.out.print("Bucket " + (i+1) + " : ");
            table[i].traverse();
        }
    }
    Integer get_val(int val){
        int key = val % table_length;
        return table[key].get(val);
    }

    void remove(int val) {
        int key = val % table_length;
        table[key].remove(val);
    }


    class LinkedList {
        Node head = null;

        class Node {
            int data;
            Node next;
            public Node(int data) {
                this.data = data;
                next = null;
            }
        }

        void insert_at_end(int data) {
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

        void traverse(){
            if(head == null){
                System.out.println("Empty List");
                return;
            }
            Node current = head;
            while(current != null){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
        void remove(int val) {
            if (head == null) return;

            if (head.data == val) {
                head = head.next;
                return;
            }

            Node current = head;
            while (current.next != null && current.next.data != val) {
                current = current.next;
            }

            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        // 🔍 New method for searching a value in the linked list
        boolean search(int val){
            Node current = head;
            while(current != null){
                if(current.data == val){
                    return true;
                }
                current = current.next;
            }
            return false;
        }
        Integer get(int val){
            Node current = head;
            while(current != null){
                if(current.data == val){
                    return current.data;
                }
                current = current.next;
            }
            return null; // value not found
        }
    }
}
