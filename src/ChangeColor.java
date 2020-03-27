
/**
 * This is a ChangeColor object which extends AbstractTransform it contains a toString that details
 * the color changes (e.g. the starting color of the shape and the color it was changed to) and when
 * these changes occur in the animation. The constructor calls the super class, AbstractTransform,
 * to instantiate the the shape's unique identifier and the start/end time of the transformation.
 * The constructor also instantiates the original Color values (fromR, fromG, fromB) and the new
 * Color values (toR, toG, toB) that the should transform the object.
 */

public class ChangeColor extends AbstractTransform {
  private int fromR;
  private int fromG;
  private int fromB;
  private int toR;
  private int toG;
  private int toB;

  /**
   * This a a method to construct a ChangeColor object.  It calls the super class,
   * AbstractTransform, to instantiate shape.getName (the unique identifier for each IShape object),
   * and the start and end times of when the transformation should occur during the animation.
   * Additionally it instantiates the starting Color values of the the shape (fromR, fromG, fromB)
   * and the Color values it should be changed to (toR, toG, toB).
   *
   * @param shape     is the IShape object we're trying to transform
   * @param fromR     the starting Red value/component of the shape's Color
   * @param fromG     the starting Green value/component of the shape's Color
   * @param fromB     the starting Blue value/component of the shape's Color
   * @param toR       the the ending Red value/component of the shape's Color
   * @param toG       the ending Green value/component of the shape's Color
   * @param toB       the ending Blue value/component of the shape's Color
   * @param startTime is the time the transformation should start
   * @param endTime   is the time the transformation should end
   * @throws IllegalArgumentException if the startTime of the transformation occurs before the
   *                                  object appears in the animation or if the endTime of the
   *                                  transformation occurs after the object disappears in the
   *                                  animation
   */
  public ChangeColor(IShape shape, int fromR, int fromG, int fromB, int toR, int toG, int toB,
                     int startTime, int endTime) throws IllegalArgumentException {
    super(shape.getName(), startTime, endTime);
    if (startTime < shape.getStartTime() || endTime > shape.getEndTime()) {
      throw new IllegalArgumentException("Transformation cannot occur before appearance of shape"
              + "/ after disappearance of shape.");
    }
    this.fromR = fromR;
    this.fromG = fromG;
    this.fromB = fromB;
    this.toR = toR;
    this.toG = toG;
    this.toB = toB;
  }

  /**
   * Method to return string representation of ChangeColor object. This representation includes the
   * shape ID, original RGB values, new RGB values, and start / end time.
   *
   * @return string representation of ChangeColor object
   */

  @Override
  public String toString() {
    return String.format("Shape %s changes color from (%d,%d,%d) to (%d,%d,%d) from t=%d to t=%d\n",
            this.getShapeID(), this.fromR, this.fromG, this.fromB, this.toR, this.toG, this.toB,
            this.getStartTime(), this.getEndTime());
  }

}
