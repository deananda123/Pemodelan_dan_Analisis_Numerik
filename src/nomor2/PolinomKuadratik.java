package nomor2;

public class PolinomKuadratik {

    // Fungsi untuk menyelesaikan sistem persamaan linear menggunakan Eliminasi Gauss
    public static double[] gaussElimination(double[][] A, double[] b) {
        int n = b.length;

        // Eliminasi maju
        for (int i = 0; i < n; i++) {
            // Pivoting
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[max][i])) {
                    max = j;
                }
            }

            // Tukar baris
            double[] temp = A[i];
            A[i] = A[max];
            A[max] = temp;

            double t = b[i];
            b[i] = b[max];
            b[max] = t;

            // Eliminasi
            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                b[j] -= factor * b[i];
                for (int k = i; k < n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        // Substitusi mundur
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = b[i];
            for (int j = i + 1; j < n; j++) {
                sum -= A[i][j] * x[j];
            }
            x[i] = sum / A[i][i];
        }

        return x;
    }

    public static void main(String[] args) {
        // Matriks koefisien A
        double[][] A = {
            {1, 8.0, 64.00},
            {1, 9.0, 81.00},
            {1, 9.5, 90.25}
        };

        // Vektor konstanta b
        double[] b = {2.0794, 2.1972, 2.2513};

        // Hitung solusi a0, a1, a2
        double[] result = gaussElimination(A, b);

        System.out.println("Koefisien polinom kuadratik:");
        System.out.printf("a0 = %.6f\n", result[0]);
        System.out.printf("a1 = %.6f\n", result[1]);
        System.out.printf("a2 = %.6f\n", result[2]);

        // Bentuk polinom: a0 + a1*x + a2*x^2
        System.out.println("\nPolinom kuadratik:");
        System.out.printf("P(x) = %.6f + %.6f*x + %.6f*x^2\n", result[0], result[1], result[2]);
    }
}