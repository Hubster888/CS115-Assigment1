                    


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Square's bounding rectangle.
 */

public class Square extends ClosedShape{
    private int side;
    
    /**
     * Creates a Square.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The diameter of the circle.
     * @param color The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param shouldFlash True if the shape is supposed to flash
     * @param color2 The colour that the shape flashes between.
     * @param insertionTime the time the shape is added to the view
     */
    public Square(int x, int y, int vx, int vy, Boolean isFilled, int side, Color color, int insertionTime, boolean shouldFlash, Color color2){
        super (insertionTime, x, y, vx, vy, color, isFilled, shouldFlash, color2);
        this.side = side;
    }
    
    /**
     * Creates a Square that cant flash.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The diameter of the circle.
     * @param color The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     * @param insertionTime the time the shape is added to the view
     */
    public Square(int x, int y, int vx, int vy, Boolean isFilled, int side, Color color, int insertionTime){
        super (insertionTime, x, y, vx, vy, color, isFilled, false, Color.WHITE);
        this.side = side;
    }
    
    /**
     * Method to convert a square to a string.
     */
    public String toString () {
    	String result = "This is a square\n";
    	result += super.toString();
	result += "Its side is " + this.side + "\n";
    	return result;
    }
    
    /**
     * @return The width of the Square
     */
    public int getWidth() {
    	return this.side;
    }
    
    /**
     * @return The height of the square
     */
    public int getHeight() {
    	return this.side;
    }
    
    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( x, y, side, side );
    	} 
    	else {
    		g.strokeRect( x, y, side, side );
	    }
    }
}
