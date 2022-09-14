import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 1920, 1080);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10000; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(20);
            int blue = random.nextInt(20);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    public void colorScribbleAuto()
    {
        for (int turn=0; turn<1000000000; turn++) {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10000; i++) {
            // pick a random color
            if ( i % 7 == 0 && i < 256) {
            /*int red = random.nextInt(0);
            int green = random.nextInt(0);
            int blue = random.nextInt(0);*/
            pen.setColor(new Color(i, 0, 0));
            
            pen.randomSquiggle();
            }
            else if ( i % 5 == 0 && i < 256) {
            /*int red = random.nextInt(0);
            int green = random.nextInt(0);
            int blue = random.nextInt(0);*/
            pen.setColor(new Color(0, 0, 0));
            
            pen.randomSquiggle();
            }
            else {
            pen.setColor(new Color(0, 0, 0));
            
            pen.randomSquiggle();
             
         }
        }
    }
    }
    
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
