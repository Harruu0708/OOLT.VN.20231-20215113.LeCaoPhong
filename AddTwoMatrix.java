import java.util.Scanner;

public class AddTwoMatrix {
    public static Scanner scanner = new Scanner(System.in);
    public static void show(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = scanner.nextInt();
        int[][] mat_1 = new int[n][m];
        System.out.print("Enter the elements of the first matrix: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("a[%d][%d] = ",i,j);
                mat_1[i][j] = scanner.nextInt();
            }
        }
        int[][] mat_2 = new int[n][m];
        System.out.print("Enter the elements of the second matrix: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("b[%d][%d] = ",i,j);
                mat_2[i][j] = scanner.nextInt();
            }
        }
        int[][] mat_3= new int[n][m];
        for(int i = 0; i<n;i++) {
            for (int j= 0; j<m;j++) {
                mat_3[i][j]=mat_1[i][j] +mat_2[i][j];
            }
        }

        System.out.println("The first matrix: ");
        show(mat_1);
        System.out.println("The second matrix: ");
        show(mat_2);
        System.out.println("Sum of two matrix: ");
        show(mat_3);

    }
}