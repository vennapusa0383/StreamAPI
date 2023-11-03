import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DoubleOccurrenceOfChar {

    public static void main(String[] args) {
        String s="Basaveshwar";
        String rev = "";
        Map<String, Long> collect = Arrays.stream(s.trim().split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("double occurrence of character "+collect);

        char[] charArray = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(Character c :charArray){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }
        System.out.println("map ::"+map);

        for(int i=s.length()-1;i>=0;i--){
            rev = rev +s.charAt(i);
        }

        System.out.println("reverse of string ::"+rev);

        IntStream.range(0, s.length())
                .map(i -> s.length() - 1 - i)
                .mapToObj(i -> s.charAt(i))
                        .forEach(System.out::print);


    }
}
