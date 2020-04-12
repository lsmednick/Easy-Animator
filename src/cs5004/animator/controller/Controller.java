package cs5004.animator.controller;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.view.IView;

public class Controller implements IController {
  private AnimatorModel model;
  private IView view;
  private String output;

  public Controller(AnimatorModel model, IView view, int speed) {
    this.model = model;
    this.view = view;
  }

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


