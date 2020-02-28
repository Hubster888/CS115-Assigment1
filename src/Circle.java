


/**
 * Circle.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Circle is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the circle's bounding rectangle.
 */

public class Circle extends ClosedShape {
    //The diameter of the circle
	private int diameter;
	

    /**
     * Creates a circle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param shouldFlash True if the shape is supposed to flash
     * @param color2 The colour that the shape flashes between.
     * @param insertionTime the time the shape is added to the view.
     */
    public Circle (int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled, boolean shouldFlash, Color color2) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled, shouldFlash, color2);
    	this.diameter = diameter;
    }
    
    /**
     * Creates a circle that does not flash.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param diameter The diameter of the circle.
     * @param colour The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     */
    public Circle (int insertionTime, int x, int y, int vx, int vy, int diameter, Color colour, boolean isFilled) {
    	super (insertionTime, x, y, vx, vy, colour, isFilled, false, Color.WHITE);
    	this.diameter = diameter;
    }
    
    /**
     * Method to convert a circle to a string.
     */
    public String toString () {
    	String result = "This is a circle\n";
    	result += super.toString ();
	result += "Its diameter is " + this.diameter + "\n";
    	return result;
    }
    
    /**
     * resets the diameter.
     * @param diameter the diameter of the circle.
     */
    public void setDiameter (int diameter) {
    	this.diameter = diameter;
    }
    
    /**
     * @return The diameter of the circle.
     */
    public int getDiameter() {
    	return diameter;
    }

    /**
     * @return The width of the circle
     */
 	public int getWidth() {
		return diameter;
	}

 	/**
 	 * @return The height of the circle
 	 */
 	public int getHeight() {
		return diameter;
	}
    
    /**
     * Draw the circle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillOval( x, y, diameter, diameter );
    	} 
    	else {
    		g.strokeOval( x, y, diameter, diameter );
	    }
    }
}
