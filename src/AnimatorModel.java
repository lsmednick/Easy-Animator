// Loge and Jenny love to code!

import java.awt.*;

/**
 * TODO -- Interface for the Easy Animator Application.
 * This supports an abstract class that that will define 2D shapes that are used for animation.
 *
 */
public interface AnimatorModel {

  /**
   * Method to move shape.
   * @param toX the X coordinate we're moving the shape To
   * @param toY the Y coordinate we're moving the shape To
   * @IllegalArgumentException throws if the parameters are outside of the spec
   */
   void move(double toX, double toY) throws IllegalArgumentException;

   //TODO -- define the size of our 'display

  /**
   * Create a object that stores that values for RBG which will change the color of our Shape.
   * @param myColor is the color we're trying to apply to our Shape
   */
  void changeColor(Color myColor);

  /**
   * Change the shape of our current Shape.
   * @param myShape is the new shape we're changing the current Shape to
   */
  void changeShape (Shape myShape);

  /**
   * This method will scale the current shape.
   * @param scalingLength scales the length by a given integer
   * @param scalingWidth scales the width by a given interger
   */
  //TODO figure out SCALING
  void scaling (int scalingLength, int scalingWidth);


  /**
   * This method will change the different layers of the animation.
   */
  void changeLayer (int layer);
  //TODO -- think about using a linked list for the layers -- so that if a layer needs to be
  // inserted between other layers the number assignment for each layer will change
  // -- get pushed down

  //TODO -- consider when shapes should appear and disappear


}