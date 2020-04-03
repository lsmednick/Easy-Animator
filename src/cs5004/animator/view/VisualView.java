package cs5004.animator.view;

import javax.swing.JFrame;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.AnimatorModelImpl;

/**
 * This class represents a visual view of our EasyAnimator.
 */

public class VisualView extends JFrame implements IView {
  private AnimationPanel panel;

  public VisualView(double speed, AnimatorModel model) {
    super();
    this.setTitle("Welcome to Loge, Jenny, and Gerard's project!");
    this.setBounds(model.getTopLeftX(), model.getTopLeftY(), model.getCanvasWidth(),
            model.getCanvasHeight());
  }

  @Override
  public void makeVisible() {
  }

  @Override
  public void setShapePosition(double x, double y) {

  }

  @Override
  public void output(String name) {

  }

  @Override
  public void refreshAnimation() {

  }
}
