import java.util.Arrays;

public class Main {
    @FunctionalInterface
    private interface PrintMatrix{
        void p(Character[][] c);
    }
    public static void main(String[] args) {
        PrintMatrix printMatrix = (Character[][] M) ->
            Arrays.stream(M)
                    .forEach(r -> {
                        Arrays.stream(r)
                                .forEach(e -> System.out.print((int)e + " "));
                        System.out.print("\n");
                    });


        Character[][] A = {{12, 11}, {5, 4}, {6, 22}};
        Character[][] B = {{0, 11}, {20, 4}};
        Character[][] C;

        try {
            C = MyExecutor.multiply(A,B);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        };

        System.out.println("A: ");
        printMatrix.p(A);
        System.out.println("\n" + "B: ");
        printMatrix.p(B);

        System.out.println("\n" + "C=A×B");
        printMatrix.p(C);

        System.out.println("Average: " + MyExecutor.average(C));
    }
}