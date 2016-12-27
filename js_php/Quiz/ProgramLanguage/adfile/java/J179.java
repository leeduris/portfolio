public class J179 {

    public static void main(String[] args) {

        java.util.Scanner in = new java.util.Scanner(System.in);
        int num = in.nextInt();

        int count = 0;
        for (int number = 2; number < num; number++) {
            if (isPrime(number)) {
                if (count % 20 == 0)
                    System.out.println();

                System.out.print(number + " ");
                count++;
            }
        }

        System.out.println("\n\nThe number of prime number < " + num + " is "
        + count);
    }

    /** Check whether number is prime */
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0)  // If true, number is not prime
                return false; // number is not a prime
        }
        return true; // number is prime
    }
  }
