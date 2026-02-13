package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class MaxMinApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 ;
        int num2 ;
        int num3 ;

        System.out.println("Please give 3 numbers");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        int max = findMax(num1, num2 , num3);

        System.out.println("The max is:" + max);


    }

    public static int findMax(int a, int b , int c) {
        if (a >=b && a>=c)
            return a;
        else if (b >=a && b >= c)
            return b;
        else
            return c;

        }

    }

