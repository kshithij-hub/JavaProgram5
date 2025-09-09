package Stack;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Stack st=null;
        
        System.out.println("Choose  ypur method of initialization:");
        System.out.println("1. Empty stack with size");
        System.out.println("2. Stack initialized with array of Persons");
        int choice = sc.nextInt();
        
        if (choice == 1) {
            System.out.print("Enter size: ");
            int size = sc.nextInt();
            st = new Stack(size); 
        } else if (choice == 2) {
            System.out.print("Enter number of Persons: ");
            int n = sc.nextInt();
            sc.nextLine();
            Person arr[] = new Person[n];
            for (int i = 0; i < n; i++) {
            	System.out.println("Enter details for Person " + (i + 1) + ":");

                System.out.print("Name: \n");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine(); 

                System.out.print("Gender (MALE/FEMALE/OTHER): ");
                String genderInput = sc.nextLine().toUpperCase();

                Gender gender;
                if (genderInput.equals("MALE")) {
                    gender = Gender.MALE;
                } else if (genderInput.equals("FEMALE")) {
                    gender = Gender.FEMALE;
                } else {
                    gender = Gender.OTHER;
                }

                arr[i] = new Person(name, age, gender);
            }

            st = new Stack(arr); 
        }
        int option;
        do {
            System.out.println("\n Menu");
            System.out.println("1. Push one Person");
            System.out.println("2. Push two Persons");
            System.out.println("3. Pop one Person");
            System.out.println("4. Pop multiple Persins");
            System.out.println("5. Display all Persons");
            System.out.println("6. Display top n Persons");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    sc.nextLine(); 
                    System.out.println("Enter details for Person:");
                    System.out.print("Name: ");
                    String name1 = sc.nextLine();
                    System.out.print("Age: ");
                    int age1 = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Gender (MALE/FEMALE/OTHER): ");
                    String genderStr1 = sc.nextLine().toUpperCase();
                    Gender gender1 = Gender.valueOf(genderStr1);
                    st.push(new Person(name1, age1, gender1));
                    break;

                case 2:
                    sc.nextLine(); // clear buffer
                    System.out.println("Enter details for Person 1:");
                    System.out.print("Name: ");
                    String name2a = sc.nextLine();
                    System.out.print("Age: ");
                    int age2a = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Gender (MALE/FEMALE/OTHER): ");
                    String genderStr2a = sc.nextLine().toUpperCase();
                    Gender gender2a = Gender.valueOf(genderStr2a);

                    System.out.println("Enter details for Person 2:");
                    System.out.print("Name: ");
                    String name2b = sc.nextLine();
                    System.out.print("Age: ");
                    int age2b = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Gender (MALE/FEMALE/OTHER): ");
                    String genderStr2b = sc.nextLine().toUpperCase();
                    Gender gender2b = Gender.valueOf(genderStr2b);

                    st.push(new Person(name2a, age2a, gender2a), new Person(name2b, age2b, gender2b));
                    break;

                case 3:
                    Person popped = st.pop();
                    if (popped != null) {
                        System.out.print("Popped: ");
                        popped.displayPerson();
                    }
                    break;

                case 4:
                    System.out.print("Enter number of Persons to pop: ");
                    int numToPop = sc.nextInt();
                    st.pop(numToPop);
                    break;

                case 5:
                    st.display();
                    break;

                case 6:
                    System.out.print("Enter number of top Persons: ");
                    int topN = sc.nextInt();
                    st.display(topN);
                    break;

                case 7:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (option != 7);

        sc.close();
	}
}
           