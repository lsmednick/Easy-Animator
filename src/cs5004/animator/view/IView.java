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
   * Updates the view at each frame of the animation.
   */

  void refreshAnimation();
}
