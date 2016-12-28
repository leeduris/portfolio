public class J203 {

  public static void main(String[] args) {
    // Initialize the list
    double[] myList = new double[10];
    System.out.println("10 numbers are: ");

    for (int i = 0; i < myList.length; i++) {
      myList[i] = (int)(Math.random()*10000)/100.0 + 1;
      System.out.print(myList[i] + ", ");
    }

    // Sort the list
    selectionSort(myList);

    // Print the sorted list
    System.out.println();
    System.out.println("My list after sort is: ");
    printList(myList);
  }

  /** The method for printing numbers */
  static void printList(double[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + ", ");
    System.out.println();
  }

  /** The method for sorting the numbers */
  static void selectionSort(double[] list) {
    double currentMax;
    int currentMaxIndex;

    for (int i = list.length - 1; i >= 0; i--) {
      // Find the largest in the list[i..list.length-1]
      currentMax = list[i];
      currentMaxIndex = i;

      for (int j = 0; j < i; j++) {
        if (currentMax < list[j]) {
          currentMax = list[j];
          currentMaxIndex = j;
        }
      }

      // Swap list[i] with list[currentMaxIndex] if necessary;
      if (currentMaxIndex != i) {
        list[currentMaxIndex] = list[i];
        list[i] = currentMax;
      }
    }
  }
}
