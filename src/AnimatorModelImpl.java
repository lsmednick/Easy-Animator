import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Is a class that implements interface AnimatorModel. This class holds a Map which contains a list
 * of all the shapes in the animation. The Map's key is a String ID and the value is
 * a IShape (Oval, Rectangle, Triangle). Separately, this class also stores a List of
 * transformations (ChangeColor, ChangePosition, ChangeScale) that occur within the animation.
 */

public class AnimatorModelImpl implements AnimatorModel {
  private Map<String, IShape> shapeList = new HashMap<>();
  private List<ITransform> transformList = new ArrayList<>();

  /**
   * Method to add shape to the current animation.
   *
   * @param name      name of the shape
   * @param shapeType type of the shape (rectangle, oval, triangle)
   * @param x         x coordinate of the shape
   * @param y         y coordinate of the shape
   * @param r         red intensity of the shape's color
   * @param g         green intensity of the shape's color
   * @param b         blue intensity of the shape's color
   * @param width     width of the shape
   * @param height    height of the shape
   * @param startTime starting time of the shape
   * @param endTime   end time of the shape
   */

  @Override
  public void addShape(String name, ShapeType shapeType, double x, double y, int r, int g, int b
          , double width, double height, int startTime, int endTime)
          throws IllegalArgumentException {

    IShape newShape;

    if (startTime < 0 || endTime < 0) {
      throw new IllegalArgumentException("Start / end time cannot be negative.");
    }
    if (endTime <= startTime) {
      throw new IllegalArgumentException("End time must be after start time.");
    }

    switch (shapeType) {
      case OVAL:
        newShape = new Oval(x, y, r, g, b, width, height, startTime, endTime, name);
        break;
      case TRIANGLE:
        newShape = new Triangle(x, y, r, g, b, width, height, startTime, endTime, name);
        break;
      case RECTANGLE:
        newShape = new Rectangle(x, y, r, g, b, width, height, startTime, endTime, name);
        break;
      default:
        newShape = null;
    }
    shapeList.put(name, newShape);
  }

  /**
   * Helper function in order to detect duplicate transformation objects. This method returns true
   * if there already exists a transformation in transformList for a given object within a specified
   * time frame. Returns false otherwise.
   *
   * @param shapeID   the string identifer of the shape
   * @param startTime the starting time of the transformation
   * @param endTime   the ending time of the transformation
   * @return boolean representing if there is a duplicate
   */

  private boolean duplicateHelper(String shapeID, int startTime, int endTime) {
    for (ITransform t : transformList) {
      if (t.getShapeID().equals(shapeID) && t.getStartTime() == startTime
              && t.getEndTime() == endTime) {
        return true;
      }
    }
    return false;
  }

  /**
   * Method to change the shape's position.
   *
   * @param shapeID   the string ID of the shape that should be moved
   * @param fromX     the X coordinate we're moving the shape from
   * @param fromY     the Y coordinate we're moving the shape from
   * @param toX       the X coordinate we're moving the shape to
   * @param toY       the Y coordinate we're moving the shape to
   * @param startTime the time (int) that the object should start moving
   * @param endTime   the time (int) that the object should end movement
   * @throws IllegalArgumentException if attempting to move to the same position
   * @throws IllegalArgumentException if creating transformation that already exists for a shape
   *                                  withing a given time frame
   */

  @Override
  public void changePos(String shapeID, double fromX, double fromY, double toX, double toY,
                        int startTime, int endTime) throws IllegalArgumentException {
    if (fromX == toX && fromY == toY) {
      throw new IllegalArgumentException("Cannot move to the same position.");
    }
    if (duplicateHelper(shapeID, startTime, endTime)) {
      throw new IllegalArgumentException("Transformation already exists for that shape during the"
              + "specified time frame.");
    }
    ITransform transformation = new ChangePos(shapeList.get(shapeID), fromX, fromY, toX, toY,
            startTime, endTime);
    transformList.add(transformation);
  }

  /**
   * Create a object that stores that values for RBG which will change the color of our Shape.
   *
   * @param shapeID   the IShape object that should be moved
   * @param fromR     value specifying the original red component of Color
   * @param fromG     value specifying the original green component of Color
   * @param fromB     value specifying the original blue component of Color
   * @param toR       value specifying the new red component of Color
   * @param toG       value specifying the new green component of Color
   * @param toB       value specifying the new blue component of Color
   * @param startTime starting time of the transformation
   * @param endTime   ending time of the transformation
   * @throws IllegalArgumentException if the value of r,g,b is not between 0-255 inclusive
   * @throws IllegalArgumentException if from and to colors are the same
   * @throws IllegalArgumentException if creating transformation that already exists for a shape
   *                                  within a given time frame
   */

  @Override
  public void changeColor(String shapeID, int fromR, int fromG, int fromB, int toR, int toG,
                          int toB, int startTime, int endTime) throws IllegalArgumentException {
    if (fromR == toR && fromB == toB && fromG == toG) {
      throw new IllegalArgumentException("Colors must be different.");
    }
    if (duplicateHelper(shapeID, startTime, endTime)) {
      throw new IllegalArgumentException("Transformation already exists for that shape during the"
              + "specified time frame.");
    }
    ITransform transformation = new ChangeColor(shapeList.get(shapeID), fromR, fromG, fromB, toR,
            toG, toB, startTime, endTime);
    transformList.add(transformation);
  }

  /**
   * This method will scale the current shape.
   *
   * @param shapeID    the string ID of the shape to be scaled
   * @param type       type of shape to be scaled
   * @param fromWidth  starting width of the shape
   * @param fromHeight starting height of the shape
   * @param toWidth    final width of the shape
   * @param toHeight   final width of the shape
   * @param startTime  starting time of the transformation
   * @param endTime    ending time of the transformation
   */

  @Override
  public void changeScale(String shapeID, ShapeType type, double fromWidth, double fromHeight,
                          double toWidth, double toHeight, int startTime, int endTime)
          throws IllegalArgumentException {
    if (fromWidth == toWidth && fromHeight == toHeight) {
      throw new IllegalArgumentException("Either height or weight must be different.");
    }
    if (duplicateHelper(shapeID, startTime, endTime)) {
      throw new IllegalArgumentException("Transformation already exists for that shape during the"
              + "specified time frame.");
    }
    ITransform transformation = new ChangeScale(shapeList.get(shapeID), fromWidth, fromHeight,
            toWidth, toHeight, startTime, endTime);
    transformList.add(transformation);
  }

  /**
   * A method that prints a String describing the current state of the animation.
   *
   * @return a String describing the current state of the animation
   */
  @Override
  public String getState() {

    StringBuilder string = new StringBuilder();
    string.append("Shapes:\n");

    for (String key : shapeList.keySet()) {
      string.append(shapeList.get(key).toString());
    }

    for (ITransform t : transformList) {
      string.append(t.toString());
    }

    return string.toString();
  }

}
