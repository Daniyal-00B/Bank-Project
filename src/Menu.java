import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public static void MainMenu(){

        int choice;
        String Menu = """
                ***********(<<  BANK PROJECT  >>)***********
                
                1. Enter Bank
                2. Create Bank
                
                Choose a Number: """;

        do {
            System.out.print(Menu);
            choice = scanner.nextInt();
            switch (choice){
                case 1 -> System.out.println(" ");
                case 2 -> System.out.println("2");
                default -> System.out.println("Invalid Choice!");
            }
        }while (choice != 0);
        scanner.close();
    }


}
