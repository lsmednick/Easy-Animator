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

  /**
   * Sets a new value for x
   *
   * @param x the new x value of a shape
   */

  void setX(int x);

  /**
   * Sets a new value for y
   *
   * @param y the new y value of a shape
   */

  void setY(int y);

  /**
   * Sets a new color for the shape
   *
   * @param r red intensity of the color's shape
   * @param g green intensity of the color's shape
   * @param b blue intensity of the color's shape
   */

  void setColor(int r, int g, int b);

  /**
   * Sets a new value for w
   *
   * @param w the new w value of a shape
   */

  void setW(int w);

  /**
   * Sets a new value for h
   *
   * @param h the new h value of a shape
   */

  void setH(int h);

  // TODO: add JavaDocs
  String shapeSVG();
  String shapeEndSVG();

  String xTagSVG();
  String yTagSVG();
  String widthTagSVG();
  String heightTagSVG();
}
