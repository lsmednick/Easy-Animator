package cs5004.animator.controller;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.view.IView;

/**
 * This controller class implements the controller interface, it contains attributes such as the
 * animation controller, the view and the output as well as two constructors and the implementation
 * of the start method to begin the animation.
 */

public class Controller implements IController {
  private AnimatorModel model;
  private IView view;
  private String output;

  /**
   * This constructor initializes the controller with a model, and a view.
   *
   * @param model the animation model.
   * @param view the type of view.
   */

  public Controller(AnimatorModel model, IView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * This constructor initializes the controller with a model, a view, and an output.
   *
   * @param model th animation model.
   * @param view the type of view.
   * @param output the output of the animation.
   */

  public Controller(AnimatorModel model, IView view, String output) {
    this.model = model;
    this.view = view;
    this.output = output;
  }

  /**
   * Method to start the animation. A different process is executed depending on the view's type.
   * Both visual views call upon their makeVisible and animate methods which set the views to
   * visible and proceed with the animation process. Both the textual and SVG views call upon
   * their output methods in order to properly display a given animation in text / SVG format.
   */

  @Override
  public void start() {
    if (view.getViewType().equalsIgnoreCase("visual")) {
      view.makeVisible();
      view.animate();
    } else if (view.getViewType().equalsIgnoreCase("text")) {
      view.output(output, view.getViewState());
    } else if (view.getViewType().equalsIgnoreCase("svg")) {
      view.output(output, view.getViewState());
    } else if (view.getViewType().equalsIgnoreCase("playback")) {
      view.makeVisible();
      view.animate();
    }
  }
}


