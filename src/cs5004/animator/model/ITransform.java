package cs5004.animator.model;

/**
 * An interface that supports creating ITransform objects which record IShape object transformations
 * (e.g. changes color, position or scale). The ITransform objects for the animation are stored in
 * the AnimatorModelImpl within a List. The interface contains getters for the shapeID (unique
 * identifier of each IShape), the start time of the transformation and the end time of the
 * transformation.
 */

public interface ITransform {

  /**
   * Method to return the string representation of a given shape.
   *
   * @return string representation of a given shape
   */

  String getShapeID();

  /**
   * Method to return the start time of a given transformation.
   *
   * @return start time of a transformation
   */

  int getStartTime();

  /**
   * Method to return the end time of a given transformation.
   *
   * @return end time of transformation
   */

  int getEndTime();

}
