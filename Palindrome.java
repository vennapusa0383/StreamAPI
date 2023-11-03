import java.util.Scanner;
import java.util.stream.IntStream;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter String or Number to check palindrome");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        String temp=word.replaceAll("\\s","");
        Boolean b = IntStream.rangeClosed(0,temp.length()/2).noneMatch(i->temp.charAt(i)!= temp.charAt(temp.length()-i-1));
        if(b==true){
            System.out.println("palindrome");
        } else{
            System.out.println("mot palindrome");
        }
    }
}

Root@3306root
AIPL8872LT17961
