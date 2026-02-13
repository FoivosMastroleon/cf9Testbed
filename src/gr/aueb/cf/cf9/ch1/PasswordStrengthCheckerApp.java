package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

/** It checks the strength of a password set by the user.
*The password must contain at least:
*8 characters
*one upper case
*one letter
*one digit
*one special character
 */


public class PasswordStrengthCheckerApp {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;

        do {
            System.out.println("Please enter a password");
            password = scanner.nextLine();

            if (!checkPasswordStrength(password)){


                System.out.println("It must contain:");
                System.out.println("- At least 8 characters");
                System.out.println("- At least  1 Uppercase");
                System.out.println("- At least  1 lowercase");
                System.out.println("- At least  1 digit");
                System.out.println("- At least  1 special character (!@#$%^&*)");
                System.out.println("Please try again");

            }


        } while (!checkPasswordStrength(password));

        System.out.println("Your password is strong");



        }




    public static boolean checkPasswordStrength(String password) {
        return password.length() >= 8 &&
                hasUpperCase(password) &&
                hasLowerCase(password) &&
                hasDigit(password) &&
                hasSpecialChar(password);


    }

    public static boolean hasUpperCase(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                return true;
            }

        }
        return false;



    }

    public static boolean hasLowerCase(String s){
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                return  true;

            }
        }
        return false;
    }

    public static boolean hasDigit(String s){
        for (int i = 0; i < s.length(); i++){
            if (Character.isDigit(s.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String s){
        String specialChar = "!@#$%^&*";
        for (int i = 0; i < s.length(); i++){
            if (specialChar.contains(String.valueOf(s.charAt(i)))){
                return true;
            }
        }
        return false;
    }
}
