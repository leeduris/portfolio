public class J219 {

  public static void main(String[] args) {
    int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

    System.out.print("Before: ");
    printArray(m);

    shuffle(m);

    System.out.print("After:  ");
    printArray(m);

  }

  public static void shuffle(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      int row = (int)(Math.random() * m.length);

      // Swap m[row] with m[i]
      int[] temp = m[i];
      m[i] = m[row];
      m[row] = temp;
    }
  }

    public static void printArray(int m[][]) {
      System.out.print("{");
    for (int i = 0; i < m.length-1; i++) {
      System.out.print("{" + m[i][0] + "," + m[i][1] + "},");
    }
      System.out.print("{" + m[m.length-1][0] + ", " + m[m.length-1][1] + "}}\n");
  }
}
