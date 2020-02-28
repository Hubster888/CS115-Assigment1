/**
 * Arc.java
 * This class extends the ClosedShape class in order to create a new shape.
 * Created on: 28/02/2020
 * @author Hubert Rzeminski 
 * @version 1.0
 */
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Arc extends ClosedShape{
    private int height;
    private int width;
    
    /**
     * This is the constructor for a arc that should flash.
     * @param x horizontal starting coordinate 
     * @param y vertical starting coordinate
     * @param vy vertical starting velocity
     * @param xy horizontal starting velocity
     * @param isFilled true if the shape is filled with a colour
     * @param width The width of the arc
     * @param height The height of the arc
     * @param color primary colour of the arc
     * @param insertionTime the time the shape appears on screen
     * @param shouldFlash true if the shape should flash colours
     * @param color2 the colour that the shape flashes to
     */
    public Arc(int x, int y, int vx, int vy, Boolean isFilled, int width, int height, Color color, int insertionTime, boolean shouldFlash, Color color2){
        super (insertionTime, x, y, vx, vy, color, isFilled, shouldFlash, color2);
        this.width = width;
        this.height = height;
    }
    
    /**
     * This is the constructor for a arc that should not flash.
     * @param x horizontal starting coordinate 
     * @param y vertical starting coordinate
     * @param vy vertical starting velocity
     * @param xy horizontal starting velocity
     * @param isFilled true if the shape is filled with a colour
     * @param width The width of the arc
     * @param height The height of the arc
     * @param color primary colour of the arc
     * @param insertionTime the time the shape appears on screen
     * @param shouldFlash true if the shape should flash colours
     */
    public Arc(int x, int y, int vx, int vy, Boolean isFilled, int width, int height, Color color, int insertionTime){
        super (insertionTime, x, y, vx, vy, color, isFilled, false, Color.WHITE);
        this.width = width;
        this.height = height;
    }
    
    /**
     * Makes a string that represents the arc.
     * @return The string describes the arcs properties
     */
    public String toString () {
    	String result = "This is a Arc\n";
    	result += super.toString();
	result += "Its height is " + this.height + "\n";
        result += "Its width is " + this.width + "\n";
    	return result;
    }
    
    /**
     * @param  height resets the height
     */
    public void setHeight (int height) {
    	this.height = height;
    }
    
    /**
     * @param width resets the width
     */
    public void setWidth (int width) {
    	this.width = width;
    }
    
    /**
     * @return Width of the arc
     */
    public int getWidth() {
    	return this.width;
    }
    
    /**
     * @return Height of the arc
     */
    public int getHeight() {
    	return this.height;
    }
    
    /**
     * Draw the oval.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillArc( x, y, width, height, 45, 240, ArcType.ROUND );
    	} 
    	else {
    		g.strokeArc( x, y, width, height, 45, 240, ArcType.ROUND );
	    }
    }
}