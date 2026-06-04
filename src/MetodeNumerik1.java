public class MetodeNumerik1 {

      public static double potongDesimal(double angka, int desimal) {
        double pengali = Math.pow(10, desimal);
        return Math.floor(angka * pengali) / pengali;
    }

    public static double fungsi(double x) {
        return Math.pow(x, 3) - (2 * x) - 5;
    }

    public static void main(String[] args) {
        double xn = 1.0;         
        double xn_plus_1 = 4.0;  
        double error_target = 0.05;
        int iterasi = 1;

        System.out.println("=======================================================================================");
        System.out.printf("%-3s | %-7s | %-7s | %-8s | %-8s | %-7s | %-8s\n", 
                "No", "Xn", "Xn+1", "F(Xn)", "F(Xn+1)", "Xmid", "F(Xmid)");
        System.out.println("=======================================================================================");

        while (true) {
          
            double x_mid = Math.round(((xn + xn_plus_1) / 2.0) * 10000.0) / 10000.0;
            
            double f_xn = potongDesimal(fungsi(xn), 3);
            double f_xn_plus_1 = potongDesimal(fungsi(xn_plus_1), 3);
            double f_xmid = potongDesimal(fungsi(x_mid), 3);

            System.out.printf("%-3d | %-7.3f | %-7.3f | %-8.3f | %-8.3f | %-7.3f | %-8.3f\n", 
                    iterasi, xn, xn_plus_1, f_xn, f_xn_plus_1, x_mid, f_xmid);

            if (Math.abs(f_xmid) <= error_target) {
                System.out.println("=======================================================================================");
                System.out.printf("\nIterasi berhenti pada iterasi ke-%d\n", iterasi);
                System.out.printf("Nilai Xmid : %.3f\n", x_mid);
                System.out.printf("Nilai F(Xmid) : %.3f\n", f_xmid);
                break;
            }

            if (f_xn * f_xmid < 0) {
                xn_plus_1 = x_mid;
            } else {
                xn = x_mid;
            }
            iterasi++;
        }
    }
}