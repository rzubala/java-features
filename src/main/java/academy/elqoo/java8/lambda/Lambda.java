package academy.elqoo.java8.lambda;


import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lambda {

    public static List<String> filter(List<String> strings, Predicate<String> condition){
        return strings.stream().filter(condition).collect(Collectors.toList());
    }

    public static void processWithinTransaction(Runnable runnable){
        Transaction transaction = new Transaction();
        transaction.start();
        runnable.run();
        transaction.stop();
    }

    @FunctionalInterface
    public interface StringCreatorFunction {     
        String create();
    }    

    public static String create(StringCreatorFunction function){
        return function.create();
    }
    
	public static int getStringLength(String myString, Function<String, Integer> function) {
		return function.apply(myString);
	}

    public static int multiply(int a, int b, BiFunction<Integer, Integer, Integer> function){
        return function.apply(a, b);
    }

    public static List<String> sortStrings(List<String> strings, Comparator<? super String> comparator){
         strings.sort(comparator);
         return strings;
    }
}
