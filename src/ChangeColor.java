/**
 * This is a ChangeColor object... TODO add stuff
 */

public class ChangeColor extends AbstractTransform {
  private int fromR;
  private int fromG;
  private int fromB;
  private int toR;
  private int toG;
  private int toB;

  /**
   * Constructs a ChangeColor object...
   *
   * @param startTime starting time
   * @param endTime ending time
   */

  public ChangeColor(IShape shape, int fromR, int fromG, int fromB, int toR, int toG, int toB,
                     int startTime, int endTime) throws IllegalArgumentException {
    super(shape.getName(), startTime, endTime);
    if (startTime < shape.getStartTime() || endTime > shape.getEndTime()) {
      throw new IllegalArgumentException("Transformation cannot occur before appearance of shape" +
              "/ after disappearance of shape.");
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
