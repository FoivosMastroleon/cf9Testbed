package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class GetMaxPosition {



    public static void main(String[] args) {

        int[] arr = new int[5];
        int[] num = {10, 8 , 7 ,5, 2};

        int position = getMax(num, 0 , num.length -1 );

        System.out.println("Η θέση του μέγιστου στοιχείου είναι: " + position);
        System.out.println("Το μέγιστο στοιχείο είναι: " + num[position]);


    }

    public static int getMax (int[] arr, int low, int high) {
        if (arr == null || arr.length ==0)
            return -1;

        int maxPosition = low;
        int maxValue = arr[low];

        for (int i = low +1; i <= high; i++) {
            if (arr[i] > maxValue) {
                maxPosition = i;
                maxValue = arr[i];
            }
        }
        return maxPosition;
    }



}
