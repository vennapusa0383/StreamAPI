import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println("enter Numbers");
        Scanner input = new Scanner(System.in);
        int number= input.nextInt();
        List<Integer> l=Stream.iterate(1, i-> ++i)
                .filter(i -> i == Stream.of(String.valueOf(i).split(""))
                        .map(Integer::valueOf)
                        .map(n->(n*n*n))
                        .mapToInt(n->n)
                        .sum())
                .limit(number).collect(Collectors.toList());
        System.out.println("Armstrong Numbers::"+l);
    }
}
