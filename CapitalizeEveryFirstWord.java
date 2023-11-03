import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CapitalizeEveryFirstWord {
    public static void main(String[] args) {
        System.out.println("enter a sentence");
        Scanner input = new Scanner(System.in);
        String sentence = input.nextLine();

        String s1 = Arrays.stream(sentence.trim().split("\\s"))
                .filter(w->w.length()>0)
                .map(w->w.substring(0,1).toUpperCase()+w.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
        System.out.println("Capital every 1st word of the sentence::"+s1); //This Is My Name

        //count occurrence of each word in sentence
        LinkedHashMap<String, Long> collect =Arrays.stream(sentence.trim().split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println("Double Occur word ::"+collect);

        //find all duplicate elements in sentence
        List<String> duplicateElements =Arrays.stream(sentence.trim().split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("duplicateElements ::"+duplicateElements);

        //find all unique elements in sentence
        List<String> uniqueElements=Arrays.stream(sentence.trim().split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("uniqueElements ::"+uniqueElements);

        //find first non repeat elements in sentence
        String firstNonRepeatElement = Arrays.stream(sentence.trim().split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("1 st non repeat element ::"+firstNonRepeatElement);

        //find first repeat element in sentence
        String firstRepeatElement=Arrays.stream(sentence.trim().split("\\s"))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()>1)
                .findFirst().get().getKey();
        System.out.println("firstRepeatElement ::"+firstRepeatElement);

        int[] numbers = {5,9,11,2,8,21,1};
        List<Integer> sortedNumber=Arrays.stream(numbers).sorted().distinct().boxed().collect(Collectors.toList());
        System.out.println("ascOrder or sortedOrder ::"+sortedNumber);

        List<Integer> reverse=Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        System.out.println("descOrder or reverseOrder ::"+sortedNumber);

        //find 2nd  lowest number in array
        Integer secondLowestNumber=Arrays.stream(numbers).sorted().boxed().skip(1).findFirst().get();
        System.out.println("secondLowestNumber ::"+secondLowestNumber);

        //find 2nd  highest number in array
        Integer secondHighestNumber=Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("secondHighestNumber ::"+secondHighestNumber);

        List<Integer> removeDuplicate=Arrays.stream(numbers).boxed().distinct().collect(Collectors.toList());
        System.out.println("After removing duplicate integers ::" + removeDuplicate);

        //find elements whose start with 2
        List<String> startWith=Arrays.stream(numbers).boxed().map(x->x+"").filter(s->s.startsWith("2")).collect(Collectors.toList());
        System.out.println("start with 2 "+startWith);

        //SKIP AND LIMIT EXAMPLE
        IntStream.range(1,10).skip(1).limit(8).forEach(System.out::print);

        String reversed=Arrays.stream(sentence.trim().split("\\s"))
                .map(i-> new StringBuilder(i).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("string ::"+reversed); //this is my name--->siht si ym eman
                                                  //basaveshwar-->rawhsevasab
        //without using reverse method
        IntStream.range(0,sentence.length())
                .map(i->sentence.length()-1-i)
                .mapToObj(i->sentence.charAt(i))
                .forEach(System.out::print);//this is my name  -->eman ym si siht
                                            //basaveshwar-->rawhsevasab

        /*IntStream.rangeClosed(0,sentence.length()-1)
                .map(i-> sentence.length()-1-i)
                .mapToObj(i->sentence.charAt(i))
                .forEach(System.out::print);*/




    }
}
