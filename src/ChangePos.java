/**
 * TODO add stuff
 * This is a ChangeScale object...
 */

public class ChangePos extends AbstractTransform {
  private double fromX;
  private double fromY;
  private double toX;
  private double toY;

  /**
   * TODO Finish this
   * Constructs a ChangePos object...
   *
   * @param startTime starting time
   * @param endTime ending time
   */

  public ChangePos(IShape shape, double fromX, double fromY, double toX, double toY, int startTime,
                   int endTime) throws IllegalArgumentException {
    super(shape.getName(), startTime, endTime);
    if (startTime < shape.getStartTime() || endTime > shape.getEndTime()) {
      throw new IllegalArgumentException("Transformation cannot occur before appearance of shape" +
              "/ after disappearance of shape.");
    }
    if (fromX < 0 || fromY < 0 || toX < 0 || toY < 0) {
      throw new IllegalArgumentException("X / Y coordinates cannot be negative.");
    }
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;
  }

  /**
   * TODO Edit
   * Method to return string representation of ChangePos object. This representation includes the
   * shape ID, original RGB values, new RGB values, and start / end time.
   *
   * @return string representation of ChangePos object
   */

  @Override
  public String toString() {
    return String.format("Shape %s moves from (%.1f,%.1f) to (%.1f,%.1f) from t=%d to t=%d\n"
            , this.getShapeID(), this.fromX, this.fromY, this.toX, this.toY, this.getStartTime(),
            this.getEndTime());
  }

}
