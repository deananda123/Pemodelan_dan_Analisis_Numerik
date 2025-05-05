package nomor3;

public class Newton{
    public static void main(String[] args) {
        double[] x = {0.0, 1.0, 2.0, 3.0, 4.0};
        double[] y = {1.0000, 0.5403, -0.4161, -0.9900, -0.6536};
        int n = x.length;

        double[][] st = new double[n][n];
        for (int i = 0; i < n; i++) {
            st[i][0] = y[i];
        }

        // Hitung divided difference
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                st[i][j] = (st[i + 1][j - 1] - st[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        // Cetak tabel
        System.out.printf("%-3s %-6s %-8s", "i", "xi", "y1");
        for (int j = 1; j < n; j++) {
            System.out.printf(" ST-%d    ", j);
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%-3d %-6.1f %-8.4f", i, x[i], st[i][0]);
            for (int j = 1; j < n - i; j++) {
                System.out.printf(" %-8.4f", st[i][j]);
            }
            System.out.println();
        }

        // Evaluasi f(2.5)
        double xTarget = 2.5;
        double result = st[0][0];
        double term = 1.0;
        for (int i = 1; i < n-1; i++) {
            term *= (xTarget - x[i - 1]);
                result += st[0][i] * term;
        }
        System.out.printf("\n\nf(%.1f) = %.4f\n", xTarget, result);
        System.out.printf("Nilai sejati f(%.1f) = %.4f\n", xTarget, Math.cos(xTarget));
    }
}

