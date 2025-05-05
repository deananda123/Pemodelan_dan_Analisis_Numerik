package nomor2;
public class PolinomLagrange {
    public static void main(String[] args) {
        int x[] ={1,4,6};
        double y[] ={1.5709,1.5727, 1.5751};
        double X = 3.5;
        double l =0;
        double p = 0;
        System.out.println("hasil setiap L");
        for (int i = 0; i < x.length; i++) {
            double pi = 1.0;
            for (int j = 0; j < x.length; j++) {
                if (i != j) {
                    pi*= ( X- x[j])/(x[i]-x[j]);
                }
              l = y[i]* pi;
             
            }
            p+=l;
              System.out.println("L"+i+ " = "+pi);
        }
        System.out.println();
        System.out.println("p2(3.5)=" + p);
        
    }
    
}
