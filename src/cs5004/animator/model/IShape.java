package cs5004.animator.model;

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

  int getX();

  /**
   * Method to return the y coordinate of a given shape.
   *
   * @return y coordinate of a shape.
   */

  int getY();

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

  int getWidth();

  /**
   * Method to return the height of a given shape.
   *
   * @return height of a shape
   */

  int getHeight();


  /**
   * Method to return the name of a given shape.
   *
   * @return name of a shape
   */

  String getName();

  /**
   * Method to return the type of shape.
   *
   * @returns an enum describing the type of shape.
   */

  ShapeType getType();
}
