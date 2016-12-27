public class J204 {

    public static void main(String[] args) {

        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.print("How many Queens puzzle do you want ? ");
        int qNum = in.nextInt();

        int[] queens = new int[qNum];
        int sum = 0;
        do {
            for (int i = 0; i < qNum; i++) {
                queens[i] = (int)(Math.random()*qNum);
                sum += queens[i];
            }
        } while (sameColumn(queens) || sameDiagonal(queens));

        printResult(queens, qNum);
    }

    static boolean sameDiagonal(int[] queens) {
        for (int i = 0; i < queens.length -1 ; i++) {
            if (Math.abs(queens[i]-queens[i+1]) <= 1)
                return true;
        }
        return false;
    }

    static boolean sameColumn(int[] queens) {
        int qsum = 0;
        int rsum = 0;

        for (int i = 0; i < queens.length; i++)
            qsum += Math.pow(i, 3);

        for (int i = 0; i < queens.length; i++)
            rsum += Math.pow(queens[i], 3);

        if (!(rsum == qsum))
            return true;
        else
            return false;
        }

    static void printResult(int[] queens, int qNum) {
        for (int i = 0; i < qNum; i++)
            System.out.println(i + ", " + queens[i]);
        System.out.println();

        // Display the output
        for (int i = 0; i < qNum; i++) {
            for (int j = 0; j < queens[i]; j++)
                System.out.print("| ");
            System.out.print("|Q|");
            for (int j = queens[i] + 1; j < qNum; j++)
                System.out.print(" |");
            System.out.println();
        }
  }
}
