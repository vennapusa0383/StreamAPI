import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Print10RandomNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new Random().ints(10,0,100)
                .boxed().collect(Collectors.toList());
        System.out.println("Random 10 numbers are ::"+numbers);



    }
}
