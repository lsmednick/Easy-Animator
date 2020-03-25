// Loge and Jenny love to code!

import java.awt.*;

/**
 * TODO -- Interface for the Easy Animator Application.
 * This supports an abstract class that that will define 2D shapes that are used for animation.
 *
 */
public interface AnimatorModel {

  /**
   * Method to move shape.
   * @param shape the IShape object that should be moved
   * @param toX the X coordinate we're moving the shape To
   * @param toY the Y coordinate we're moving the shape To
   * @param moveStartTime the time (int) that the object should start moving
   * @param moveEndTime the time (int) that the object should end movement
   * @IllegalArgumentException throws if the parameters are outside of the spec
   */
   void move(IShape shape, double toX, double toY, int moveStartTime, int moveEndTime) throws IllegalArgumentException;

   //TODO -- define the size of our 'display

  /**
   * Create a object that stores that values for RBG which will change the color of our Shape.
   * @param shape the IShape object that should be moved
   * @param r is the value specifying the red component of Color
   * @param g is the value specifying the green component of Color
   * @param b is the value specifying the blue component of Color
   * @throws IllegalArgumentException throws if the value of r,g,b is greater than the max value 255
   */
  void changeColor(IShape shape, int r, int g, int b) throws IllegalArgumentException;

  /**
   * Change the shape of our current Shape.
   * @param myShape is the new shape we're changing the current Shape to
   */
  void changeShape (Shape myShape);

  /**
   * This method will scale the current shape.
   * @param shape the IShape object that should be moved
   * @param scalingLength scales the length by a given integer
   * @param scalingWidth scales the width by a given integer
   */
  void scaling (IShape shape, int scalingLength, int scalingWidth);


  /**
   * This method will change the different layers of the animation.
   */
  void changeLayer (int layer);
  //TODO -- think about using a linked list for the layers -- so that if a layer needs to be
  // inserted between other layers the number assignment for each layer will change
  // -- get pushed down

  //TODO -- consider when shapes should appear and disappear








}