/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author rzemi
 */
public class Rect extends ClosedShape{
    private int height;
    private int width;
    
    public Rect(int x, int y, int vx, int vy, Boolean isFilled, int width, int height, Color color, int insertionTime, Boolean shouldFlash, Color color2){
        super (insertionTime, x, y, vx, vy, color, isFilled, shouldFlash, color2);
        this.width = width;
        this.height = height;
    }
    
    public Rect(int x, int y, int vx, int vy, Boolean isFilled, int width, int height, Color color, int insertionTime){
        super (insertionTime, x, y, vx, vy, color, isFilled, false, Color.WHITE);
        this.width = width;
        this.height = height;
    }
    
    public String toString () {
    	String result = "This is a Rectangle\n";
    	result += super.toString();
	result += "Its height is " + this.height + "\n";
        result += "Its width is " + this.width + "\n";
        
    	return result;
    }
    
    public void setHeight (int height) {
    	this.height = height;
    }
    
    public void setWidth (int width) {
    	this.width = width;
    }
    
    public int getWidth() {
    	return this.width;
    }
    
    public int getHeight() {
    	return this.height;
    }
    
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
