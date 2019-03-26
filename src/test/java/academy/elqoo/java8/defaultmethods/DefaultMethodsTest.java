package academy.elqoo.java8.defaultmethods;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class DefaultMethodsTest {

    @Test
    public void shouldMoveShape(){
        Shape shape = new Rectangle();
        // implement a default move method without changing the Rectangle class
        // shape.move(10,10);
        
        shape.move(10, 10);
        assertThat(10, equalTo(shape.getXPos()));
        assertThat(10, equalTo(shape.getYPos()));
    }

    @Test
    public void shouldMoveXposWith10(){
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        List<AbstractShape> shapes = asList(rectangle, triangle);
        // write a static method on shape that add 10 to each xPos of a shape
        // Shape.moveXPosWith10(shapes);
        
        Shape.moveXPosWith10(shapes);
        assertThat(10, equalTo(rectangle.getXPos()));
        assertThat(10, equalTo(triangle.getXPos()));

    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowNotImplementedException(){
        // add an optional method to the shape method
        Triangle triangle = new Triangle();
        // triangle.notImplementedMethod();

        triangle.notImplementedMethod();
    }

    @Test
    public void shouldReturnNameForTriangle(){
        Shape shape = new Triangle();
        //assertThat("fill in right name here",equalTo(shape.getName()));
        
        assertThat("Triangle", equalTo(shape.getName()));
    }

    @Test
    public void shouldReturnNameForRectangle(){
        Shape shape = new Rectangle();
        //assertThat("fill in right name here", equalTo(shape.getName()));

        assertThat("Abstract Shape", equalTo(shape.getName()));
    }

    @Test
    public void shouldProvideName(){
        // make rectangle implement NamedObject
        //NamedObject namedObject = null; // = new Rectangle()

        NamedObject namedObject = new Rectangle();
        assertThat("Abstract Shape", equalTo(namedObject.getName()));
    }


}
