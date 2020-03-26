// Loge and Jenny love to code!

import java.awt.*;

/**
 * Interface for the Easy Animator Application. This supports an abstract class that will define 2D
 * shapes that are used for animation.
 */

public interface AnimatorModel {

  /**
   * Method to add shape to the current animation.
   *
   * @param name      name of the shape
   * @param shapeType type of the shape (rectangle, oval, triangle)
   * @param x         x coordinate of the shape
   * @param y         y coordinate of the shape
   * @param r         red intensity of the shape's color
   * @param g         green intensity of the shape's color
   * @param b         blue intensity of the shape's color
   * @param width     width of the shape
   * @param height    height of the shape
   * @param startTime starting time of the shape
   * @param endTime   end time of the shape
   */

  void addShape(String name, ShapeType shapeType, double x, double y, int r, int g, int b
          , double width, double height, int startTime, int endTime)
          throws IllegalArgumentException;

  /**
   * Method to move shape.
   *
   * @param shape         the IShape object that should be moved
   * @param toX           the X coordinate we're moving the shape To
   * @param toY           the Y coordinate we're moving the shape To
   * @param moveStartTime the time (int) that the object should start moving
   * @param moveEndTime   the time (int) that the object should end movement
   * @throws IllegalArgumentException throws if the parameters are outside of the spec
   */

  void move(IShape shape, double toX, double toY, int moveStartTime, int moveEndTime)
          throws IllegalArgumentException;

  /**
   * Create a object that stores that values for RBG which will change the color of our Shape.
   *
   * @param shape the IShape object that should be moved
   * @param r     is the value specifying the red component of Color
   * @param g     is the value specifying the green component of Color
   * @param b     is the value specifying the blue component of Color
   * @throws IllegalArgumentException throws if the value of r,g,b is greater than the max value
   *                                  255
   */
  void changeColor(IShape shape, int r, int g, int b) throws IllegalArgumentException;

  /**
   * Change the shape of our current Shape.
   *
   * @param myShape is the new shape we're changing the current Shape to
   */
  void changeShape(Shape myShape);

  /**
   * This method will scale the current shape.
   *
   * @param shape         the IShape object that should be moved
   * @param scalingLength scales the length by a given integer
   * @param scalingWidth  scales the width by a given integer
   */
  void scaling(IShape shape, int scalingLength, int scalingWidth);

  /**
   * This method will change the different layers of the animation.
   */

  void changeLayer(int layer);
  //TODO -- think about using a linked list for the layers -- so that if a layer needs to be
  // inserted between other layers the number assignment for each layer will change
  // -- get pushed down

  //TODO -- consider when shapes should appear and disappear


}