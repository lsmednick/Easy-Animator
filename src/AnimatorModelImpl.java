import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the model... TODO Finish this comment
 */

public class AnimatorModelImpl implements AnimatorModel {
  private Map<String, IShape> shapeList = new HashMap<>();
  private Map<ITransform, String> transformList = new HashMap<>();

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

    switch(shapeType) {
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

  //TODO how to access the ISHAPE and how to consider timeStart and timeEnd
  @Override
  public void move(IShape shape, double toX, double toY, int moveStartTime, int moveEndTime)
          throws IllegalArgumentException {
    if (toX < 0) {
      throw new IllegalArgumentException("can't move to a negative X coordinate");
    }
    if (toY < 0) {
      throw new IllegalArgumentException("can't move to a negative Y coordinate ");
    }

    shape.setCoordinates(toX, toY);

    //TODO -- how to deal with moveStarTime, moveEndTime
  }

  @Override
  public void changeColor(IShape shape, int r, int g, int b) {
    shape.setColor(r, g, b);
  }


  //TODO -- leave this for now
  @Override
  public void changeShape(Shape myShape) {
  }


  @Override
  public void scaling(IShape shape, int scalingHeight, int scalingWidth) {
    shape.setScaling(scalingHeight, scalingWidth);
  }


  //TODo -- leave this for now
  @Override
  public void changeLayer(int layer) {
  }
}
