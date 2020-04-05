package cs5004.animator.view;

/**
 * This is an interface to be implemented by each of our views.
 */

public interface IView {

  /**
   * Makes the view visible.
   */

  void makeVisible();

  /**
   * Sets the position of a given shape in order to be fed to the view.
   *
   * @param x the x coordinate of the shape
   * @param y the y coordinate of the shape
   */

  void setShapePosition(double x, double y);

  /**
   * Writes out description of the animation to given text file name.
   *
   * @param outputFile the name of the file to be populated with animation data
   * @param string the string/content we want to copy in the outputFile
   */

  void output(String outputFile, String string);

  /**
   * Updates the view at each frame of the animation.
   */

  void refreshAnimation();



}
