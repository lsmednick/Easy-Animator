package cs5004.animator.model;

import java.util.List;
import java.util.Map;

/**
 * Interface for the Easy Animator Application. This supports an abstract class that will define 2D
 * shapes that are used for animation.
 */

public interface AnimatorModel {

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
   * @param width     width of the addshape
   * @param height    height of the shape
   * @throws IllegalArgumentException if startTime or endTime is negative
   * @throws IllegalArgumentException if endTime occurs before startTime
   */

  void addShape(String name, ShapeType shapeType, int x, int y, int r, int g, int b,
                int width, int height)
          throws IllegalArgumentException;

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

  void changePos(String shapeID, int fromX, int fromY, int toX, int toY, int startTime,
                 int endTime) throws IllegalArgumentException;

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
   * @throws IllegalArgumentException if the shapeID does not exist in our shapeList (i.e. trying to
   *                                  modify a shape that doesn't exist in the animation)
   */

  void changeColor(String shapeID, int fromR, int fromG, int fromB, int toR, int toG,
                   int toB, int startTime, int endTime) throws IllegalArgumentException;

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

  void changeScale(String shapeID, int fromWidth, int fromHeight,
                   int toWidth, int toHeight, int startTime, int endTime)
          throws IllegalArgumentException;

  /**
   * A method that prints a String describing the current state of the animation.
   *
   * @return a String describing the current state of the animation
   */

  String getState();

  /**
   * Method to return an updated shapes map for each "tick" in an animation.
   *
   * @param tick the time at which to determine the shape's updated attributes
   * @return updated shape map with these new attributes
   */

  Map<String, IShape> getShapesAtTick(int tick);


  /**
   * Getter to return a the current map of shapes in the animation.
   *
   * @return a map of the shapes in the animation
   */

  Map<String, IShape> getShapeList();

  /**
   * Getter to return a the current list of transformation in the animation.
   *
   * @return a list of the transformations in the animation
   */

  List<AbstractTransform> getTransformList();

  /**
   * Method to return the top left X coordinate.
   *
   * @return top left X coordinate
   */

  int getTopLeftX();

  /**
   * Method to return the top left Y coordinate.
   *
   * @return top left Y coordinate
   */

  int getTopLeftY();

  /**
   * Method to return the canvas width.
   *
   * @return canvas width
   */

  int getCanvasWidth();

  /**
   * Method to return the canvas height.
   *
   * @return canvas width
   */

  int getCanvasHeight();


  /**
   * Creates a map: key -- unique ID for shape and value -- string containing the appear/disappear
   * time.
   */

  Map<String, String> getAppearDisappearTime(String filename);


  /**
   * Getter to return a map containing key =  shapeID, value = disappear time of shape from the
   * animation.
   *
   * @return a map containing key =  shapeID, value = disappear time.
   */

  int getDisappearTime();

  /**
   * This method restarts the animation by reverting each shape in the shape list copy to its
   * original attributes.
   */

  void restart();
}

