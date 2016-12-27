public class J169 {

  public static void main(String[] args) {

    int headCount = 0;
    int tailCount = 0;

    for (int i = 0; i < 1000000; i++) {
      int number = (int)(Math.random() * 1000000) % 2;

      if (number == 0)
        headCount++;
      else
        tailCount++;
    }

    System.out.println("head count: " + headCount);
    System.out.println("tail count: " + tailCount);
  }
}
