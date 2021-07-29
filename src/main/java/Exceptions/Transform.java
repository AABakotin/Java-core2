package Exceptions;

public class Transform {

    public static final int SIZE = 4;

    public static int strTransform(String[][] strings)
            throws MySizeArrayException, MyArrayDataException {

        if (strings.length != SIZE) throw new MySizeArrayException();
        for (int y = 0; y < strings.length; y++) {
            if (strings[y].length != SIZE) throw new MySizeArrayException();
        }
        int sum = 0;
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                try {
                    sum += Integer.parseInt(strings[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(j, i);
                }
            }
        }
        return sum;
    }
}


//





