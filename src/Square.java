


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author rzemi
 */
public class Square extends ClosedShape{
    private int side;
    
    public Square(int x, int y, int vx, int vy, Boolean isFilled, int side, Color color, int insertionTime, boolean shouldFlash, Color color2){
        super (insertionTime, x, y, vx, vy, color, isFilled, shouldFlash, color2);
        this.side = side;
    }
    
    public Square(int x, int y, int vx, int vy, Boolean isFilled, int side, Color color, int insertionTime){
        super (insertionTime, x, y, vx, vy, color, isFilled, false, Color.WHITE);
        this.side = side;
    }
    
    public String toString () {
    	String result = "This is a square\n";
    	result += super.toString();
	result += "Its side is " + this.side + "\n";
        
    	return result;
    }
    
     public int getWidth() {
    	return this.side;
    }
    
    public int getHeight() {
    	return this.side;
    }
    
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
