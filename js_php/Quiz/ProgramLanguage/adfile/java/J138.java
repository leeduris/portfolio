public class J138 {

  public static void main(String args[]) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    System.out.println("Three random points are (an integer between 0 and 127)");

    // Enter an ASCII code
    System.out.print("Enter an ASCII code: ");
    int code = input.nextInt();

    // Display result
    System.out.println("The character for ASCII code "
      + code + " is " + (char)code);
  }
}
