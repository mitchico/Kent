package GaniganLogin;

import java.util.Scanner;

public class GaniganLogins {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] users = new String[100][2];
        int userCount = 0;
        int choice;

        while (true) {
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Enter username: ");
                String usersname = sc.nextLine();

                System.out.print("Enter password: ");
                String pass = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < userCount; i++) {
                    if (users[i][0].equals(usersname) && users[i][1].equals(pass)) {
                        System.out.println("Hello, " + usersname + "!");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    
                    System.out.println("Invalid username or password!");
                }
                System.out.println();

            } else if (ch == 2) {
                System.out.print("Enter new username: ");
                String newusername = sc.nextLine();

                boolean exists = false;
                for (int i = 0; i < userCount; i++) {
                    if (users[i][0].equals(newusername)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Username already exists!");
                    System.out.println();
                } else {
                    System.out.print("Enter new password: ");
                    String newpassword = sc.nextLine();

                    System.out.print("Confirm password: ");
                    String confirmPass = sc.nextLine();

                    if (!newpassword.equals(confirmPass)) {
                        System.out.println("Passwords do not match!");
                        System.out.println();
                    } else {
                        users[userCount][0] = newusername;
                        users[userCount][1] = newpassword;
                        userCount++;
                        System.out.println("Registration successful!");
                        System.out.println();
                    }
                }

            } else if (ch == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option!");
                System.out.println();
            }
        }
        
    }
}