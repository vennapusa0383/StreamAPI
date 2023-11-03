import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciNumbers {
    public static void main(String[] args) {
        System.out.println("enter number");
        Scanner input = new Scanner(System.in);
        int number= input.nextInt();
        List<Integer> fibonacciNumbers = Stream.iterate(new int[]{0,1}, t-> new int[]{t[1],t[0]+t[1]})
                .limit(number)
                .map(t->t[0])
                .collect(Collectors.toList());
        System.out.println("numbers :: "+fibonacciNumbers);

        int sum=Stream.iterate(new int[]{0,1}, t->new int[]{t[1], t[0]+t[1]})
                .limit(number)
                .mapToInt(t->t[0])
                .sum();
        System.out.println("sum ::"+sum);


        



    }
}
