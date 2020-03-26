/**
 * This is an abstract class... TODO Finish this too
 */

public class AbstractTransform implements ITransform, Comparable<AbstractTransform> {
  private int startTime;
  private int endTime;

  public AbstractTransform(int startTime, int endTime) {
    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("Start / end time cannot be negative.");
    }
    if (endTime <= startTime) {
      throw new IllegalArgumentException("End time must come after start time.");
    }
    this.startTime = startTime;
    this.endTime = endTime;
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
