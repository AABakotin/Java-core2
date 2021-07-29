package MultiTreading;

import java.util.Arrays;

public class MultiTreading {

    static final int SIZE = 10000000;
    static final int HALF_SIZE = SIZE / 2;


    public static void main(String[] args) {

        float[] array1 = firstExample();
        float[] array2 = secondExample();

        System.out.printf("Массив array1 и array2 равны: %b\n", Arrays.equals(array1, array2));

    }

    static float[] firstExample() {
        float[] arr1 = new float[SIZE];
        Arrays.fill(arr1, 1);
        long a = System.currentTimeMillis();
        computation(arr1, 0);
        System.out.println("Time single threading " + (System.currentTimeMillis() - a));
        return arr1;
    }

    static float[] secondExample() {

        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF_SIZE];
        float[] a2 = new float[HALF_SIZE];

        Arrays.fill(arr, 1);

        long timeMillis = System.currentTimeMillis();

        Thread thread0 = new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, HALF_SIZE);
            computation(a1, 0);
            System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        });

        Thread thread1 = new Thread(() -> {
            System.arraycopy(arr, HALF_SIZE, a2, 0, HALF_SIZE);
            computation(a2, HALF_SIZE);
            System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);
        });

        thread0.start();
        thread1.start();

        try {
            thread0.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time MultiTreading " + (System.currentTimeMillis() - timeMillis));

        return arr;
    }

    static void computation(float[] arr, int a) {

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + a) / 5) * Math.cos(0.2f + (i + a) / 5) * Math.cos(0.4f + (i + a) / 2));

        }
    }

}

