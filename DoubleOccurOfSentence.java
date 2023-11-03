import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DoubleOccurOfSentence {
    public static void main(String[] args) {
        String[] s = {"apple", "ball", "cat", "dog", "apple", "cat"};

        Map<String, Long> collect = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("collect ::"+collect);

        List<String> doubleOccurWord = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("doubleOccurWord ::"+doubleOccurWord);

        List<String> uniqueWord = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(X -> X.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("uniqueWord ::"+uniqueWord);


        String firstRepetitiveWord = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .findFirst().get().getKey();
        System.out.println("firstRepetitiveWord ::"+firstRepetitiveWord);

        String firstNonRepetitiveWord = Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("firstNonRepetitiveWord ::"+firstNonRepetitiveWord);

        String longestLengthString = Arrays.stream(s).reduce((w1,w2)->w1.length()>w2.length()?w1:w2).get();
        System.out.println("longest length of string ::"+longestLengthString);

        List<String> s2=Arrays.stream(s).collect(Collectors.toList());
        Comparator<String> c10=
                (s9,s10)->{
               int l1 = s9.length();
               int l2=s10.length();
               if(l1<l2){
                   return  -1;
               } else if (l2>l1) {
                   return 1;
               } else {
                   return s9.compareTo(s10);
                    }
                };
        List<String> collect1 = s2.stream().sorted(c10).collect(Collectors.toList());
        System.out.println("collect1 ::"+collect1);


        List<String> map1= Arrays.stream(s).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        String[] array = map1.toArray(String[]::new);
        System.out.println("second repetitive word ::"+array[array.length-1]);

    }
}
