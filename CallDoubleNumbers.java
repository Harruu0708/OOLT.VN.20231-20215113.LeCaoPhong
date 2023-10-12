import javax.swing.JOptionPane;
import java.util.Scanner;
public class CallDoubleNumbers{
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotificationSum = "Sum of two inputs is ";
        String strNotificationDif = "Dif of two inputs is ";
        String strNotificationPrd = "Product of two inputs is ";
        String strNotificationQtient = "Quotient of two inputs is ";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        strNotificationSum += num1 + num2;
        strNotificationDif += num1 - num2;
        strNotificationPrd += num1 * num2;
        if(num2==0)
            strNotificationQtient = "Unidentified!";
        else
            strNotificationQtient += num1/num2;
        System.out.println(strNotificationSum);
        System.out.println(strNotificationDif);
        System.out.println(strNotificationPrd);
        System.out.println(strNotificationQtient);
    }
}