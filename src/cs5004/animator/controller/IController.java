package cs5004.animator.controller;

/**
 * This is a public interface representing our controller for the Easy Animation program. This
 * interface contains the start method which will execute a different process depending on the view
 * type in order to properly display the animation.
 */

public interface IController {

  /**
   * Method to start the animation. A different process is executed depending on the view's type.
   * Both visual views call upon their makeVisible and animate methods which set the views to
   * visible and proceed with the animation process. Both the textual and SVG views call upon
   * their output methods in order to properly display a given animation in text / SVG format.
   */

  void start();
}
