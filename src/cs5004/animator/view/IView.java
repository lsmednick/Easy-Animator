package cs5004.animator.view;

import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This is an interface to be implemented by each of our views. The primary goal of this interface
 * is to encapsulate all types of views, despite the fact that certain views may not utilize
 * certain methods of the interface.
 */

public interface IView {

  /**
   * Method to make the view visible.
   */

  void makeVisible();

  void animate();

  /**
   * Outputs the view in a txt/svg file.
   *
   * @param outputFile the output file.
   * @param string the output originated in the view and copied to the outputFile.
   */

  void output(String outputFile, String string);

  /**
   * Method to return the AnimationPanel object in either the visual or interactive views. Throws
   * an UnsupportedOperationException if used with an unsupported view.
   *
   * @return AnimationPanel being used with view
   */

  AnimationPanel getPanel();

  /**
   * Method to return a view's type.
   *
   * @return type of a given view
   */

  String getViewType();

  String getViewState();

  /**
   * Method to return the Timer.
   *
   * @return the Timer.
   */

  Timer getTimer();

  /**
   * A method to return the speed of an animation.
   *
   * @return the speed of an animation
   */

  int getTempo();
}
