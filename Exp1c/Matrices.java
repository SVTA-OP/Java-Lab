import java.util.Scanner;

class Print {
    void printMatrix(int[][] m){
        int i,j, n = m.length;
        for (i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println("");
        }
    }
}

public class Matrices {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int i,j;

        System.out.print("Enter size (n x n): "); int n = myObj.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] sum = new int[n][n];
        int[][] difference = new int[n][n];
        int[][] product = new int[n][n];

        System.out.println("Matrix A: ");
        for (i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print("Enter element ("+(i+1)+" x "+(j+1)+"): ");
                A[i][j] = myObj.nextInt();
            }
        }
        System.out.println("Matrix B: ");
        for (i=0;i<n;i++){
            for(j=0;j<n;j++){
                System.out.print("Enter element ("+i+" x "+j+"): ");
                B[i][j] = myObj.nextInt();
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                sum[i][j] = A[i][j] + B[i][j];
                difference[i][j] = A[i][j] - B[i][j];
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                product[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    product[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        Print myObj1 = new Print();
        System.out.println("Sum: ");
        myObj1.printMatrix(sum);
        System.out.println("\nDifference: ");
        myObj1.printMatrix(difference);
        System.out.println("\nProduct: ");
        myObj1.printMatrix(product);

    }
}