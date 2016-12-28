public class J193 {

    public static void main(String[] args) {
      for (int i = 1; i <= 100; i++) {
        if (i % 10 == 0)
          System.out.println(RandomCharacter.getRandomCharacter('A', 'Z'));
        else
          System.out.print(RandomCharacter.getRandomCharacter('A', 'Z'));
      }

      System.out.println();

      for (int i = 1; i <= 100; i++) {
        if (i % 10 == 0)
          System.out.println(RandomCharacter.getRandomCharacter('0', '9'));
        else
          System.out.print(RandomCharacter.getRandomCharacter('0', '9'));
      }
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
