package Exceptions;

public class MyHomeExceptions {


    public static void main(String[] args){


        String[][] normallyMassive = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "0", "1", "2"},
                {"3", "4", "5", "6"}};

        String[][] symbolMassive = {
                {"1", "2", "3", "4"},
                {"5", "6", "D", "8"},
                {"9", "0", "1", "2"},
                {"3", "4", "5", "6"}};

        String[][] sizeMassive = {
                {"1", "2", "3", "4"},
                {"5", "6", "D", "8"},
                {"9", "0"},
                {"3", "4", "5", "6"}};

        try {
            System.out.println("Сумма массива " + Transform.strTransform(normallyMassive));
        } catch (MyExceptions e){
            System.out.println(e.getMessage());
        }

        try {
            Transform.strTransform(symbolMassive);
        }catch (MyExceptions e) {
            System.err.println(e.getMessage());

        }

        try {
            Transform.strTransform(sizeMassive);
        }catch (MyExceptions e) {
            System.err.println(e.getMessage());

        }

    }

}
