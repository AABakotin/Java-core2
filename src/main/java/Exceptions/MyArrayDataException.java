package Exceptions;

public class MyArrayDataException extends MyExceptions {


    public MyArrayDataException(int row, int col) {

        super(String.format("Не возможно преобразовать в число ---> Y [%d], X [%d]", ++col , ++row));

    }
}
