public class J158 {

  public static void main(String[] args) {

    /** Print Pattern A */
    System.out.println("Print Pattern A");
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= i; j++)
        System.out.print(j + " ");
      System.out.println();
    }

    /** Print Pattern B */
    System.out.println("\n\nPrint Pattern B");
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 7-i; j++)
        System.out.print(j + " ");
      System.out.println();
    }

    /** Print Pattern C */
    System.out.println("\n\nPrint Pattern C");
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6-i; j++)
        System.out.print(" " + " ");
        for (int k = 1; k <= i; k++)
          System.out.print(k + " ");
      System.out.println();
    }

    /** Print Pattern D */
    System.out.println("\n\nPrint Pattern D");
    for (int i = 1; i <= 6; i++) {
      if (i >= 2) {
        for (int j = 2; j <= i; j++)
          System.out.print(" " + " ");
      }
      for (int k = 1; k <= 7-i; k++)
         System.out.print(k + " ");
      System.out.println();
    }
  }
}
