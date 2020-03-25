/**
 * This class represents an oval and extends the AbstractShape superclass. Each oval contains a
 * width, height. x / y coordinates, rgb values, and a start / end time. Additionally, this class
 * contains a toString method in order to provide a string display of the object's attributes.
 */

public class Oval extends AbstractShape {

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
   */

  public Oval(double x, double y, int r, int g, int b, double width, double height, int startTime
              , int endTime, String name) throws IllegalArgumentException {
    super(x, y, r, g, b, width, height, startTime, endTime, name);
  }

  @Override
  public String toString() {
    return String.format("Name: %s\nType: Oval\nPosition: (%.1f, %.1f)\nWidth: %.1f\nHeight: %.1f\n"
            + "Color: (%d, %d, %d)\nStarting Time: %d\nEnd Time: %d", this.getName(), this.getX()
            , this.getY(), this.getWidth(), this.getHeight(), this.getR(), this.getG(), this.getB()
            , this.getStartTime(), this.getEndTime());
  }

}
