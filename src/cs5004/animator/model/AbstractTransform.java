package cs5004.animator.model;

/**
 * This is an abstract class that implements ITransform and the Comparable interface which will
 * allow transformations to be sorted in accordance to the start/end times within an animation. It
 * contains a constructor with parameters for a shape ID, start time and end time of a
 * transformation. This class also has getters for the previously described fields.
 */

public abstract class AbstractTransform implements ITransform, Comparable<AbstractTransform> {
  private int startTime;
  private int endTime;
  private IShape shape;

  /**
   * Constructor that takes in a String shapeID (the shape's unique identifier), the start time of
   * the transformation and the end time of the transformation.
   *
   * @param shape   is a shape's unique identifier
   * @param startTime when a transformation should start within the animation
   * @param endTime   when a transformation should end within the animation
   * @throws IllegalArgumentException if start/end time is less than 0
   * @throws IllegalArgumentException if the end time is before the start time
   * @throws IllegalArgumentException if the shapeID is null
   */

  public AbstractTransform(IShape shape, int startTime, int endTime)
          throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("shape can not be null.");
    }
    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("Start / end time cannot be negative.");
    }
    if (endTime < startTime) {
      throw new IllegalArgumentException("End time must come after start time.");
    }
    this.startTime = startTime;
    this.endTime = endTime;
    this.shape = shape;
  }

  protected IShape getShape() {
    return this.shape;
  }

  /**
   * Method to return the string representation of a given shape.
   *
   * @return string representation of a given shape
   */

  @Override
  public String getShapeID() {
    return this.shape.getName();
  }

  /**
   * Method to return the start time of a given transformation.
   *
   * @return start time of a transformation
   */

  @Override
  public int getStartTime() {
    return startTime;
  }

  /**
   * Method to return the end time of a given transformation.
   *
   * @return end time of transformation
   */

  @Override
  public int getEndTime() {
    return endTime;
  }

  /**
   * Method to compare each transformations to ensure that they are executed in the correct order.
   *
   * @param o an AbstractTransform object
   * @return integer representing the sorting order of the AbstractTransform objects
   */

  @Override
  public int compareTo(AbstractTransform o) {
    int timeDifference = this.startTime - o.startTime;

    if (timeDifference == 0) {
      timeDifference = this.endTime - o.endTime;
    }

    return timeDifference;
  }

}
