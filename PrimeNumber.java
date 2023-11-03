import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println("enter number");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        List<Integer> primeNumbers = IntStream.rangeClosed(2,number).filter(PrimeNumber::isPrime).boxed().collect(Collectors.toList());
        System.out.println("prime numbers ::"+primeNumbers);
        System.out.println(isPrime(number)?"yes":"no");
    }


    public static boolean isPrime(int number){
        return IntStream.rangeClosed(2,number/2).noneMatch(i->number%i==0);
    }
}
