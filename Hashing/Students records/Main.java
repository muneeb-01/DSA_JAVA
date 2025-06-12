public class Main {
    public static void main(String[] args) {
        StudentHashTable studentTable = new StudentHashTable();

        // Adding Students
        studentTable.addStudent(new Student(101, "John", "A"));
        studentTable.addStudent(new Student(201, "Alice", "B"));
        studentTable.addStudent(new Student(103, "Bob", "C"));

        // Retrieve a Student
        Student student = studentTable.getStudent(101);
        if (student != null) {
            System.out.println("Retrieve Student: For ID 101, output Name: " + student.name + ", Grade: " + student.grade);
        } else {
            System.out.println("Student with ID 101 not found.");
        }

        // Remove a Student
        studentTable.removeStudent(102);

        // Try to retrieve removed student
        Student removed = studentTable.getStudent(102);
        System.out.println(removed == null ? "Student with ID 102 was removed." : "Removal failed.");
    }
}

class Student {
    int id;
    String name;
    String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

class StudentHashTable {
    private static final int SIZE = 100;
    private Node[] table;

    public StudentHashTable() {
        table = new Node[SIZE];
    }

    private int hash(int id) {
        return id % SIZE;
    }

    public void addStudent(Student student) {
        int index = hash(student.id);
        Node head = table[index];

        // Check if ID already exists, update
        Node current = head;
        while (current != null) {
            if (current.student.id == student.id) {
                current.student = student; // Update existing
                return;
            }
            current = current.next;
        }

        // Else insert at beginning
        Node newNode = new Node(student);
        newNode.next = head;
        table[index] = newNode;

        System.out.println("Add Student: ID: " + student.id + ", Name: " + student.name + ", Grade: " + student.grade);
    }

    public void removeStudent(int id) {
        int index = hash(id);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.student.id == id) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public Student getStudent(int id) {
        int index = hash(id);
        Node current = table[index];

        while (current != null) {
            if (current.student.id == id) {
                return current.student;
            }
            current = current.next;
        }
        return null;
    }

    private static class Node {
        Student student;
        Node next;

        public Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }
}
