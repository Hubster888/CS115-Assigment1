
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Dr D. Archambault, Modified  for JAVAFX by Dr J. L. Jones
 * 
 */
public class BouncingShapesWindow {
	
	private static final int ANIMATION_DELAY = 10;
	private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";
	
	private GraphicsContext gc;
	private Queue<ClosedShape> shapesToAdd;
	private ArrayList<ClosedShape> activeShapes;
	private int currentTime = 0;
	private boolean flag=true;
	
	private String filename;
	
	
	public BouncingShapesWindow(GraphicsContext gc,String filename) {
		this.gc=gc;
		
		activeShapes=new ArrayList<ClosedShape>();
		this.initShapes(filename);
		this.insertShapes ();
		drawClosedShapes();
		actionPerformed();
                
	}
	
	private void drawClosedShapes () {
		for (ClosedShape s : activeShapes)
		{
			s.draw(gc);
		}
	}
	
	private void initShapes (String filename) {
		shapesToAdd = ReadShapeFile.readDataFile(filename);
	}
	
	private void insertShapes() {
		//no more shapes to add, we are done
		if (shapesToAdd.isEmpty ()) {
			return;
		}
		
		//add shapes if needed
		ClosedShape current = shapesToAdd.peek ();
		while (!shapesToAdd.isEmpty () && (current.getInsertionTime() <= currentTime*ANIMATION_DELAY)) {
                   
                        activeShapes.add(current);
			shapesToAdd.dequeue();
                    
			
			if (!shapesToAdd.isEmpty ()) {
				current = shapesToAdd.peek();
			}
		}
	}
	
	public void actionPerformed()
	{
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5),ae -> { onTime();}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void onTime() {
		currentTime++;
                if(currentTime % 400 == 0){
                   flashShapes();
                }
		double h =gc.getCanvas().getHeight();
		double w = gc.getCanvas().getWidth();
		gc.clearRect(0, 0, w, h);
                
		moveShapes();
		insertShapes ();
		drawClosedShapes();
	}
	
	public void moveShapes()
	{
		double  dimsY = gc.getCanvas().getHeight() ;
		double  dimsX = gc.getCanvas().getWidth() ;
		for (ClosedShape s : activeShapes)
		{
			s.move();
			
			// Move us back in and bounce if we went outside the drawing area.
			if (s.outOfBoundsX(dimsX))
			{
				s.putInBoundsX(dimsX);
				s.bounceX();
			}
			
			if (s.outOfBoundsY(dimsY))
			{
				s.putInBoundsY(dimsY);
				s.bounceY();
			}
			
		}
	}
        
        public void flashShapes() {
            for(ClosedShape s : activeShapes){
                if(s.getShouldFlash()){
                    s.flash();
                }
                
            }
        }
	 
}

