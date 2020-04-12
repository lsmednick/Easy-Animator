package cs5004.animator.model;

/**
 * This class represents a rectangle and extends the AbstractShape superclass. Each rectangle
 * contains a width, height. x / y coordinates, rgb values, and a start / end time. Additionally,
 * this class contains a toString method in order to provide a string display of the object's
 * attributes.
 */

public class Rectangle extends AbstractShape {

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
   * @param name      name of the shape
   * @throws IllegalArgumentException if width or height is below 0
   * @throws IllegalArgumentException if rgb values are not between 0-255 inclusive
   * @throws IllegalArgumentException if the x or y-coordinates are negative (we're assuming the
   *                                  display will only work within the first quadrant, i.e. only
   *                                  positive x and y values -- this may be modified upon further
   *                                  instruction)
   * @throws IllegalArgumentException if the String name is null
   */

  public Rectangle(int x, int y, int r, int g, int b, int width, int height, String name)
          throws IllegalArgumentException {
    super(x, y, r, g, b, width, height, name);
  }

  /**
   * This toString describes each attribute of the Rectangle IShape object -- name (unique
   * identifier of the shape), the shape type (Rectangle), position (x, y-coordinates), Color (red,
   * green, blue values), width, height, start/end time the object appears/disappears in the
   * animation.
   *
   * @return a string describing all the fields of an Rectangle
   */

  @Override
  public String toString() {
    return String.format("Name: %s\nType: Rectangle\nMin corner: (%d, %d), Width: %d, "
                    + "Height: %d, Color: (%d, %d, %d)\n\n",
            this.getName(), this.getX(), this.getY(), this.getWidth(), this.getHeight(),
            this.getR(), this.getG(), this.getB());
  }

  @Override
  public ShapeType getType() {
    return ShapeType.RECTANGLE;
  }

  @Override
  public String shapeSVG() {
    String string = "";

    string += "<rect id=\"" + this.getName() + "\" x=\"" + this.getX() + "\" y=\""
            + this.getY() + "\" width=\"" + this.getWidth() + "\" height=\"" + this.getHeight()
            + "\" fill=\"rgb(" + this.getR() + "," + this.getG() + "," + this.getB() + ")\" >\n";

    return string;
  }

  @Override
  public String shapeEndSVG() {
    return "</rect>\n";
  }

  @Override
  public String xTagSVG() {
    return "x";
  }

  @Override
  public String yTagSVG() {
    return "y";
  }

  @Override
  public String widthTagSVG() {
    return "width";
  }

  @Override
  public String heightTagSVG() {
    return "height";
  }

  @Override
  public double newWidth() {
    return 0;
  }

  @Override
  public double newHeight() {
    return 0;
  }

  @Override
  public double widthHeightDiff() {
    return 1.0;
  }

  @Override
  public Rectangle copy() {
    return new Rectangle(this.getX(), this.getY(), this.getR(), this.getG(), this.getB(),
            this.getWidth(), this.getHeight(), this.getName());
  }

}
