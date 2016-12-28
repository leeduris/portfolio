public class J180 {

    public static void main(String[] args) {

        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("Enter the first charanter: ");
        char ch1 = in.next().charAt(0);
        System.out.print("Enter the second charanter: ");
        char ch2 = in.next().charAt(0);
        System.out.print("Enter the number per print line: ");
        int numberPerLine = in.nextInt();

        printChars((char)ch1, (char)ch2, numberPerLine);
    }

    public static void printChars(char ch1, char ch2, int numberPerLine) {
        int count = 1;
        for (int i = ch1; i <= ch2; i++, count++)
          if (count % numberPerLine == 0)
            System.out.println((char)i);
          else
            System.out.print((char)i + " ");
    }
  }
