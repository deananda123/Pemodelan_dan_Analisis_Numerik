package nomor2;


public class PolinomLanjar {

    public static double interpolasiLinier(double x0, double y0, double x1, double y1, double xp) {
        return y0 + ((y1 - y0) / (x1 - x0)) * (xp - x0);
    }

    public static void main(String[] args) {
        double x0 = 8.0;
        double y0 = 2.0794;

        double x1 = 9.0;
        double y1 = 2.1972;

        // Titik yang ingin ditaksir
        double xp = 8.5;

        // Hitung hasil interpolasi linier
        double hasil = interpolasiLinier(x0, y0, x1, y1, xp);

        // Tampilkan hasil
        System.out.println("=== Polinom Linier===");
        System.out.printf("Titik: (%.1f, %.4f) dan (%.1f, %.4f)\n", x0, y0, x1, y1);
        System.out.printf("Taksiran f(%.2f) = %.6f\n", xp, hasil);
    }
}