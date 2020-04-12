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
   * This constructor initializes the controller with a model, a view and a speed.
   *
   * @param model the animation model.
   * @param view the type of view.
   * @param speed the tempo of the animation.
   */

  public Controller(AnimatorModel model, IView view, int speed) {
    this.model = model;
    this.view = view;
  }

  /**
   * This constructor initializes the controller with a model, a view, a speed and an output
   *
   * @param model th animation model.
   * @param view the type of view.
   * @param speed the tempo of the animation.
   * @param output the ouput of the animation.
   */

  public Controller(AnimatorModel model, IView view, int speed, String output) {
    this.model = model;
    this.view = view;
    this.output = output;
  }

  /**
   * Method to start the animation. This is done in a loop that ends at the last value of the last
   * transformation. The panel's "refresh" method is called for every tick, and then sleeps at
   * whatever rate is inputted at the command line.
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


