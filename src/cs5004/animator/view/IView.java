package cs5004.animator.view;

import javax.swing.Timer;

/**
 * This is an interface to be implemented by each of our views. The primary goal of this interface
 * is to encapsulate all types of views, despite the fact that certain views may not utilize
 * certain methods of the interface.
 */

public interface IView {

  /**
   * Method to make the view visible. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  void makeVisible();

  /**
   * Method to play the animation with the specified tempo. Throws an UnsupportedOperationException
   * if used with an unsupported view.
   *
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  void animate();

  /**
   * Outputs the view in a txt/svg file. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @param outputFile the output file.
   * @param string the output originated in the view and copied to the outputFile.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  void output(String outputFile, String string);

  /**
   * Method to return the AnimationPanel object in either the visual or interactive views. Throws
   * an UnsupportedOperationException if used with an unsupported view.
   *
   * @return AnimationPanel being used with view
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  AnimationPanel getPanel();

  /**
   * Method to return a view's type. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return type of a given view
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  String getViewType();

  /**
   * Method to return the state of the view. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return a string with the view state.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  String getViewState();

  /**
   * Method to return the Timer. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return the Timer.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  Timer getTimer();

  /**
   * A method to return the speed of an animation. Throws an UnsupportedOperationException if used
   * with an unsupported view.
   *
   * @return the speed of an animation
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  int getTempo();
}
