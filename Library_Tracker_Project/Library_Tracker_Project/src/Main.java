import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1 - Module 1 (Student Details)");
            System.out.println("2 - Module 2 (Library System)");
            System.out.println("3 - Exit");
            System.out.print("Enter your choice: ");
            choice = obj.nextInt();
            obj.nextLine(); // clear buffer

            if (choice == 1) {
                Module1 obj1 = new Module1();

                System.out.print("Enter student's name: ");
                obj1.name = obj.nextLine();
                System.out.print("Enter the father's name: ");
                obj1.fname = obj.nextLine();
                System.out.print("Enter university ID: ");
                obj1.uni_id = obj.nextLine();
                System.out.print("Enter the User ID: ");
                obj1.uid = obj.nextLine();
                System.out.print("In which semester do you study: ");
                obj1.sem = obj.nextInt();
                obj.nextLine(); // clear buffer

                obj1.getdata(obj1.name, obj1.fname, obj1.uid, obj1.uni_id, obj1.sem);
                obj1.setdata();
            } 
            else if (choice == 2) {
                Module2 obj2 = new Module2();
                obj2.startLibraryMenu(); // runs CRUD menu from Module2
            } 
            else if (choice == 3) {
                System.out.println("Goodbye!");
            } 
            else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }
}
