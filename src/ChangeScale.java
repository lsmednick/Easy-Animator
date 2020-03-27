/**
 * This is a ChangeScale object... TODO add stuff
 */

public class ChangeScale extends AbstractTransform {
  private double fromWidth;
  private double fromHeight;
  private double toWidth;
  private double toHeight;

  /**
   * Constructs a ChangeScale object...
   *
   * @param startTime starting time
   * @param endTime ending time
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
   * shape ID, original RGB values, new RGB values, and start / end time.
   *
   * @return string representation of ChangePos object
   */

  @Override
  public String toString() {
    return String.format("Shape %s scales from Width: %.1f, Height: %.1f to Width: %.1f, Height: "
                    + "%.1f from t=%d to t=%d\n", this.getShapeID(), this.fromWidth,
            this.fromHeight, this.toWidth, this.toHeight, this.getStartTime(), this.getEndTime());
  }

}
