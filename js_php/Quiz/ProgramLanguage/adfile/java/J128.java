public class J128 {

    public static void main(String[] args) {

        java.util.Scanner input = new java.util.Scanner(System.in);
        // Enter year
        System.out.print("Enter year (e.g., 2012): ");
        int year = input.nextInt();

        // Enter month
        System.out.print("Enter month: 1-12: ");
        int month = input.nextInt();

        // Enter day
        System.out.print("Enter the day of the month: 1-31: ");
        int day = input.nextInt();

        if (month == 1) {
            month = 13;
            year = year -1;
        } else if (month == 2) {
            month = 14;
            year = year -1;
        }

        //calculate day of the week
        int h = (day + 26*(month+1)/10 + (year%100) + (year%100)/4 +
                         (year/100)/4 + 5*(year/100)) % 7;

        String dayOfWeek = "";
        switch (h) {
            case 0: dayOfWeek = "Saturday"; break;
            case 1: dayOfWeek = "Sunday"; break;
            case 2: dayOfWeek = "Monday"; break;
            case 3: dayOfWeek = "Tuesday"; break;
            case 4: dayOfWeek = "Wednesday"; break;
            case 5: dayOfWeek = "Thursday"; break;
            case 6: dayOfWeek = "Friday"; break;
        }

        // Display the result
        System.out.println("Day of the week is " + dayOfWeek);
    }
}
