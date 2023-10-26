import java.util.Scanner;

public class SortCalculate {
    public static void main(String[] args) {
        System.out.print("Enter the elements n= ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int Arr[] = new int[n];
        int S=0;
        double m=0;
        System.out.print("Import the elements: ");
        for(int i = 0; i < n; i++) {
            Arr[i] = scanner.nextInt();
            S=S+Arr[i];
        }
        m=S/n;
        for(int i =0; i< n; i++) {
            for(int j = 1; j < n; j++ ) {
                if(Arr[j-1] > Arr[j]) {
                    int tmp = Arr[j-1];
                    Arr[j-1] = Arr[j];
                    Arr[j] = tmp;
                }
            }
        }
        System.out.print("The array after sorting is: ");
        for(int i=0; i< n; i++) {
            System.out.print(Arr[i] + " ");
        }
        System.out.println("\nThe sum of array is: "+S);
        System.out.println("The average of array is: "+m);
        scanner.close();
        System.exit(0);
    }
}