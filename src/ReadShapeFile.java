
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */


import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
                int i = 0;
                while(in.hasNextLine()){
                    String[] line = in.nextLine().split(" ");
                    String shape = line[0];
                    int startingX = Integer.parseInt(line[1]);
                    int startingY = Integer.parseInt(line[2]);
                    int velocityX = Integer.parseInt(line[3]);
                    int velocityY = Integer.parseInt(line[4]);
                    Boolean isFilled = Boolean.parseBoolean(line[5]);
                    if(shape.equals("circle")){
                            int diameter = Integer.parseInt(line[6]);
                            int red = Integer.parseInt(line[7]);
                            int green = Integer.parseInt(line[8]);
                            int blue = Integer.parseInt(line[9]);
                            int insertionTime = Integer.parseInt(line[10]);
                            boolean shouldFlash = Boolean.parseBoolean(line[11]);
                            Color color = Color.rgb(red, green, blue);
                            Color color2 = Color.WHITE;
                            if(shouldFlash){
                                int red2 = Integer.parseInt(line[12]);
                                int green2 = Integer.parseInt(line[13]);
                                int blue2 = Integer.parseInt(line[14]);
                                color2 = Color.rgb(red2, green2, blue2);
                                Circle circle = new Circle(insertionTime, startingX, startingY, velocityX, velocityY, diameter, color, isFilled, shouldFlash, color2);
                                shapeQueue.enqueue(circle);
                            i++;
                            }else{
                                Circle circle = new Circle(insertionTime, startingX, startingY, velocityX, velocityY, diameter, color, isFilled);
                            shapeQueue.enqueue(circle);
                            i++;
                            }
                            
                        }else if(shape.equals("oval") || shape.equals("rect") || shape.equals("arc")){
                            int width = Integer.parseInt(line[6]);
                            int height = Integer.parseInt(line[7]);
                            int red = Integer.parseInt(line[8]);
                            int green = Integer.parseInt(line[9]);
                            int blue = Integer.parseInt(line[10]);
                            int insertionTime = Integer.parseInt(line[11]);
                            boolean shouldFlash = Boolean.parseBoolean(line[12]);
                            Color color2 = Color.WHITE;
                            Color color = Color.rgb(red, green, blue);
                            if(shouldFlash){
                                int red2 = Integer.parseInt(line[13]);
                                int green2 = Integer.parseInt(line[14]);
                                int blue2 = Integer.parseInt(line[15]);
                                color2 = Color.rgb(red2, green2, blue2);
                                if(shape.equals("oval")){
                                Oval oval = new Oval(insertionTime, startingX, startingY, velocityX, velocityY, width, height, color, isFilled, shouldFlash, color2);
                                shapeQueue.enqueue(oval);
                                i++;
                                
                            }else if(shape.equals("rect")){
                                Rect rect = new Rect(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime, shouldFlash, color2);
                                shapeQueue.enqueue(rect);
                                i++;
                                
                            }else {
                                Arc arc = new Arc(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime, shouldFlash, color2);
                                shapeQueue.enqueue(arc);
                                i++;
                                
                            }
                            }else if(shape.equals("oval")){
                                Oval oval = new Oval(insertionTime, startingX, startingY, velocityX, velocityY, width, height, color, isFilled);
                                shapeQueue.enqueue(oval);
                                i++;
                            }else if(shape.equals("rect")){
                                Rect rect = new Rect(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime);
                                shapeQueue.enqueue(rect);
                                i++;
                            }else {
                                Arc arc = new Arc(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime);
                                shapeQueue.enqueue(arc);
                                i++;
                            }
                        }else if(shape.equals("square")){
                            int side = Integer.parseInt(line[6]);
                            int red = Integer.parseInt(line[7]);
                            int green = Integer.parseInt(line[8]);
                            int blue = Integer.parseInt(line[9]);
                            int insertionTime = Integer.parseInt(line[10]);
                            boolean shouldFlash = Boolean.parseBoolean(line[11]);
                            Color color2 = Color.WHITE;
                            Color color = Color.rgb(red, green, blue);
                            if(shouldFlash){
                                int red2 = Integer.parseInt(line[12]);
                                int green2 = Integer.parseInt(line[13]);
                                int blue2 = Integer.parseInt(line[14]);
                                color2 = Color.rgb(red2, green2, blue2);
                                Square square = new Square(startingX, startingY, velocityX, velocityY, isFilled, side, color, insertionTime, shouldFlash, color2);
                            shapeQueue.enqueue(square);
                            i++;
                            
                            }else{
                                Square square = new Square(startingX, startingY, velocityX, velocityY, isFilled, side, color, insertionTime);
                            shapeQueue.enqueue(square);
                            i++;
                            }
                            
                        }
                }
               
                shapeQueue.print();
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
	    // HINT: You might want to open a file here.
            File file = new File(filename);
            Scanner in = null;
            try{
                in = new Scanner(file);
            }catch(IOException exception){
                System.out.println("File not found");
            }
	    
	    return ReadShapeFile.readDataFile(in);
	    
	}
}
