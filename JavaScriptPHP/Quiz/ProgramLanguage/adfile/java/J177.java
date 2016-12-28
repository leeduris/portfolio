public class J177 {

  public static void main(String[] args) {
      java.util.Scanner input = new java.util.Scanner(System.in);
      System.out.print("Enter line number: (less than 100)");
      int lineNumber = input.nextInt();

      displayPattern(lineNumber);
    }

    public static void displayPattern(int n) {
      for (int row = 1; row <= n; row++) {

        // Print spaces
        for (int i = row; i < n; i++)
          System.out.print("  ");
        if (row <= n-1 && row < 10) {
            int j = n;
            while (j-10 >= 0) {
                System.out.print(" ");
                j--;
            }
        }

        if (row <= n-1 && row >= 10) {
            int j = n;
            while (j-row > 0) {
                System.out.print(" ");
                j--;
            }
        }

        // Print numbers
        for (int i = row; i >= 1; i--)
           System.out.print(" " + i);


        System.out.println();
      }
    }
  }
