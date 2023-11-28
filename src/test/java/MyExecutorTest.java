import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyExecutorTest {
    @Test
    void multiply_CorrectData_ReturnCorrectResult(){
        Character[][] A = {{32, 20}, {12, 7}, {2, 4}};
        Character[][] B = {{56, 6}, {12, 7}};
        Character[][] Expected = {{2032, 332}, {756, 121}, {160, 40}};

        Character[][] res = MyExecutor.multiply(A,B);
        assertTrue(Arrays.deepEquals(Expected,res));
    }

    @Test
    void multiply_OneDimensionalMatrix_ReturnCorrectResult(){
        Character[][] A = {{13}, {2}, {3}, {5}};
        Character[][] B = {{23, 0}};

        Character[][] Expected = {{299, 0}, {46, 0}, {69, 0}, {115, 0}};

        Character[][] res = MyExecutor.multiply(A,B);
        assertTrue(Arrays.deepEquals(Expected,res));
    }

    @Test
    void multiply_MatricesNColumnsNWidthAreNotEqual_ExceptionThrown(){
        Character[][] A = {{32, 20}, {12, 17}, {2, 4}};
        Character[][] B = {{32, 20}, {12, 17}, {2, 4}};

        String exceptionMessage = "Number of columns of the first matrix is not the same as the number of rows of the second";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                MyExecutor.multiply(A,B)
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void multiply_SecondMatrixIsEmpty_ExceptionThrown(){
        Character[][] A = {{1,2}};
        Character[][] B = {};

        String exceptionMessage = "Can't multiply empty matrix!";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                MyExecutor.multiply(A,B)
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void multiply_FirstMatrixIsEmpty_ExceptionThrown(){
        Character[][] A = {};
        Character[][] B = {{1,2}};

        String exceptionMessage = "Can't multiply empty matrix!";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                MyExecutor.multiply(A,B)
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void multiply_IncompleteMatrix_ExceptionThrown(){
        Character[][] A = {{0,1}, {0}};
        Character[][] B = {{1,2}};

        String exceptionMessage = "Matrix is incomplete!";
        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                MyExecutor.multiply(A,B)
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void average_CorrectData_CorrectReturn (){
        Character[][] A = {{1,2}, {12, 10}};
        double exp = 6.25;

        double got = MyExecutor.average(A);
        assertEquals(exp, got);
    }

    @Test
    void average_EmptyMatrix_CorrectReturn (){
        Character[][] A = {};
        double exp = 0;

        double got = MyExecutor.average(A);
        assertEquals(exp, got);
    }

    @Test
    void average_IncompleteMatrix_CorrectReturn (){
        Character[][] A = {{1, 2}, {12}};
        double exp = 5;

        double got = MyExecutor.average(A);
        assertEquals(exp, got);
    }
}