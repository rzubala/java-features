package academy.elqoo.java8.defaultmethods;

public class Triangle extends AbstractShape{

    @Override
    public String getName() {
        return "Triangle";
    }
    
    @Override
    public void notImplementedMethod() {
    	throw new RuntimeException();
    }
}
