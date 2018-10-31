package com.sergors.mip;

import java.util.Scanner;

public class SmoService {

    private static int getNextPoissonValue(double lambda) {
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do {
            k++;
            p *= Math.random();
        } while (p > L);
        return k - 1;
    }

    public static void main(String[] args) throws InterruptedException {
        int ny = 5;
        int lambda = 5;

        System.out.println("Enter time:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int appCount = 0;
        int appTimeCounter = getNextPoissonValue(lambda);

        int handleTime = 0;
        int handleTimeCounter = 0;
        int appTime = 0;
        appCount++;
        do {
            if (appTimeCounter > handleTimeCounter && appCount > 0) {
                appCount--;
                handleTime = getNextPoissonValue(ny);
                handleTimeCounter = appTimeCounter + handleTime;
            } else {
                appCount++;
                appTime = getNextPoissonValue(lambda);
                appTimeCounter += appTime;
            }
           /* if (appTimeCounter < handleTimeCounter) {
                appCount++;
            } else if (appTimeCounter > handleTimeCounter && appCount > 0) {
                appCount--;
                handleTime = getNextPoissonValue(ny);
                handleTimeCounter = appTimeCounter + handleTime;
            } else {
                appTime = getNextPoissonValue(lambda);
                appTimeCounter += appTime;
                appCount++;
            }*/
            System.out.println("appTime = " + appTimeCounter + ", handleTime = " + handleTimeCounter + ",app count = " + appCount);
            Thread.sleep(1000);
        } while (handleTimeCounter < n);
    }
}
