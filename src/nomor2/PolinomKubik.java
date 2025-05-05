package nomor2;

public class PolinomKubik {

    public static void main(String[] args) {
        // Titik data
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 5, 4};

        // Matriks augmented 4x5 (A | y)
        double[][] matrix = new double[4][5];
        for (int i = 0; i < 4; i++) {
            matrix[i][0] = 1;
            matrix[i][1] = x[i];
            matrix[i][2] = Math.pow(x[i], 2);
            matrix[i][3] = Math.pow(x[i], 3);
            matrix[i][4] = y[i];
        }

        // Eliminasi Gauss
        for (int i = 0; i < 4; i++) {
            // Pivoting
            for (int k = i + 1; k < 4; k++) {
                if (Math.abs(matrix[i][i]) < Math.abs(matrix[k][i])) {
                    double[] temp = matrix[i];
                    matrix[i] = matrix[k];
                    matrix[k] = temp;
                }
            }

            // Eliminasi
            for (int k = i + 1; k < 4; k++) {
                double factor = matrix[k][i] / matrix[i][i];
                for (int j = i; j < 5; j++) {
                    matrix[k][j] -= factor * matrix[i][j];
                }
            }
        }

        // Substitusi balik
        double[] a = new double[4];
        for (int i = 3; i >= 0; i--) {
            a[i] = matrix[i][4];
            for (int j = i + 1; j < 4; j++) {
                a[i] -= matrix[i][j] * a[j];
            }
            a[i] /= matrix[i][i];
        }

        // Tampilkan koefisien
        System.out.println("Koefisien polinom kubik:");
        System.out.printf("a0 = %.4f\n", a[0]);
        System.out.printf("a1 = %.4f\n", a[1]);
        System.out.printf("a2 = %.4f\n", a[2]);
        System.out.printf("a3 = %.4f\n", a[3]);

        // Hitung nilai taksiran untuk x = 2.5
        double xTaksir = 2.5;
        double yTaksir = a[0] + a[1] * xTaksir + a[2] * Math.pow(xTaksir, 2) + a[3] * Math.pow(xTaksir, 3);
        System.out.printf("\nTaksiran y pada x = %.2f adalah y = %.4f\n", xTaksir, yTaksir);
    }
}