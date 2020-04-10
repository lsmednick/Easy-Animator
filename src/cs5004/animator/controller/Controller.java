package cs5004.animator.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.VisualView;

public class Controller implements IController {
  private AnimatorModel model;
  private IView view;
  private int speed;
  private int tick = 1;

  public Controller(AnimatorModel model, IView view, int speed) {
    this.model = model;
    this.view = view;
    this.speed = speed;
  }

  /**
   * Method to start the animation. This is done in a loop that ends at the last value of the last
   * transformation. The panel's "refresh" method is called for every tick, and then sleeps at
   * whatever rate is inputted at the command line.
   */

  @Override
  public void startAnimation() {
    switch (view.getViewType()) {
      case "visual":
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
      case "svg":
      case "playback":
    }
  }

}
