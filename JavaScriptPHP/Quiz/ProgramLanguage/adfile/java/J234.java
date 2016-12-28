import java.util.Scanner;

public class J234 {

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
      double x1 = input.nextDouble();
      double y1 = input.nextDouble();
      double x2 = input.nextDouble();
      double y2 = input.nextDouble();
      double x3 = input.nextDouble();
      double y3 = input.nextDouble();
      double x4 = input.nextDouble();
      double y4 = input.nextDouble();

      // Build a 2 by 2 linear equation
      double a = (y1 - y2);
      double b = (-x1 + x2);
      double c = (y3 - y4);
      double d = (-x3 + x4);
      double e = -y1 * (x1 - x2) + (y1 - y2) * x1;
      double f = -y3 * (x3 - x4) + (y3 - y4) * x3;

      LinearEquation equation = new LinearEquation(a, b, c, d, e, f);

      if (equation.isSolvable()) {
        System.out.printf("The intersecting point is: (%.2f, %.2f)\n",
                          equation.getX(),equation.getY());
      }
      else {
        System.out.println("The two lines do not cross ");
      }
    }
  }

class LinearEquation {

    private double a, b, c, d, e, f;

    public LinearEquation (double newA, double newB, double newC, double newD, double newE, double newF) {
      a =  newA;
      b =  newB;
      c =  newC;
      d =  newD;
      e =  newE;
      f =  newF;
    }

    double getA() {
      return a;
    }

    double getB() {
      return b;
    }

    double getC() {
      return c;
    }

    double getD() {
      return d;
    }

    double getE() {
      return e;
    }

    double getF() {
      return f;
    }

    boolean isSolvable() {
      if ((a*d - b*c) != 0) {
        return true;
      }
      return false;
    }

    double getX() {
      if (isSolvable()) {
        return (e*d - b*f) / (a*d-b*c);
      }
      return 0;
    }

    double getY() {
      if (isSolvable()) {
        return (a*f - e*c) / (a*d-b*c);
      }
      return 0;
    }
}
