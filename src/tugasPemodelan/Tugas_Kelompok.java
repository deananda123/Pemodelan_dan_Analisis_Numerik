package tugasPemodelan;

public class Tugas_Kelompok {

    // Fungsi f(x) = x^2 - x - 6
    public static double f(double x) {
        return x * x - x - 6;
    }

   
    public static double hitungLuasTrapesium(double a, double b, int n) {
        double h = (b - a) / n;
        double total = 0;
        
        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            double fx = f(x);
            // Print semua nilai x dan f(x)
            System.out.println("x" + i + " = " + x + ", f(x" + i + ") = " + fx);

            // Hitung total dengan bobot sesuai metode trapesium
            if (i == 0 || i == n) {
                total += fx; 
            } else {
                total += 2 * fx;
            }
        }

        return (h / 2) * total;
        
    }

    public static void main(String[] args) {
        double a = -5;     
        double b = 5;      
        int n = 10;         

        double luas = hitungLuasTrapesium(a, b, n);
        System.out.printf("Luas aproksimasi dengan metode trapesium: %.1f\n", luas);
    }
}
