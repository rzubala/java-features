package academy.elqoo.java8.defaultmethods;

import java.util.List;

public interface Shape {

    int getXPos();

    int getYPos();

    void setXPos(int xPOs);

    void setYPos(int yPos);

    default String getName(){
        return "";
    }

    //RZA
	default void move(int x, int y) {
		setXPos(x);
		setYPos(y);
	}
	
	//RZA
	static void moveXPosWith10(List<AbstractShape> shapes) {
		shapes.stream().forEach(s -> s.setXPos(10 + s.getXPos()));
	}
	
	//RZA optional method
	default void notImplementedMethod() {		
	}
}
