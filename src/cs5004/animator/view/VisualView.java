package cs5004.animator.view;

import java.awt.*;

import javax.swing.*;

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
    //this.setSize(model.getCanvasWidth(), model.getCanvasHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    panel = new AnimationPanel(model);
    panel.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.add(panel, BorderLayout.CENTER);
    //JScrollPane pane = new JScrollPane(panel);
    this.pack();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void setShapePosition(double x, double y) {

  }

  @Override
  public void output(String outputFile, String string) {

  }

  @Override
  public void refreshAnimation() {
    for (int i = 1; i < 491; i++) {
      panel.refresh(i);
      try {
        Thread.sleep(1000/2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
