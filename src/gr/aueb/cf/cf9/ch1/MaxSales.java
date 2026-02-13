package gr.aueb.cf.cf9.ch1;

public class MaxSales {

    public static void main(String[] args) {

        int[] sales =  {500, 850, 369, 1001, 100, 1150, 2300, 650, 480, 783};
        int lowSales = 0;
        int highSales = 9;
        int salesLimit = 1000;

        int firstSuccessfulDay = getMaxSales(sales,lowSales, highSales, salesLimit);
        int secondSuccessfulDay = getMaxSales(sales, firstSuccessfulDay + 1, highSales, salesLimit);

        if (firstSuccessfulDay == -1){
            System.out.println("You need to try more");
        } else {
            System.out.println(" The first successful day was on day " + firstSuccessfulDay + " with the amount of " + sales[firstSuccessfulDay]);


        }


        if (secondSuccessfulDay == -1){
            System.out.println(" No second successful day found....Lazy dude...");

        } else {
            System.out.println(" The second successful day was on day " + secondSuccessfulDay + " with the amount of " + sales[secondSuccessfulDay]);
        }



    }



    public static int getMaxSales ( int[]arr,int low,int high, int limit){
        if (arr == null || arr.length == 0 ) {
            return -1;
        }
        if (low < 0 || high >= arr.length || low > high) {
            return -1;
        }
        for (int i = low; i <= high; i++ )
            if (arr[i] >= limit) {
                return i;
            }


        return -1;
    }

}
