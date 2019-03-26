package academy.elqoo.java8.stream;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Collects Characters from a string to a String
 */
public class CharacterToStringCollector implements Collector<Character, StringBuilder, String> {
    @Override
    public Supplier<StringBuilder> supplier() {
        return () -> new StringBuilder(); //StringSupplier - container for result
    }

    @Override
    public BiConsumer<StringBuilder, Character> accumulator() {
        return (builder, character) -> builder.append(character);	//StringAccumulator - accumulate to container consecutive values
    }

    @Override
    public BinaryOperator<StringBuilder> combiner() {
        return (b1, b2) -> new StringBuilder().append(b1).append(b2);	//StringBinaryOperator - combines two containers    
    }

    @Override
    public Function<StringBuilder, String> finisher() {
        return b -> b.toString();	//StringFinisher - produces a results from builder
    }

    @Override
    public Set<Characteristics> characteristics() {
        //https://marcin-chwedczuk.github.io/java-8-how-to-write-custom-collector
    	return new HashSet<>();
    }
    
    public class StringSupplier implements Supplier<StringBuilder> {
		@Override
		public StringBuilder get() {
			return new StringBuilder();
		}
    }
    
    public class StringAccumulator implements BiConsumer<StringBuilder, Character> {
		@Override
		public void accept(StringBuilder builder, Character character) {
			builder.append(character);
		}    	
    }
    
    public class StringBinaryOperator implements BinaryOperator<StringBuilder> {
		@Override
		public StringBuilder apply(StringBuilder b1, StringBuilder b2) {
			return new StringBuilder().append(b1).append(b2);
		}
    }
    
    public class StringFinisher implements Function<StringBuilder, String> {
		@Override
		public String apply(StringBuilder builder) {
			return builder.toString();
		}    	
    }
}
