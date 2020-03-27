
/**
 * This is a ChangeScale object which extends AbstractTransform it contains a toString that details
 * the scale changes of a shape (e.g. from starting width/height transforming to new width/height)
 * and the start/end time when the transformation occur in the animation. The constructor calls the
 * super class, AbstractTransform, to instantiate the the shape's unique identifier and the
 * start/end time of the transformation. The constructor also instantiates the starting width/height
 * and the new width/height.
 */

public class ChangeScale extends AbstractTransform {
  private double fromWidth;
  private double fromHeight;
  private double toWidth;
  private double toHeight;

  /**
   * This is a method to construct a ChangeScale object. It calls the super class, AbstractTransform
   * to instantiate shape.getName (the unique identifier for each IShape object),
   * and the start and end times of when the transformation should occur during the animation.
   * Additionally, it instantiates the starting scale of the shape (fromWidth, fromHeight)
   * and the new values it should be changed to (toWidth, toHeight).
   *
   * @param shape is the IShape object we're trying to transform
   * @param fromWidth the starting width
   * @param fromHeight the starting height
   * @param toWidth the new width
   * @param toHeight the new height
   * @param startTime is the time the transformation should start
   * @param endTime is the time the transformation should end
   * @throws IllegalArgumentException if the start time of the transformation occurs before the
   * shape even appears in the animation, conversely it also throws if the end time of the
   * transformation occurs after shape disappears from the animation
   * @throws IllegalArgumentException if width/height is negative
   */
  public ChangeScale(IShape shape, double fromWidth, double fromHeight, double toWidth,
                     double toHeight, int startTime, int endTime) throws IllegalArgumentException {
    super(shape.getName(), startTime, endTime);
    if (startTime < shape.getStartTime() || endTime > shape.getEndTime()) {
      throw new IllegalArgumentException("Transformation cannot occur before appearance of shape" +
              "/ after disappearance of shape.");
    }
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
    return String.format("Shape %s scales from Width: %.1f, Height: %.1f to Width: %.1f, Height: "
                    + "%.1f from t=%d to t=%d\n", this.getShapeID(), this.fromWidth,
            this.fromHeight, this.toWidth, this.toHeight, this.getStartTime(), this.getEndTime());
  }

}
