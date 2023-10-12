import javax.swing.JOptionPane;
import java.util.Scanner;
public class SolveEquation {
    public static void main(String[] args) {
        int otp;
        System.out.println("List of tools:");
        System.out.println("1.Solve first-order equations\t ax+b=0");
        System.out.println("2.Solve a system of first-order equations\n\t a11x1+a12x2=b1\n\t a21x1+a22x2=b2");
        System.out.println("3.Solve third-order equations\t ax^2+bx+c=0");
        System.out.print("Choose a tool to solve: ");
        Scanner scanner = new Scanner(System.in);
        otp = scanner.nextInt();
        if (otp == 1) {
            double a, b;
            System.out.print("Enter a=");
            a = scanner.nextDouble();
            System.out.print("Enter b=");
            b = scanner.nextDouble();
            if (a == 0 && b == 0) {
                System.out.println("Infinite solutions!");
            } else if (a == 0 && b != 0) {
                System.out.println("No solution!");
            } else {
                double x = -b / a;
                System.out.println("Equation has one solution x= " + x);
            }

        }
        if (otp == 2) {
            double a11, a12, a21, a22, b1, b2, d, d1, d2, x1, x2;
            System.out.print("Enter a11= ");
            a11 = scanner.nextDouble();
            System.out.print("Enter a12= ");
            a12 = scanner.nextDouble();
            System.out.print("Enter a21= ");
            a21 = scanner.nextDouble();
            System.out.print("Enter a22= ");
            a22 = scanner.nextDouble();
            System.out.print("Enter b1= ");
            b1 = scanner.nextDouble();
            System.out.print("Enter b2= ");
            b2 = scanner.nextDouble();
            d = a11 * a22 - a21 * a12;
            d1 = b1 * a22 - a12 * b2;
            d2 = a11 * b2 - a21 * b1;
            if (d == 0 && d1 == 0 && d2 == 0) {
                System.out.println("Infinite solutions!");
            } else if (d != 0) {
                x1 = d1 / d;
                x2 = d2 / d;
                System.out.println("The system equation has only solution\n\t x1=" + x1 + "\n\tx2=" + x2);
            } else {
                System.out.println("No solution!");
            }
        }
        if (otp == 3) {
            double a, b, c, x, d, x1, x2;
            System.out.print("Enter a= ");
            a = scanner.nextDouble();
            System.out.print("Enter b= ");
            b = scanner.nextDouble();
            System.out.print("Enter c= ");
            c = scanner.nextDouble();
            if (a == 0) {
                if (b == 0) {
                    if (c == 0) {
                        System.out.println("Infinite solutions!");
                    } else
                        System.out.println("No solution!");
                } else {
                    x = -c/b;
                    System.out.println("Only solution x=" + x);
                }
            } else {
                d = b * b - 4 * a * c;
                x1 = (-b + Math.sqrt(d)) / a;
                x2 = (-b - Math.sqrt(d)) / a;
                System.out.println("2 Solutions\n\tx1=" + x1 + "\tx2=" + x2);
            }
        }
    }
}