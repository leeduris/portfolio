import java.util.Scanner;

public class J192 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Enter the number of sides
    System.out.print("Enter the number of sides: ");
    int numberOfSides = input.nextInt();

    System.out.print("Enter the side: ");
    double side = input.nextDouble();

    System.out.println("The area of the polygon is " +
      area(numberOfSides, side));
  }

  public static double area(int n, double side) {
    return n * side * side / Math.tan(Math.PI / n) / 4;
  }
}

  class RandomCharacter {
     /** Generate a random character between ch1 and ch2 */
         public static char getRandomCharacter(char ch1, char ch2) {
         return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
         }

         /** Generate a random lowercase letter */
         public static char getRandomLowerCaseLetter() {
         return getRandomCharacter('a', 'z');
        }

         /** Generate a random uppercase letter */
         public static char getRandomUpperCaseLetter() {
         return getRandomCharacter('A', 'Z');
         }

         /** Generate a random digit character */
         public static char getRandomDigitCharacter() {
         return getRandomCharacter('0', '9');
         }

         /** Generate a random character */
         public static char getRandomCharacter() {
         return getRandomCharacter('\u0000', '\uFFFF');
         }
     }
