package Multithreading;

import java.util.Arrays;

public class Multithreading {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {

        firstExample();
        secondExample();

    }

    private static void firstExample() {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1f);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Time single threading " + (System.currentTimeMillis() - a));
    }

    private static void secondExample() {

        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        Arrays.fill(arr, 1f);

        long timeMillis = System.currentTimeMillis();

        Thread thread0 = new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, HALF);
            for (int i = 0; i < a1.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a1, 0, arr, 0, HALF);
            long timeTread0 = System.currentTimeMillis() - timeMillis;
            System.out.println("Time multi " + Thread.currentThread().getName() + " " + timeTread0 +" ms");
        });

        Thread thread1 = new Thread(() -> {
            System.arraycopy(arr, HALF, a2, 0, HALF);
            for (int i = 0; i < a2.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(a2, 0, arr, HALF, HALF);
            long timeTread1 = System.currentTimeMillis() - timeMillis;
            System.out.println("Time multi " + Thread.currentThread().getName() + " " + timeTread1 +" ms");
        });

        thread0.start();
        thread1.start();


    }

}

