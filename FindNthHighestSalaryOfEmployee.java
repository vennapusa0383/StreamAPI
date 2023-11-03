import java.util.*;
import java.util.stream.Collectors;

public class FindNthHighestSalaryOfEmployee {
    public static void main(String[] args) {
        System.out.println("enter a number");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        Map<String,Integer> map = new HashMap<>();

        map.put("apple",1000);
        map.put("ball",2000);
        map.put("cat",6000);
        map.put("dog",7000);
        map.put("elephant",6000);
        map.put("fish",7000);
        map.put("goal",8000);
        System.out.println(getNthHighestSalary(map,number));

    }

    public static Map.Entry<Integer, List<String>> getNthHighestSalary(Map<String,Integer> map,int number){
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                         Collectors.mapping(Map.Entry::getKey,Collectors.toList())
                ))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList())
                .get(number-1);
    }
}
