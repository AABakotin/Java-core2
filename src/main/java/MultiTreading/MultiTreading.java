package MultiTreading;

import java.util.Arrays;

public class MultiTreading {

    static final int SIZE = 10000000;
    static final int HALF_SIZE = SIZE / 2;
    static final int DEFAULT = 0;


    public static void main(String[] args) {

        float[] array1 = firstExample();
        float[] array2 = secondExample();

        System.out.printf("Массив array1 и array2 равны: %b\n", Arrays.equals(array1, array2));

    }

    static float[] firstExample() {
        float[] arr1 = new float[SIZE];
        Arrays.fill(arr1, 1);

        MyThreading threadSingle = new MyThreading(arr1, DEFAULT);

        long a = System.currentTimeMillis();

        threadSingle.start();

        try {
            threadSingle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time single threading " + (System.currentTimeMillis() - a));
        threadSingle.getArr();
        return arr1;
    }

    static float[] secondExample() {

        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF_SIZE];
        float[] a2 = new float[HALF_SIZE];

        Arrays.fill(arr, 1);

        System.arraycopy(arr, 0, a1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, a2, 0, HALF_SIZE);

        long timeMillis = System.currentTimeMillis();


        MyThreading thread0 = new MyThreading(a1, DEFAULT);
        MyThreading thread1 = new MyThreading(a2, HALF_SIZE);


        thread0.start();
        thread1.start();

        try {
            thread0.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time MultiTreading " + (System.currentTimeMillis() - timeMillis));

        a1 = thread0.getArr();
        a2 = thread1.getArr();

        System.arraycopy(a1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(a2, 0, arr, HALF_SIZE, HALF_SIZE);
        return arr;
    }

}

