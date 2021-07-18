package Exceptions;

public class Transform {

    public static int strTransform(String[][] strings)
            throws MySizeArrayException, MyArrayDataException {


        int sum = 0;

        int result = 0;
        for (Object[] m : strings) {
            result += m.length;
        }
        if (result == 16) {

            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings.length; j++) {
                    try {
                        sum += Integer.parseInt(strings[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(j, i);
                    }
                }
            }
        } else throw new MySizeArrayException();
        return sum;
    }
}

//





