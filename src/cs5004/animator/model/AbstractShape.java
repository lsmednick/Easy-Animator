package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents an abstract shape. It implements the IShape interface which includes
 * various getter functions for the many attributes of an individual shape. This class is able to
 * construct a new shape object with these parameters as well as return the value of a given
 * element.
 */

public abstract class AbstractShape implements IShape {
  private int x;
  private int y;
  private Color color;
  private int width;
  private int height;
  private String name;
  private ShapeType type;

  /**
   * This method constructs an abstract shape object. Each shape contains an x / y coordinate, rgb
   * value, width, height, start time, and end time. While rgb values are supplied as integers, the
   * constructor creates a Color object using this data in order to represent the given color.
   *
   * @param x      x coordinate of the shape
   * @param y      y coordinate of the shape
   * @param r      red intensity of the shape's color
   * @param g      green intensity of the shape's color
   * @param b      blue intensity of the shape's color
   * @param width  width of the shape
   * @param height height of the shape
   * @param name   name of the shape
   * @throws IllegalArgumentException if width or height is below 0
   * @throws IllegalArgumentException if rgb values are not between 0-255 inclusive
   * @throws IllegalArgumentException if the x or y-coordinates are negative (we're assuming the
   *                                  display will only work within the first quadrant, i.e. only
   *                                  positive x and y values -- this may be modified upon further
   *                                  instruction)
   * @throws IllegalArgumentException if the String name is null
   */

  public AbstractShape(int x, int y, int r, int g, int b, int width, int height,
                       String name) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("Width and height must be at greater than zero.");
    }
    if (name == null) {
      throw new IllegalArgumentException("The String containing the name of the object can"
              + "not be null");
    }
    this.x = x;
    this.y = y;
    this.color = new Color(r, g, b);
    this.width = width;
    this.height = height;
    this.name = name;
  }

  /**
   * Method to return the x coordinate of a given shape.
   *
   * @return x coordinate of a shape.
   */

  @Override
  public int getX() {
    return this.x;
  }

  /**
   * Method to return the y coordinate of a given shape.
   *
   * @return y coordinate of a shape.
   */

  @Override
  public int getY() {
    return this.y;
  }

  /**
   * Method to return the red intensity of a shape's color.
   *
   * @return red intensity of a shape's color.
   */

  @Override
  public int getR() {
    return this.color.getRed();
  }

  /**
   * Method to return the green intensity of a shape's color.
   *
   * @return green intensity of a shape's color.
   */

  @Override
  public int getG() {
    return this.color.getGreen();
  }

  /**
   * Method to return the blue intensity of a shape's color.
   *
   * @return blue intensity of a shape's color.
   */

  @Override
  public int getB() {
    return this.color.getBlue();
  }

  /**
   * Method to return the width of a given shape.
   *
   * @return width of a shape
   */

  @Override
  public int getWidth() {
    return this.width;
  }

  /**
   * Method to return the height of a given shape.
   *
   * @return height of a shape
   */

  @Override
  public int getHeight() {
    return this.height;
  }

  /**
   * Method to return the name of a given shape.
   *
   * @return name of a shape
   */

  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Sets a new value for x.
   *
   * @param x the new x value of a shape
   */

  @Override
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Sets a new value for y.
   *
   * @param y the new y value of a shape
   */

  @Override
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Sets a new color for the shape.
   *
   * @param r red intensity of the color's shape
   * @param g green intensity of the color's shape
   * @param b blue intensity of the color's shape
   */

  @Override
  public void setColor(int r, int g, int b) {
    this.color = new Color(r, g, b);
  }

  /**
   * Sets a new value for w.
   *
   * @param w the new w value of a shape
   */

  @Override
  public void setW(int w) {
    this.width = w;
  }

  /**
   * Sets a new value for h.
   *
   * @param h the new h value of a shape
   */

  @Override
  public void setH(int h) {
    this.height = h;
  }
}
