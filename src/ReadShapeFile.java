
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
                    switch(shape){
                        case "circle":
                            shapeQueue.enqueue(makeCircle(line));
                            break;
                        case "square":
                            shapeQueue.enqueue(makeSquare(line));
                            break;
                        case "oval":
                            shapeQueue.enqueue(makeOval(line));
                            break;
                        case "rect":
                            shapeQueue.enqueue(makeRect(line));
                            break;
                        case "arc":
                            shapeQueue.enqueue(makeArc(line));
                            break;
                        default:
                            System.out.println("Shape is not recognized");
                    }
                }
                shapeQueue.print();
		return shapeQueue;
	}
        
        /**
         * Make the Oval object
         * @param shapeDescription the line from the input file that describes this shape
         * @return A Oval object
         */
        private static ClosedShape makeOval(String[] shapeDescription){
            Oval oval = null;
            int startingX = Integer.parseInt(shapeDescription[1]);
            int startingY = Integer.parseInt(shapeDescription[2]);
            int velocityX = Integer.parseInt(shapeDescription[3]);
            int velocityY = Integer.parseInt(shapeDescription[4]);
            Boolean isFilled = Boolean.parseBoolean(shapeDescription[5]);
            int width = Integer.parseInt(shapeDescription[6]);
            int height = Integer.parseInt(shapeDescription[7]);
            int red = Integer.parseInt(shapeDescription[8]);
            int green = Integer.parseInt(shapeDescription[9]);
            int blue = Integer.parseInt(shapeDescription[10]);
            int insertionTime = Integer.parseInt(shapeDescription[11]);
            boolean shouldFlash = Boolean.parseBoolean(shapeDescription[12]);
            Color color2 = Color.WHITE;
            Color color = Color.rgb(red, green, blue);
            if(shouldFlash){
                int red2 = Integer.parseInt(shapeDescription[13]);
                int green2 = Integer.parseInt(shapeDescription[14]);
                int blue2 = Integer.parseInt(shapeDescription[15]);
                color2 = Color.rgb(red2, green2, blue2);
                oval = new Oval(insertionTime, startingX, startingY, velocityX, velocityY, width, height, color, isFilled, shouldFlash, color2);
            }else{
                oval = new Oval(insertionTime, startingX, startingY, velocityX, velocityY, width, height, color, isFilled);
            }
            return oval;
        }
        
        /**
         * Make the Rect object
         * @param shapeDescription the line from the input file that describes this shape
         * @return A Rect object
         */
        private static ClosedShape makeRect(String[] shapeDescription){
            Rect rect = null;
            int startingX = Integer.parseInt(shapeDescription[1]);
            int startingY = Integer.parseInt(shapeDescription[2]);
            int velocityX = Integer.parseInt(shapeDescription[3]);
            int velocityY = Integer.parseInt(shapeDescription[4]);
            Boolean isFilled = Boolean.parseBoolean(shapeDescription[5]);
            int width = Integer.parseInt(shapeDescription[6]);
            int height = Integer.parseInt(shapeDescription[7]);
            int red = Integer.parseInt(shapeDescription[8]);
            int green = Integer.parseInt(shapeDescription[9]);
            int blue = Integer.parseInt(shapeDescription[10]);
            int insertionTime = Integer.parseInt(shapeDescription[11]);
            boolean shouldFlash = Boolean.parseBoolean(shapeDescription[12]);
            Color color2 = Color.WHITE;
            Color color = Color.rgb(red, green, blue);
            if(shouldFlash){
                int red2 = Integer.parseInt(shapeDescription[13]);
                int green2 = Integer.parseInt(shapeDescription[14]);
                int blue2 = Integer.parseInt(shapeDescription[15]);
                color2 = Color.rgb(red2, green2, blue2);
                rect = new Rect(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime, shouldFlash, color2);
            }else{
                rect = new Rect(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime);
            }
            return rect;
        }
        
        /**
         * Make the Circle object
         * @param shapeDescription the line from the input file that describes this shape
         * @return A Circle object
         */
        private static ClosedShape makeCircle(String[] shapeDescription){
            Circle circle = null;
            int startingX = Integer.parseInt(shapeDescription[1]);
            int startingY = Integer.parseInt(shapeDescription[2]);
            int velocityX = Integer.parseInt(shapeDescription[3]);
            int velocityY = Integer.parseInt(shapeDescription[4]);
            Boolean isFilled = Boolean.parseBoolean(shapeDescription[5]);
            int diameter = Integer.parseInt(shapeDescription[6]);
            int red = Integer.parseInt(shapeDescription[7]);
            int green = Integer.parseInt(shapeDescription[8]);
            int blue = Integer.parseInt(shapeDescription[9]);
            int insertionTime = Integer.parseInt(shapeDescription[10]);
            boolean shouldFlash = Boolean.parseBoolean(shapeDescription[11]);
            Color color = Color.rgb(red, green, blue);
            Color color2 = Color.WHITE;
            if(shouldFlash){
                int red2 = Integer.parseInt(shapeDescription[12]);
                int green2 = Integer.parseInt(shapeDescription[13]);
                int blue2 = Integer.parseInt(shapeDescription[14]);
                color2 = Color.rgb(red2, green2, blue2);
                circle = new Circle(insertionTime, startingX, startingY, velocityX, velocityY, diameter, color, isFilled, shouldFlash, color2);
            }else{
                circle = new Circle(insertionTime, startingX, startingY, velocityX, velocityY, diameter, color, isFilled);
            }
            return circle;
        }
        
        /**
         * Make the Square object
         * @param shapeDescription the line from the input file that describes this shape
         * @return A Square object
         */
        private static ClosedShape makeSquare(String[] shapeDescription){
            Square square = null;
            int startingX = Integer.parseInt(shapeDescription[1]);
            int startingY = Integer.parseInt(shapeDescription[2]);
            int velocityX = Integer.parseInt(shapeDescription[3]);
            int velocityY = Integer.parseInt(shapeDescription[4]);
            Boolean isFilled = Boolean.parseBoolean(shapeDescription[5]);
            int side = Integer.parseInt(shapeDescription[6]);
            int red = Integer.parseInt(shapeDescription[7]);
            int green = Integer.parseInt(shapeDescription[8]);
            int blue = Integer.parseInt(shapeDescription[9]);
            int insertionTime = Integer.parseInt(shapeDescription[10]);
            boolean shouldFlash = Boolean.parseBoolean(shapeDescription[11]);
            Color color2 = Color.WHITE;
            Color color = Color.rgb(red, green, blue);
            if(shouldFlash){
                int red2 = Integer.parseInt(shapeDescription[12]);
                int green2 = Integer.parseInt(shapeDescription[13]);
                int blue2 = Integer.parseInt(shapeDescription[14]);
                color2 = Color.rgb(red2, green2, blue2);
                square = new Square(startingX, startingY, velocityX, velocityY, isFilled, side, color, insertionTime, shouldFlash, color2);
            }else{
                square = new Square(startingX, startingY, velocityX, velocityY, isFilled, side, color, insertionTime);
            }
            return square;
        }
        
        /**
         * Make the Arc object
         * @param shapeDescription the line from the input file that describes this shape
         * @return A Arc object
         */
        private static ClosedShape makeArc(String[] shapeDescription){
            Arc arc = null;
            int startingX = Integer.parseInt(shapeDescription[1]);
            int startingY = Integer.parseInt(shapeDescription[2]);
            int velocityX = Integer.parseInt(shapeDescription[3]);
            int velocityY = Integer.parseInt(shapeDescription[4]);
            Boolean isFilled = Boolean.parseBoolean(shapeDescription[5]);
            int width = Integer.parseInt(shapeDescription[6]);
            int height = Integer.parseInt(shapeDescription[7]);
            int red = Integer.parseInt(shapeDescription[8]);
            int green = Integer.parseInt(shapeDescription[9]);
            int blue = Integer.parseInt(shapeDescription[10]);
            int insertionTime = Integer.parseInt(shapeDescription[11]);
            boolean shouldFlash = Boolean.parseBoolean(shapeDescription[12]);
            Color color2 = Color.WHITE;
            Color color = Color.rgb(red, green, blue);
            if(shouldFlash){
                int red2 = Integer.parseInt(shapeDescription[13]);
                int green2 = Integer.parseInt(shapeDescription[14]);
                int blue2 = Integer.parseInt(shapeDescription[15]);
                color2 = Color.rgb(red2, green2, blue2);
                arc = new Arc(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime, shouldFlash, color2);
            }else{
                arc = new Arc(startingX, startingY, velocityX, velocityY, isFilled, width, height, color, insertionTime);
            }
            return arc;
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
