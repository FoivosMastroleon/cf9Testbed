package gr.aueb.cf.cf9.ch1;

public class HeartRateMonitoring {

    public static void main(String[] args) {

        int[] heartBeats = {70, 65, 97 , 155, 143, 160, 97, 160, 76, 98, 200};
        int lowHeartBeat = 0;
        int highHeartBeat = 10;
        int heartBeatLimit = 150;

        int firstHighHeartBeat = maxHeartBeat(heartBeats, lowHeartBeat, highHeartBeat, heartBeatLimit);
        int secondHighHeartBeat = maxHeartBeat(heartBeats,firstHighHeartBeat +1 ,highHeartBeat, heartBeatLimit);

        if (firstHighHeartBeat == -1){
            System.out.println("No heartbeat....");

        } else {
            System.out.println("The first dangerous Hearbeat was on " + firstHighHeartBeat + " with " + heartBeats[firstHighHeartBeat]+ " beats per minute");
            System.out.println("The second dangerous Heartbeat was on " + secondHighHeartBeat + " with " + heartBeats[secondHighHeartBeat] + " beats per minute");

        }


    }

    public static int maxHeartBeat( int[] arr, int low , int high, int limit){
        if (arr == null || arr.length ==0 ){
            return -1;
        }

        if (low < 0 || high >= arr.length || low > high){
            return -1;
        }

        for (int i = low; i <= high; i++)
            if (arr[i] >= limit) {
                return i;
            }

        return -1;
    }
}
