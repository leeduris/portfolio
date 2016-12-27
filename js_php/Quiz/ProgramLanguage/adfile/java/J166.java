public class J166 {

  public static void main(String[] args) {

    int count = 0;

    while (count <= 2 && count >= -2) {

        // Generate scissor, rock, paper
        int computerNumber = (int)(Math.random() * 3);

        // Prompt the user to enter scissor, rock, or paper
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.print("\nInput scissor (0), rock (1), paper (2): ");
        int userNumber = input.nextInt();

        // Check the guess
        switch (computerNumber) {
        case 0:
          if (userNumber == 0) {
            System.out.println("It is a draw (Computer: " + computerNumber + ")");
          }
          else if (userNumber == 1) {
            System.out.println("You won (Computer: " + computerNumber + ")");
            count++;
          }
          else if (userNumber == 2) {
            System.out.println("You lost (Computer: " + computerNumber + ")");
            count--;
          }
          break;
        case 1:
          if (userNumber == 0) {
            System.out.println("You lost (Computer: " + computerNumber + ")");
            count--;
          }
          else if (userNumber == 1) {
            System.out.println("It is a draw (Computer: " + computerNumber + ")");
          }
          else if (userNumber == 2) {
            System.out.println("You won (Computer: " + computerNumber + ")");
            count++;
          }
          break;
        case 2:
          if (userNumber == 0) {
            System.out.println("You won (Computer: " + computerNumber + ")");
            count++;
          }
          else if (userNumber == 1) {
            System.out.println("You lost (Computer: " + computerNumber + ")");
            count--;
          }
          else if (userNumber == 2) {
            System.out.println("It is a draw (Computer: " + computerNumber + ")");
          }
          break;
        }
        System.out.println("Your Win Counter is " + count);
    }

    if (count > 2) {
      System.out.println("\nYou won more than two times");
    }
    else {
      System.out.println("\nThe computer won more than two times");
    }
  }
}
