import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingOfNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(25);
        al.add(1);
        al.add(6);
        al.add(100);
        al.add(8);
        al.add(12);
        al.add(5);
        al.add(72);

        List<Integer> ascList = al.stream().sorted().collect(Collectors.toList());
        System.out.println("ascList ::"+ascList);

        List<Integer> descList = al.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("descList ::"+descList);

        List<Integer> collect = al.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("collect ::"+collect);


    }
}
