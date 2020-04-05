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
