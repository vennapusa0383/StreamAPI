import java.util.Scanner;
import java.util.stream.LongStream;

public class FactorialNumber {

    public static void main(String[] args) {
        System.out.println("enter number");
        Scanner input = new Scanner(System.in);
        int number=input.nextInt();
        Long l = LongStream.rangeClosed(1,number).reduce(1,(a,b)->a*b);
        System.out.println("factorial Number for "+number+" : "+l);
    }
}
