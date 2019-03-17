package academy.elqoo.java8.stream;


import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream8 {

    public static List<Integer> returnSquareRoot(List<Integer> numbers){
    	return numbers.stream()
			.map(java.lang.Math::sqrt)
			.map(Double::intValue)
			.collect(Collectors.toList());
    }

    public static List<Integer> getAgeFromUsers(List<User> user){
    	return user.stream()
    		.map(User::getAge)
    		.collect(Collectors.toList());
    }

    public static List<Integer> getDistinctAges(List<User> users){
    	return users.stream()
			.map(User::getAge)
			.distinct()
			.collect(Collectors.toList());
    }

    public static List<User> getLimitedUserList(List<User> users, int limit){
    	return users.stream()
			.limit(2)
			.collect(Collectors.toList());
    }

    public static Integer countUsersOlderThen25(List<User> users){
    	return (int) users.stream()
    			.filter(us -> us.getAge() > 25)
    			.count();
    }

    public static List<String> mapToUpperCase(List<String> strings){
    	return strings.stream()
    		.map(String::toUpperCase)
    		.collect(Collectors.toList());
    }

    public static Integer sum(List<Integer> integers){
    	return integers.stream()
			//.reduce(0, Integer::sum);
			.reduce(0, (x,y) -> x+y);
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip){
        throw new RuntimeException();
    }

    public static List<String> getFirstNames(List<String> names){
        throw new RuntimeException();
    }

    public static List<String> getDistinctLetters(List<String> names){
        throw new RuntimeException();
    }


    public static String separateNamesByComma(List<User> users){
        throw new RuntimeException();
    }

    public static double getAverageAge(List<User> users){
        throw new RuntimeException();
    }

    public static Integer getMaxAge(List<User> users){
        throw new RuntimeException();
    }

    public static Integer getMinAge(List<User> users) {
        throw new RuntimeException();
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users){
        throw new RuntimeException();
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users){
        throw new RuntimeException();
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users){
        throw new RuntimeException();
    }

    public static Map<Boolean, Long> countGender(List<User> users){
        throw new RuntimeException();
    }

    public static boolean anyMatch(List<User> users, int age){
        throw new RuntimeException();
    }

    public static boolean noneMatch(List<User> users, int age){
        throw new RuntimeException();
    }

    public static Optional<User> findAny(List<User> users, String name){
        throw new RuntimeException();
    }

    public static List<User> sortByAge(List<User> users){
        throw new RuntimeException();
    }

    public static Stream<Integer> getBoxedStream(IntStream stream){
        throw new RuntimeException();
    }

    public static List<Integer> generateFirst10PrimeNumbers(){
        throw new RuntimeException();
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }

    public static List<Integer> generate10RandomNumbers(){
        throw new RuntimeException();
    }

    public static User findOldest(List<User> users){
        throw new RuntimeException();
    }

    public static int sumAge(List<User> users){
        throw new RuntimeException();
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users){
        throw new RuntimeException();
    }

}
