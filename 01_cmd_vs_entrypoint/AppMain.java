import java.util.Arrays;

public class AppMain {
  public static void main(String[] args) {
    System.out.print("Du hast die Aufgabe ");
    Arrays.stream(args).forEach(System.out::println);
  }
}