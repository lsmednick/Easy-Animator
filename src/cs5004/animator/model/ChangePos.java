package cs5004.animator.model;

/**
 * This is a ChangePos object which extends AbstractTransform it contains a toString that details
 * the position change (e.g. the starting position of the shape and the position it was changed to)
 * and when these changes occur in the animation. The constructor calls the super class,
 * AbstractTransform, to instantiate the the shape's unique identifier and the start/end time of the
 * transformation. The constructor also instantiates the original position using x,y coordinates
 * (fromX, fromY) and position we're trying to move to (toX, toY).
 */

public class ChangePos extends AbstractTransform {
  private int fromX;
  private int fromY;
  private int toX;
  private int toY;

  /**
   * This is a constructor for a ChangePos object which calls the super class, AbstractTransform, to
   * instantiate shape.getName (the unique identifier for each IShape object), and the start and
   * end times of when the transformation should occur during the animation. Additionally, the
   * starting position of the shape (fromX, fromY) and the new position we're trying to move to
   * (toX, toY).
   *
   * @param shape     is the IShape object we're trying to transform
   * @param fromX     the starting x-coordinate
   * @param fromY     the starting y-coordinate
   * @param toX       the x-coordinate we're trying to move to
   * @param toY       the y-coordinate we're trying to move to
   * @param startTime is the time the transformation should start
   * @param endTime   is the time the transformation should end
   * @throws IllegalArgumentException if the startTime of the transformation occurs before the
   *                                  object appears in the animation or if the endTime of the
   *                                  transformation occurs after the object disappears in the
   *                                  animation
   * @throws IllegalArgumentException if the x or y-coordinates are negative (we're assuming the
   *                                  display will only work within the first quadrant, i.e. only
   *                                  positive x and y values -- this may be modified upon further
   *                                  instruction)
   */

  public ChangePos(IShape shape, int fromX, int fromY, int toX, int toY, int startTime,
                   int endTime) throws IllegalArgumentException {
    super(shape, startTime, endTime);
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;
  }

  /**
   * Method to return string representation of ChangPos object. This representation includes the
   * shape ID, original x and y-coordinate values, new x and y-coordinate values, and start / end
   * time.
   *
   * @return string representation of ChangePos object
   */

  @Override
  public String toString() {
    return String.format("Shape %s moves from (%d,%d) to (%d,%d) from t=%d to t=%d\n",
            this.getShapeID(), this.fromX, this.fromY, this.toX, this.toY, this.getStartTime(),
            this.getEndTime());
  }

  /**
   * Method to return fromX.
   *
   * @return fromX value
   */

  public int getFromX() {
    return this.fromX;
  }

  /**
   * Method to return fromY.
   *
   * @return fromY value
   */

  public int getFromY() {
    return this.fromY;
  }

  /**
   * Method to return toX.
   *
   * @return toX value
   */

  public int getToX() {
    return this.toX;
  }

  /**
   * Method to return toY.
   *
   * @return toY value
   */

  public int getToY() {
    return this.toY;
  }

  /**
   * Method to return a string with the information about the shape's motion in SVG format.
   *
   * @param speed the ticks per second speed.
   * @return a string of SVG format about the shape's motion.
   */

  @Override
  public String motionSVG(double speed) {
    double start = (this.getStartTime() / speed) * 1000;
    double end = (this.getEndTime() / speed) * 1000;
    double duration = end - start;

    double newFromX = this.fromX + this.getShape().newWidth();
    double newFromY = this.fromY + this.getShape().newHeight();
    double newToX = this.toX + this.getShape().newWidth();
    double newToY = this.toY + this.getShape().newHeight();


    String string = "<animate attributeType=\"xml\" begin=\"" + start + "ms\" dur=\""
            + duration + "ms\" attributeName=\"" + this.getShape().xTagSVG() + "\" from=\""
            + newFromX + "\" to=\"" + newToX + "\" fill=\"freeze\" />\n";
    string += "<animate attributeType=\"xml\" begin=\"" + start + "ms\" dur=\"" + duration
            + "ms\" attributeName=\"" + this.getShape().yTagSVG() + "\" from=\"" + newFromY
            + "\" to=\"" + newToY + "\" fill=\"freeze\" />\n";
    return string;
  }
}
