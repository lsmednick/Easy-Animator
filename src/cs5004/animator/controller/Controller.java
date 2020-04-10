package cs5004.animator.controller;

import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.Timer;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.view.IView;

public class Controller implements IController {
  private AnimatorModel model;
  private IView view;
  private int speed;
  private int tick = 1;
  private String output;

  public Controller(AnimatorModel model, IView view, int speed) {
    this.model = model;
    this.view = view;
    this.speed = speed;
  }

  public Controller(AnimatorModel model, IView view, int speed, String output) {
    this.model = model;
    this.view = view;
    this.speed = speed;
    this.output = output;
  }

  /**
   * Method to start the animation. This is done in a loop that ends at the last value of the last
   * transformation. The panel's "refresh" method is called for every tick, and then sleeps at
   * whatever rate is inputted at the command line.
   */

  @Override
  public void start() {
    switch (view.getViewType()) {
      case "visual":
        model.getAppearDisappearTime(view.getFileName());
        view.makeVisible();
        ActionListener a = e -> {
          if (tick < model.getDisappearTime() + 1) {
            view.getPanel().refresh(tick);
            tick++;
          }
        };
        Timer timer = new Timer((1000 / speed), a);
        timer.start();
      case "text":
        view.output(output, view.getViewState());
      case "svg":
        view.output(output, view.getViewState());
      case "playback":
    }
  }

}
