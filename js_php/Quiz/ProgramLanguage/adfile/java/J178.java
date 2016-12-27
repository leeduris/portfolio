public class J178 {

  public static void main(String[] args) {

    System.out.printf("%-14s%-14s  |  %-14s%-14s%n", "Celsius","fahrenheit", "fahrenheit", "Celsius");


    double celsius = 40.0;
    double fahrenheit = 120;
    for (int i = 1; i <= 10; i++, celsius--, fahrenheit -= 10)
        System.out.printf("%-14.1f%-14.1f  |  %-14.1f%-14.1f%n",
                          celsius, celsiusToFahrenheit(celsius), fahrenheit, fahrenheitToCelsius(fahrenheit));
  }

  public static double celsiusToFahrenheit(double celsius) {
      double fahrenheit = (9.0 / 5) * celsius + 32;
      return fahrenheit;
  }

  public static double fahrenheitToCelsius(double fahrenheit) {
      double Celsius = (5.0 / 9) * (fahrenheit - 32);
      return Celsius;
  }
}

