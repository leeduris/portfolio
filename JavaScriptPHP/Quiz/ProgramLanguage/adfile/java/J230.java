import java.util.Random;

public class J230 {

    public static void main(String[] args) {
      Random random = new Random(1000);

      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++)
          System.out.printf("%4d",random.nextInt(100));
        System.out.println();
      }
    }
  }
