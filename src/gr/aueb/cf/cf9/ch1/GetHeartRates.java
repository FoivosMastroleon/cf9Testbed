package gr.aueb.cf.cf9.ch1;

public class GetHeartRates {


    public static void main(String[] args) {

        int[] heartRates = new int[1440];


    }

    public static int getMaxPosition(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0)
            return -1;
        if (low < 0 || high >= arr.length || low > high)
            return -1;

        int maxPosition = low;
        int maxValue = arr[low];

        for (int i = low + 1; i <= high; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxPosition = i;
            }


        }

        return maxPosition;


    }
}
