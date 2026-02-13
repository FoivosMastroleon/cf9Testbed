package gr.aueb.cf.cf9.ch1;

public class DangerousTemperature {

    public static void main(String[] args) {

        int[] temperatures = {10, 88, 52, 67, 35, 90, 47, 12, 83};

        int low = 0;
        int high = 8;
        int limit = 85;

        int firstPosition = getFirstDangerousPosition(temperatures, low, high, limit);

        if (firstPosition == -1) {
            System.out.println("Δεν βρέθηκε επικίνδυνη θερμοκρασία στο διάστημα.");
        } else {
            System.out.println("ΠΡΟΣΟΧΗ! Πρώτη επικίνδυνη θερμοκρασία: "
                    + temperatures[firstPosition] + "°C στη θέση " + firstPosition);
        }

        int secondPosition = getFirstDangerousPosition(temperatures, firstPosition + 1, high, limit);

        if (secondPosition == -1) {
            System.out.println("Δεν βρέθηκε επικίνδυνη θερμοκρασία στο διάστημα.");

        } else {
            System.out.println("ΠΡΟΣΟΧΗ!! Η Δεύτερη επικίνδυνη θερμοκρασία είναι " + temperatures[secondPosition]  +"°C στη θέση " + secondPosition);
        }

    }


    public static int getFirstDangerousPosition(int[] arr, int low, int high, int limit) {
        if (arr == null || arr.length ==0)
            return -1;
        if (low < 0 || high >= arr.length|| low > high)
            return -1;

        for (int i = low; i <= high; i++){
            if (arr[i] > limit) {
                return i;
            }
        }

        return -1;
    }
}
