package cs5004.animator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Is a class that implements interface AnimatorModel. This class holds a Map which contains a list
 * of all the shapes in the animation. The Map's key is a String ID and the value is a IShape (Oval,
 * Rectangle, Triangle). Separately, this class also stores a List of transformations (ChangeColor,
 * ChangePosition, ChangeScale) that occur within the animation.
 */

public class AnimatorModelImpl implements AnimatorModel {
  private Map<String, IShape> shapeList = new HashMap<>();
  private List<AbstractTransform> transformList = new ArrayList<>();
  private int topLeftX;
  private int topLeftY;
  private int canvasWidth;
  private int canvasHeight;

  public AnimatorModelImpl(int topLeftX, int topLeftY, int canvasWidth, int canvasHeight) {
    this.topLeftX = topLeftX;
    this.topLeftY = topLeftY;
    this.canvasWidth = canvasWidth;
    this.canvasHeight = canvasHeight;
  }

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
   * @throws IllegalArgumentException if startTime or endTime is negative
   * @throws IllegalArgumentException if endTime occurs before startTime
   */

  @Override
  public void addShape(String name, ShapeType shapeType, int x, int y, int r, int g, int b,
          int width, int height)
          throws IllegalArgumentException {

    IShape newShape;

    switch (shapeType) {
      case OVAL:
        newShape = new Oval(x, y, r, g, b, width, height, name);
        break;
      case RECTANGLE:
        newShape = new Rectangle(x, y, r, g, b, width, height, name);
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
   * @param shapeID   the string identifier of the shape
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
   * @throws IllegalArgumentException if the shapeID does not exist in our shapeList (i.e. trying to
   *                                  modify a shape that doesn't exist in the animation)
   */

  @Override
  public void changePos(String shapeID, int fromX, int fromY, int toX, int toY,
                        int startTime, int endTime) throws IllegalArgumentException {
    if (duplicateHelper(shapeID, startTime, endTime)) {
      throw new IllegalArgumentException("Transformation already exists for that shape during the"
              + "specified time frame.");
    }
    if (!shapeList.containsKey(shapeID)) {
      throw new IllegalArgumentException("Entered shape does not exist in the model.");
    }
    AbstractTransform transformation = new ChangePos(shapeList.get(shapeID), fromX, fromY, toX, toY,
            startTime, endTime);
    transformList.add(transformation);
  }

  /**
   * Create a object that stores that values for RBG which will change the color of our Shape.
   *
   * @param shapeID   the cs5004.animator.model.IShape object that should be moved
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
   * @throws IllegalArgumentException if the shapeID does not exist in our shapeList (i.e. trying to
   *                                  modify a shape that doesn't exist in the animation)
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
    if (!shapeList.containsKey(shapeID)) {
      throw new IllegalArgumentException("Entered shape does not exist in the model.");
    }
    AbstractTransform transformation = new ChangeColor(shapeList.get(shapeID), fromR, fromG, fromB,
            toR, toG, toB, startTime, endTime);
    transformList.add(transformation);
  }

  /**
   * This method will scale the current shape.
   *
   * @param shapeID    the string ID of the shape to be scaled
   * @param fromWidth  starting width of the shape
   * @param fromHeight starting height of the shape
   * @param toWidth    final width of the shape
   * @param toHeight   final width of the shape
   * @param startTime  starting time of the transformation
   * @param endTime    ending time of the transformation
   * @throws IllegalArgumentException if the new width/height is the same as the previous
   *                                  width/height
   * @throws IllegalArgumentException if creating transformation that already exists for a shape
   *                                  within a given time frame
   * @throws IllegalArgumentException if the shapeID does not exist in our shapeList (i.e. trying to
   *                                  modify a shape that doesn't exist in the animation)
   */

  @Override
  public void changeScale(String shapeID, int fromWidth, int fromHeight,
                          int toWidth, int toHeight, int startTime, int endTime)
          throws IllegalArgumentException {
    if (fromWidth == toWidth && fromHeight == toHeight) {
      throw new IllegalArgumentException("Either height or weight must be different.");
    }
    if (duplicateHelper(shapeID, startTime, endTime)) {
      throw new IllegalArgumentException("Transformation already exists for that shape during the"
              + "specified time frame.");
    }
    if (!shapeList.containsKey(shapeID)) {
      throw new IllegalArgumentException("Entered shape does not exist in the model.");
    }
    AbstractTransform transformation = new ChangeScale(shapeList.get(shapeID), fromWidth,
            fromHeight, toWidth, toHeight, startTime, endTime);
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

    Collections.sort(transformList);
    for (ITransform t : transformList) {
      string.append(t.toString());
    }

    return string.toString();
  }

  /**
   * Method to return an updated HashMap based on the transformations being applied to the shapes
   * in the animation. This method loops through each transformation in the list and applies the
   * "tweening" formula based on the supplied tick number in order to create a smooth animation
   * in collaboration with the view.
   *
   * @param tick the time at which to determine the shape's updated attributes
   * @return updated HashMap containing new instances of each shape in the animation
   */

  @Override
  public Map<String, IShape> getShapesAtTick(int tick) {
    Map<String, IShape> updatedMap = new HashMap<>();
    System.out.print(String.format("TICK: %d", tick));
    //Collections.sort(transformList);
    for (ITransform transform : transformList) {
      IShape s = shapeList.get(transform.getShapeID());
      int start = transform.getStartTime();
      int end = transform.getEndTime();

      if (start == end || tick > end) {
        continue;
      }
      if (tick <= start && start != 1) {
        break;
      }

      if (transform instanceof ChangePos) {
        int fromX = ((ChangePos) transform).getFromX();
        int fromY = ((ChangePos) transform).getFromY();
        int toX = ((ChangePos) transform).getToX();
        int toY = ((ChangePos) transform).getToY();

        int newX = (fromX * (end - tick) / (end - start))
                + (toX * (tick - start) / (end - start));
        int newY = (fromY * (end - tick) / (end - start))
                + (toY * (tick - start) / (end - start));

        if (s instanceof Oval) {
          updatedMap.put(s.getName(), new Oval(newX, newY, s.getR(), s.getG(), s.getB(),
                  s.getWidth(), s.getHeight(), s.getName()));
        } else if (s instanceof Rectangle) {
          updatedMap.put(s.getName(), new Rectangle(newX, newY, s.getR(), s.getG(), s.getB(),
                  s.getWidth(), s.getHeight(), s.getName()));
        }
      } else if (transform instanceof ChangeColor) {
        int fromR = ((ChangeColor) transform).getFromR();
        int fromG = ((ChangeColor) transform).getFromG();
        int fromB = ((ChangeColor) transform).getFromB();
        int toR = ((ChangeColor) transform).getToR();
        int toG = ((ChangeColor) transform).getToG();
        int toB = ((ChangeColor) transform).getToB();

        int newR = (fromR * (end - tick) / (end - start))
                + (toR * (tick - start) / (end - start));
        int newG = (fromG * (end - tick) / (end - start))
                + (toG * (tick - start) / (end - start));
        int newB = (fromB * (end - tick) / (end - start))
                + (toB * (tick - start) / (end - start));

        if (s instanceof Oval) {
          updatedMap.put(s.getName(), new Oval(s.getX(), s.getY(), newR, newG, newB, s.getWidth(),
                  s.getHeight(), s.getName()));
        } else if (s instanceof Rectangle) {
          updatedMap.put(s.getName(), new Rectangle(s.getX(), s.getY(), newR, newG, newB,
                  s.getWidth(), s.getHeight(), s.getName()));
        }
      } else if (transform instanceof ChangeScale) {
        int fromW = ((ChangeScale) transform).getFromWidth();
        int fromH = ((ChangeScale) transform).getFromHeight();
        int toW = ((ChangeScale) transform).getToWidth();
        int toH = ((ChangeScale) transform).getToHeight();

        int newW = (fromW * (end - tick) / (end - start))
                + (toW * (tick - start) / (end - start));
        int newH = (fromH * (end - tick) / (end - start))
                + (toH * (tick - start) / (end - start));

        if (s instanceof Oval) {
          updatedMap.put(s.getName(), new Oval(s.getX(), s.getY(), s.getR(), s.getG(), s.getB(),
                  newW, newH, s.getName()));
        } else if (s instanceof Rectangle) {
          updatedMap.put(s.getName(), new Rectangle(s.getX(), s.getY(), s.getR(), s.getG(),
                  s.getB(), newW, newH, s.getName()));
        }
      }
    }
    return updatedMap;
  }

  /**
   * Getter to return a copy the current map of shapes in the animation so
   * the original map can not be mutated.
   * @return a map of the shapes in the animation
   */

   public Map<String, IShape> getShapeList() {

    Map<String, IShape> copyShapeList = new HashMap<>();
    for (String key: shapeList.keySet()) {
      copyShapeList.put(key, shapeList.get(key));
    }
    return copyShapeList;

  }

  /**
   * Getter to return a copy the current list of transformation in the animation so it
   * the original list can not be mutated.
   * @return a list of the transformations in the animation
   */

   public List<AbstractTransform>getTransformList(){

     List<AbstractTransform> copyTransformList = new ArrayList<>();
     for (AbstractTransform t: transformList){
       copyTransformList.add(t);
     }
     return copyTransformList;
   }

  /**
   * Method to return the top left X coordinate.
   *
   * @return top left X coordinate
   */

  @Override
  public int getTopLeftX() {
    return this.topLeftX;
  }

  /**
   * Method to return the top left Y coordinate.
   *
   * @return top left Y coordinate
   */

  public int getTopLeftY() {
    return this.topLeftY;
  }

  /**
   * Method to return the canvas width.
   *
   * @return canvas width
   */

  public int getCanvasWidth() {
     return this.canvasWidth;
   }

  /**
   * Method to return the canvas height.
   *
   * @return canvas width
   */

  public int getCanvasHeight() {
    return this.canvasHeight;
  }





}
