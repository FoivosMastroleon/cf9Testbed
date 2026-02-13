package gr.aueb.cf.cf9.ch1;

import java.util.Scanner;

public class LightsOn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean turnTheLightsOn = false;
        boolean isRaining = false;
        boolean isDark = false;
        int speed = 0;

        System.out.println("Please tell us if it is Raining (true/false)");
        isRaining = scanner.nextBoolean();

        if (isRaining) {
            System.out.println("Please tell us if it's dark (true/false)");
            isDark = scanner.nextBoolean();
        }

        if (isDark) {
            System.out.println("Please tell us your speed in kilometers/hour");
            speed = scanner.nextInt();
        }
        turnTheLightsOn = isRaining && (isDark || speed > 100);

        if (turnTheLightsOn) {
            System.out.println("Turn the lights on");
        } else {
            System.out.println("Dont turn the lights on");
        }
    }
}