import java.util.Arrays;

class MyExecutor {
    public static Character[][] multiply(Character[][] A, Character[][] B) {
        //перевірка розмірностей

        int nRowsA = A.length;
        int nRowsB = B.length;

        if (nRowsA == 0 || nRowsB == 0) {
            throw new IllegalArgumentException("Can't multiply empty matrix!");
        }

        int nColumnsA = A[0].length;
        int nColumnsB = B[0].length;

        checkMatrixIfComplete(A, nColumnsA);
        checkMatrixIfComplete(B, nColumnsB);

        if (nColumnsA != nRowsB) {
            throw new IllegalArgumentException("Number of columns of the first matrix is not the same as the number of rows of the second");
        }

        Character[][] C = new Character[nRowsA][nColumnsB];

        //C=A×B
        int i, j, m;
        for (i = 0; i < nRowsA; i++) {
            for (j = 0; j < nColumnsB; j++) {
                int res = 0;
                for (m = 0; m < nRowsB; m++) {
                    res += (int) A[i][m] * (int) B[m][j];
                    //System.out.println(i+ " " +j+ " "+m + " "+(int)A[i][m] + " "+ (int)B[m][j]);
                }
                C[i][j] = (char)res;
            }
        }

/*
        Arrays.stream(C)
                .forEach(r -> {
                    Arrays.stream(r)
                            .forEach(e -> System.out.print((int)e + " "));
                    System.out.print("\n");
                });

 */

        return C;
    }

    public static double average(Character[][] C) {
        double average = Arrays.stream(C)
                .flatMap(Arrays::stream) // Flatten the 2D array into a Stream<Character>
                .mapToInt(e -> (int) e) // Map each Character to its ASCII value (int)
                .average()
                .orElse(0.0);

        //System.out.println("Av " + average);

        return average;
    }

    static private void checkMatrixIfComplete(Character[][] A, int rowLength) {
        for (int i = 1; i < A.length; i++) {
            if (A[i].length != rowLength) {
                throw new IllegalArgumentException("Matrix is incomplete!");
            }
        }
    }

}
