/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Rect is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Rectangles bounding rectangle.
 * @author Hubert Rzeminski
 */

public class Rect extends ClosedShape{
    private int height;
    private int width;
    
    /**
     * Creates a Rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color The line colour or fill colour.
     * @param isFilled True if the Rectangle is filled with colour, false if opaque.
     * @param shouldFlash True if the shape is supposed to flash
     * @param color2 The colour that the shape flashes between.
     */
    public Rect(int x, int y, int vx, int vy, Boolean isFilled, int width, int height, Color color, int insertionTime, Boolean shouldFlash, Color color2){
        super (insertionTime, x, y, vx, vy, color, isFilled, shouldFlash, color2);
        this.width = width;
        this.height = height;
    }
    
    /**
     * Creates a Rectangle that can not flash.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     * @param color The line colour or fill colour.
     * @param isFilled True if the circle is filled with colour, false if opaque.
     */
    public Rect(int x, int y, int vx, int vy, Boolean isFilled, int width, int height, Color color, int insertionTime){
        super (insertionTime, x, y, vx, vy, color, isFilled, false, Color.WHITE);
        this.width = width;
        this.height = height;
    }
    
    /**
     * Method to convert a circle to a string.
     */
    public String toString () {
    	String result = "This is a Rectangle\n";
    	result += super.toString();
	result += "Its height is " + this.height + "\n";
        result += "Its width is " + this.width + "\n";
    	return result;
    }
    
    /**
     * resets the height
     * @param height the height of the rectangle
     */
    public void setHeight (int height) {
    	this.height = height;
    }
    
    /**
     * resets the width
     * @param width the width of the rectangle.
     */
    public void setWidth (int width) {
    	this.width = width;
    }
    
    /**
     * @return width of the rectangle
     */
    public int getWidth() {
    	return this.width;
    }
    
    /**
     * @return height of the rectangle
     */
    public int getHeight() {
    	return this.height;
    }
    
    /**
     * Draw the rectangle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw (GraphicsContext g) {
    	g.setFill( colour );
    	g.setStroke( colour );
    	if (isFilled) {
    		g.fillRect( x, y, width, height );
    	} 
    	else {
    		g.strokeRect( x, y, width, height );
	    }
    }
}
