package MultiTreading;

public class MyThreading extends Thread {


    private float[] arr;
    private float index;

    MyThreading(float[] arr, int index) {
        this.index = index;
        this.arr = arr;

    }

    float[] getArr() {
        return arr;
    }

    @Override
    public void run() {
        calculate();
    }

    private void calculate() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + index) / 5) * Math.cos(0.2f + (i + index) / 5) * Math.cos(0.4f + (i + index) / 2));

        }
    }
}

