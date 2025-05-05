package nomor1;

public class Gaus2{

    public static void main(String[] args) {

        // Matriks augmented: [a0 a1 a2 | b]
        double[][] matrix = {
            {1, 1, 1, 1.5709},
            {1, 4, 16, 1.5727},
            {1, 6, 36, 1.5751}
        };

        int n = 3; // jumlah persamaan

        // Gauss-Jordan elimination
        for (int i = 0; i < n; i++) {
            // Normalisasi baris pivot
            double pivot = matrix[i][i];
            for (int j = 0; j < n + 1; j++) {
                matrix[i][j] /= pivot;
            }

            // Eliminasi baris lain
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j < n + 1; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                    }
                }
            }
        }

        // Ambil hasil (koefisien)
        double a0 = matrix[0][3];
        double a1 = matrix[1][3];
        double a2 = matrix[2][3];

        // Cetak koefisien
        System.out.printf("a0 = %.5f\n", a0);
        System.out.printf("a1 = %.5f\n", a1);
        System.out.printf("a2 = %.5f\n", a2);

        // Hitung nilai P(x) untuk x = 9.2
        double x = 9.2;
        double p2 = a0 + a1 * x + a2 * x * x;
        System.out.printf("P2(%.1f) = %.5f\n", x, p2);
    }
}