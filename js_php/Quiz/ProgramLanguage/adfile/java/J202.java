public class J202 {

  public static void main (String[] args) {

    double[] myList = new double[10];
    System.out.println("10 numbers are: ");

    for (int i = 0; i < myList.length; i++) {
      myList[i] = (int)(Math.random()*10000)/100.0 + 1;
      System.out.print(myList[i] + ", ");
    }

    bubbleSort(myList);

    //prints the sorted list
    System.out.println("\nMy list after sort is: ");
    printList(myList);
  }

  static void printList(double[] list) {
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + ", ");
  }

  static void bubbleSort(double[] list) {
    boolean changed;
    do {
      changed = false;
      for (int j = 0; j < list.length - 1; j++) {
        if (list[j] > list[j+1]) {
          //swap list[j] wiht list[j+1]
          double temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;
          changed = true;
        }
      }
    } while (changed);
  }
}
