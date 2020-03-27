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
   * @throws IllegalArgumentException if the x or y-coordinates are negative (we're assuming the
   *                                  display will only work within the first quadrant, i.e. only
   *                                  positive x and y values -- this may be modified upon further
   *                                  instruction)
   * @throws IllegalArgumentException if the String name is null
   */

  public Oval(double x, double y, int r, int g, int b, double width, double height, int startTime,
          int endTime, String name) throws IllegalArgumentException {
    super(x, y, r, g, b, width, height, startTime, endTime, name);
  }

  /**
   * This toString describes each attribute of the Oval IShape object -- name (unique identifier of
   * the shape), the shape type (Oval), position (x, y-coordinates), Color (red, green, blue
   * values), width, height, start/end time the object appears/disappears in the animation.
   *
   * @return a string describing all the attributes of an Oval
   */

  @Override
  public String toString() {
    return String.format("Name: %s\nType: Oval\nCenter: (%.1f, %.1f), X radius: %.1f, "
                    + "Y radius: %.1f, Color: (%d, %d, %d)\nAppears at t=%d\n"
                    + "Disappears at t=%d\n\n",
            this.getName(), this.getX(), this.getY(), this.getWidth(), this.getHeight(),
            this.getR(), this.getG(), this.getB(), this.getStartTime(), this.getEndTime());
  }

}
