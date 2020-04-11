package cs5004.animator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.Timer;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.view.IView;
import cs5004.animator.view.InteractiveView;

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
    if (view.getViewType().equalsIgnoreCase("visual")) {
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
    } else if (view.getViewType().equalsIgnoreCase("text")) {
      view.output(output, view.getViewState());
    } else if (view.getViewType().equalsIgnoreCase("svg")) {
      view.output(output, view.getViewState());
    } else if (view.getViewType().equalsIgnoreCase("playback")) {
      model.getAppearDisappearTime(view.getFileName());
      view.makeVisible();
      ActionListener a = d -> {
        if (tick < model.getDisappearTime() + 1) {
          view.getPanel().refresh(tick);
          tick++;
        }
      };
      Timer timer = new Timer((1000 / speed), a);
      view.addListeners(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          switch (e.getActionCommand()) {
            case "start":
              timer.start();
              break;
            case "pause":
              timer.stop();
              break;
            case "increase":

          }
        }
      });
    }

  }

}

