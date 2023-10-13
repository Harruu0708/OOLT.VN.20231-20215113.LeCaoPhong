import java.util.Scanner;

public class DayofMonth {
    public static void main(String[] args) {
        String[] Month_31 = {"January", "Jan.", "Jan", "1",
                "March", "Mar.", "Mar", "3",
                "May", "5",
                "July", "Jul", "7",
                "August", "Aug.", "Aug", "8",
                "October", "Oct.", "Oct", "10",
                "December", "Dec.", "Dec", "12"};
        String[] Month_30 = {"April", "Apr.", "Apr", "4",
                "June", "Jun", "6",
                "September", "Sept.", "Sep", "9",
                "November", "Nov.", "Nov", "11"};
        String[] Month_2 = {"February", "Feb.", "Feb", "2"};
        while(true) {
            int Year;
            while(true){
                System.out.print("Enter the year: ");
                Scanner year = new Scanner(System.in);
                Year = year.nextInt();
                if(Year >= 0){
                    break;
                }else {
                    continue;
                }
            }
            System.out.print("Enter the month: ");
            Scanner month = new Scanner(System.in);
            String strMonth = month.nextLine();
            for(String s : Month_31) {
                if(s.equals(strMonth)) {
                    System.out.println( s+ " " + Year + " The day of month: 31");
                    System.exit(0);
                }
            }

            for(String s : Month_30) {
                if(s.equals(strMonth)) {
                    System.out.println(s + " "+ Year + " The day of month: 30");
                    System.exit(0);
                }
            }

            for(String s : Month_2) {
                if(s.equals(strMonth)) {
                    if(Year%4 == 0 && Year%100 != 0||Year%400==0) {
                        System.out.println(s+" "+ Year + " The day of month: 29");
                        System.exit(0);
                    }
                    else {
                        System.out.println( s+" " +Year + " The day of month: 28");
                        System.exit(0);
                    }
                }
            }
            System.out.println("Error!!Enter again:\n");
        }
    }
}