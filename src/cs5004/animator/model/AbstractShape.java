package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents an abstract shape. It implements the IShape interface which includes
 * various getter functions for the many attributes of an individual shape. This class is able to
 * construct a new shape object with these parameters as well as return the value of a given
 * element.
 */

public abstract class AbstractShape implements IShape {
  private double x;
  private double y;
  private Color color;
  private double width;
  private double height;
  private int startTime;
  private int endTime;
  private String name;

  /**
   * This method constructs an abstract shape object. Each shape contains an x / y coordinate, rgb
   * value, width, height, start time, and end time. While rgb values are supplied as integers, the
   * constructor creates a Color object using this data in order to represent the given color.
   *
   * @param x         x coordinate of the shape
   * @param y         y coordinate of the shape
   * @param r         red intensity of the shape's color
   * @param g         green intensity of the shape's color
   * @param b         blue intensity of the shape's color
   * @param width     width of the shape
   * @param height    height of the shape
   * @param startTime starting time of the shape
   * @param endTime   end time of the shape
   * @param name      name of the shape
   * @throws IllegalArgumentException if width or height is below 0
   * @throws IllegalArgumentException if rgb values are not between 0-255 inclusive
   * @throws IllegalArgumentException if the x or y-coordinates are negative (we're assuming the
   *                                  display will only work within the first quadrant, i.e. only
   *                                  positive x and y values -- this may be modified upon further
   *                                  instruction)
   * @throws IllegalArgumentException if the String name is null
   */

  public AbstractShape(double x, double y, int r, int g, int b, double width, double height,
                       int startTime, int endTime, String name) throws IllegalArgumentException {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("x and y-coordinates can't be negative");
    }
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
    this.startTime = startTime;
    this.endTime = endTime;
    this.name = name;
  }

  /**
   * Method to return the x coordinate of a given shape.
   *
   * @return x coordinate of a shape.
   */

  @Override
  public double getX() {
    return this.x;
  }

  /**
   * Method to return the y coordinate of a given shape.
   *
   * @return y coordinate of a shape.
   */

  @Override
  public double getY() {
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
  public double getWidth() {
    return this.width;
  }

  /**
   * Method to return the height of a given shape.
   *
   * @return height of a shape
   */

  @Override
  public double getHeight() {
    return this.height;
  }

  /**
   * Method to return the starting time of a given shape.
   *
   * @return starting time of a shape
   */

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  /**
   * Method to return the end time of a given shape.
   *
   * @return end time of a shape
   */

  @Override
  public int getEndTime() {
    return this.endTime;
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

}
