public class J157 {

  public static void main(String args[]) {

    java.util.Scanner input = new java.util.Scanner(System.in);

    // Prompt the user to enter a positive integer
    System.out.print(
      "Enter a positive integer: ");
    int number = input.nextInt();

    // Find all the smallest factors of the integer
    System.out.println("The factors for " + number + " is");
    int factor = 2;
    String fprint = "";
    while (factor <= number) {
      if (number % factor == 0) {
        number = number / factor;
        fprint = fprint + factor + ", ";
      } else {
          factor++;
      }
    }
    fprint = fprint.substring(0, fprint.length()-2);
    System.out.println(fprint);
  }
}
