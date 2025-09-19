import java.util.ArrayList;
import java.util.Scanner;

public class Module2 {

    ArrayList<String> chemistry = new ArrayList<>();
    ArrayList<String> physics = new ArrayList<>();
    ArrayList<String> biology = new ArrayList<>();
    ArrayList<String> maths = new ArrayList<>();
    ArrayList<String> computerScience = new ArrayList<>();

    public Module2() {
        chemistry.add("Organic chemistry");
        chemistry.add("Physical chemistry");
        chemistry.add("Bio chemistry");
        chemistry.add("Inorganic chemistry");
        chemistry.add("Polymer chemistry");

        physics.add("Mechanics");
        physics.add("Dynamics");
        physics.add("Solid State Physics");
        physics.add("Astro Physics");
        physics.add("Electromagnetism");

        biology.add("Zoology");
        biology.add("Botany");
        biology.add("Medical Science");
        biology.add("Microbiology");
        biology.add("Genetics");

        maths.add("Algebra");
        maths.add("Calculus");
        maths.add("Probability & Statistics");
        maths.add("Number Theory");
        maths.add("Linear Algebra");

        computerScience.add("Java Programming");
        computerScience.add("Python Programming");
        computerScience.add("C++ Programming");
        computerScience.add("Data Structures & Algorithms");
        computerScience.add("Web Development (HTML, CSS, JS)");
    }

    public void displayBooks(ArrayList<String> list, String dept) {
        System.out.println("\nBooks in " + dept + " Department:");
        if (list.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    public void addBook(ArrayList<String> list, String dept, Scanner sc) {
        System.out.print("Enter new book name to add in " + dept + ": ");
        String name = sc.nextLine();
        list.add(name);
        System.out.println("Book added successfully!");
    }

    public void updateBook(ArrayList<String> list, String dept, Scanner sc) {
        displayBooks(list, dept);
        if (list.isEmpty()) return;
        System.out.print("Enter book number to update: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 1 || index > list.size()) {
            System.out.println("Invalid index!");
            return;
        }
        System.out.print("Enter new book name: ");
        String newName = sc.nextLine();
        list.set(index - 1, newName);
        System.out.println("Book updated successfully!");
    }

    public void deleteBook(ArrayList<String> list, String dept, Scanner sc) {
        displayBooks(list, dept);
        if (list.isEmpty()) return;
        System.out.print("Enter book number to delete: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 1 || index > list.size()) {
            System.out.println("Invalid index!");
            return;
        }
        list.remove(index - 1);
        System.out.println("Book deleted successfully!");
    }

    public void startLibraryMenu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Chemistry");
            System.out.println("2. Physics");
            System.out.println("3. Biology");
            System.out.println("4. Mathematics");
            System.out.println("5. Computer Science");
            System.out.println("6. Exit Library Menu");
            System.out.print("Choose department: ");
            int choice = sc.nextInt();
            sc.nextLine();

            ArrayList<String> selectedList = null;
            String dept = "";

            switch (choice) {
                case 1 -> { selectedList = chemistry; dept = "Chemistry"; }
                case 2 -> { selectedList = physics; dept = "Physics"; }
                case 3 -> { selectedList = biology; dept = "Biology"; }
                case 4 -> { selectedList = maths; dept = "Mathematics"; }
                case 5 -> { selectedList = computerScience; dept = "Computer Science"; }
                case 6 -> { System.out.println("Returning to Main Menu..."); return; }
                default -> { System.out.println("Invalid choice!"); continue; }
            }

            System.out.println("\n--- " + dept + " Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.print("Enter your choice: ");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1 -> displayBooks(selectedList, dept);
                case 2 -> addBook(selectedList, dept, sc);
                case 3 -> updateBook(selectedList, dept, sc);
                case 4 -> deleteBook(selectedList, dept, sc);
                default -> System.out.println("Invalid action!");
            }
        }
    }
}
