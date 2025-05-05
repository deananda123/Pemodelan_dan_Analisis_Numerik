package nomor1;
public class Gaus1 {

    public static void main(String[] args) {
        // Matriks augmented: [a0 a1 a2 | b]
        double[][] matrix = {
            {1, 8, 64, 2.0794},
            {1, 9, 81, 2.1972},
            {1, 9.5, 90.25, 2.2513}
        };

        int n = 3;

        // Eliminasi Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivot = matrix[i][i];
            for (int j = 0; j <= n; j++) {
                matrix[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j <= n; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }

        // Ambil hasil
        double a0 = matrix[0][3];
        double a1 = matrix[1][3];
        double a2 = matrix[2][3];

        // Hitung P2(x)
        double x = 9.2;
        double p2 = a0 + a1 * x + a2 * x * x;

        // Tampilkan output
        System.out.printf("a0  %.4f\n", a0);
        System.out.printf("a1  %.4f\n", a1);
        System.out.printf("a2  %.4f\n", a2);
        System.out.println("x= " + x);
        System.out.printf("P2(%.1f)\t%.6f\n", x, p2);
    }
}