package cs5004.animator.model;

/**
 * This is a cs5004.animator.model.ChangeScale object which extends cs5004.animator.model.AbstractTransform it contains a toString that details
 * the scale changes of a shape (e.g. from starting width/height transforming to new width/height)
 * and the start/end time when the transformation occur in the animation. The constructor calls the
 * super class, cs5004.animator.model.AbstractTransform, to instantiate the the shape's unique identifier and the
 * start/end time of the transformation. The constructor also instantiates the starting width/height
 * and the new width/height.
 */

public class ChangeScale extends AbstractTransform {
  private int fromWidth;
  private int fromHeight;
  private int toWidth;
  private int toHeight;

  /**
   * This is a method to construct a ChangeScale object. It calls the super class, AbstractTransform
   * to instantiate shape.getName (the unique identifier for each IShape object), and the start and
   * end times of when the transformation should occur during the animation. Additionally, it
   * instantiates the starting scale of the shape (fromWidth, fromHeight) and the new values it
   * should be changed to (toWidth, toHeight).
   *
   * @param shape      is the IShape object we're trying to transform
   * @param fromWidth  the starting width
   * @param fromHeight the starting height
   * @param toWidth    the new width
   * @param toHeight   the new height
   * @param startTime  is the time the transformation should start
   * @param endTime    is the time the transformation should end
   * @throws IllegalArgumentException if the startTime of the transformation occurs before the
   *                                  object appears in the animation or if the endTime of the
   *                                  transformation occurs after the object disappears in the
   *                                  animation
   * @throws IllegalArgumentException if width/height is negative
   */
  public ChangeScale(IShape shape, int fromWidth, int fromHeight, int toWidth,
                     int toHeight, int startTime, int endTime) throws IllegalArgumentException {
    super(shape, startTime, endTime);
    if (fromWidth < 0 || fromHeight < 0 || toWidth < 0 || toHeight < 0) {
      throw new IllegalArgumentException("Widths / heights cannot be negative.");
    }
    this.fromWidth = fromWidth;
    this.fromHeight = fromHeight;
    this.toWidth = toWidth;
    this.toHeight = toHeight;
  }

  /**
   * Method to return string representation of ChangeScale object. This representation includes the
   * shape ID, original width and height values, new width and height values, and start / end time.
   *
   * @return string representation of ChangeScale object
   */

  @Override
  public String toString() {
    return String.format("Shape %s scales from Width: %d, Height: %d to Width: %d, Height: "
                    + "%d from t=%d to t=%d\n", this.getShapeID(), this.fromWidth,
            this.fromHeight, this.toWidth, this.toHeight, this.getStartTime(), this.getEndTime());
  }

  /**
   * Method to return fromWidth value.
   *
   * @return fromWidth value
   */

  public int getFromWidth() {
    return this.fromWidth;
  }

  /**
   * Method to return fromHeight value.
   *
   * @return fromHeight value
   */

  public int getFromHeight() {
    return this.fromHeight;
  }

  /**
   * Method to return toWidth value.
   *
   * @return toWidth value
   */

  public int getToWidth() {
    return this.toWidth;
  }

  /**
   * Method to return toHeight value.
   *
   * @return toHeight value
   */

  public int getToHeight() {
    return this.toHeight;
  }

  @Override
  public TransformType getTransformType() {
    return TransformType.SCALE;
  }

  @Override
  public String motionSVG() {
    int duration = (this.getEndTime() - this.getStartTime());

    String string = "<animate attributeType=\"xml\" begin=\"" + this.getStartTime() + "s\" dur=\""
            + duration + "s\" attributeName=\"" + this.getShape().widthTagSVG() + "\" from=\""
            + this.getFromWidth() + "\" to=\"" + this.getToWidth() + "\" fill=\"freeze\" />\n";
    string += "<animate attributeType=\"xml\" begin=\"" + this.getStartTime() + "s\" dur=\""
            + duration + "s\" attributeName=\"" + this.getShape().heightTagSVG() + "\" from=\""
            + this.getFromHeight() + "\" to=\"" + this.getToHeight() + "\" fill=\"freeze\" />\n";

    return string;
  }
}
