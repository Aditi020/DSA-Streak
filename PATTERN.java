// Run to see the pattern formed.

import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        pattern1(5,5);
        System.out.println();
       pattern2(5,5);
        System.out.println();
        pattern3(5,5);
        System.out.println();
        pattern4(5,5);
        System.out.println();
        pattern5(5,5);
        System.out.println();
        pattern6(5,5);
        System.out.println();
        pattern7(5,5);
        System.out.println();
        pattern8(5,5);
        System.out.println();
        pattern9(5,5);
        System.out.println();
        pattern10(5,5);
        System.out.println();
        pattern11(5);
        System.out.println();
        pattern12(5);
        System.out.println();
        pattern13(5);
        System.out.println();
        pattern14(5);
        System.out.println();

    }

    public static void pattern1(int n, int m){
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n, int m){
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n, int m){
        for (int i = n; i >=0 ; i--) {
            for (int j = i; j>=0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern4(int n, int m){
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void pattern5(int n, int m){
        for (int i = 0; i <2*n ; i++) {
                int c=i>n? 2*n-i :i;
            for (int j = 0; j <c ; j++) {
                System.out.print("*");
            }
                System.out.println();
            }
        }

    public static void pattern6(int n, int m){
        for (int i = n; i >0 ; i--) {
            for (int j = 0; j<=m; j++) {
                if(j<i)
                System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern7(int n, int m){
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j<=m; j++) {
                if(j<=i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern8(int n, int m){
        pattern6(m,n);
        for (int i = 0; i <=m; i++)
            System.out.print("*");
        System.out.println();
        pattern3(m,n);
    }

    public static void pattern9(int n, int m){
        pattern6(m,n);
        for (int i = 0; i <=m; i++)
            System.out.print("*");
        System.out.println();
        pattern7(m,n);
    }

    public static void pattern10(int n, int m){
        for (int i = 0; i <2*n ; i++) {
            int c=i>n? 2*n-i :i;            int s=n-c;
            for (int j = 0; j < s; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <c ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern11(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalColsInRow = row > n ? 2 * n - row: row;

            int noOfSpaces = n - totalColsInRow;
            for (int s = 0; s < noOfSpaces; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern12(int n) {
        for (int row = 1; row <= n; row++) {

            for (int space = 0; space < n-row; space++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }

    static void pattern13(int n) {
        for (int row = 1; row <= 2 * n; row++) {

            int c = row > n ? 2 * n - row: row;

            for (int space = 0; space < n-c; space++) {
                System.out.print("  ");
            }

            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }
    static void pattern14(int n) {
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}



