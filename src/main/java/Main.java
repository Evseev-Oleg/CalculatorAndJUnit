import java.util.EmptyStackException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine();
            System.out.println(new Calculator().decide(expression));
        }catch (NumberFormatException e) {
            System.out.println("Введены недопустимые символы");
        }catch (EmptyStackException | StringIndexOutOfBoundsException e) {
            System.out.println("Неправильно составлено выражение");
        }catch (IllegalArgumentException e){
            System.out.println("На ноль делить нельзя!");
        }
    }
}
