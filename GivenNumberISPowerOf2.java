import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GivenNumberISPowerOf2 {
    public static void main(String[] args) {
        System.out.println("enter a number");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        List<Integer> powerOf2Numbers = IntStream.rangeClosed(1, num).filter(GivenNumberISPowerOf2::isPowerOf2).boxed().collect(Collectors.toList());
        System.out.println("powerOf2Numbers ::"+powerOf2Numbers);

        System.out.println(isPowerOf2(num)?"yes":"no");

    }

    public static boolean isPowerOf2(int number){
        return number!=0 && ((number & (number-1))==0);
    }

    
}
