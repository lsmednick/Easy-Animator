
/**
 * This is an interface for each of the shape classes. Each shape contains an x / y coordinate, rgb
 * value, width, height, starting time, and end time. This interface contains getter methods for
 * each of these attributes.
 */

public interface IShape {

  /**
   * Method to return the x coordinate of a given shape.
   *
   * @return x coordinate of a shape.
   */

  double getX();

  /**
   * Method to return the y coordinate of a given shape.
   *
   * @return y coordinate of a shape.
   */

  double getY();

  /**
   * Method to return the red intensity of a shape's color.
   *
   * @return red intensity of a shape's color.
   */

  int getR();

  /**
   * Method to return the green intensity of a shape's color.
   *
   * @return green intensity of a shape's color.
   */

  int getG();

  /**
   * Method to return the blue intensity of a shape's color.
   *
   * @return blue intensity of a shape's color.
   */

  int getB();

  /**
   * Method to return the width of a given shape.
   *
   * @return width of a shape
   */

  double getWidth();

  /**
   * Method to return the height of a given shape.
   *
   * @return height of a shape
   */

  double getHeight();

  /**
   * Method to return the starting time of a given shape.
   *
   * @return starting time of a shape
   */

  int getStartTime();

  /**
   * Method to return the end time of a given shape.
   *
   * @return end time of a shape
   */

  int getEndTime();

  /**
   * Method to return the name of a given shape.
   *
   * @return name of a shape
   */
  String getName();

  /**
   * Setter for the x-coordinate and y-coordinate when the object is moved to a new position.
   *
   * @param toX the x-coordinate to move the object to
   * @param toY the y-coordinate to move the object to
   * @throws IllegalArgumentException if negative integers are given
   */

  void setCoordinates(double toX, double toY) throws IllegalArgumentException;

  /**
   * Setter for changing the color of an object.
   *
   * @param r is the value specifying the red component of Color
   * @param g is the value specifying the green component of Color
   * @param b is the value specifying the blue component of Color
   * @throws IllegalArgumentException if the value of r,g,b is greater than the max value 255
   */

  void setColor(int r, int g, int b) throws IllegalArgumentException;

  /**
   * Setter for changing the scale of of an object.
   *
   * @param scalingHeight scales the length by a given integer
   * @param scalingWidth  scales the width by a given integer
   * @throws IllegalArgumentException if negative integers are given
   */

  void setScaling(int scalingHeight, int scalingWidth) throws IllegalArgumentException;

}
