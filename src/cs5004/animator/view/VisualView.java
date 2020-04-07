package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import cs5004.animator.model.AnimatorModel;

/**
 * This class represents a visual view of our EasyAnimator. This class extends JFrame in order to
 * display each frame of the animation properly as the AnimationPanel refreshes. This class is able
 * to set the frame's title, size, and close operation. Additionally, this class is able to set its
 * panel's size, and scroll bar policies. This class contains methods in order to make the frame
 * visible and refresh the animation for each tick in a given animation.
 */

public class VisualView extends JFrame implements IView {
  private AnimationPanel panel;
  private int speed;
  private int maxTick;

  /**
   * Method to construct a VisualView object in order to represent an animation frame. The various
   * attributes of the frame are set in this method, and an instance of AnimationPanel is created to
   * add to the frame. Additionally, a scroll bar is implemented in the panel with an "as needed"
   * policy.
   *
   * @param speed the ticks per second the animation is set to run at
   * @param model the current model used to represent the animation
   */

  public VisualView(int speed, AnimatorModel model) {
    super();
    this.speed = speed;
    this.maxTick = model.getDisappearTime();
    this.setTitle("Welcome to Loge, Jenny, and Gerard's project!");
    this.setSize(model.getCanvasWidth(), model.getCanvasHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    panel = new AnimationPanel(model);
    panel.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.add(panel, BorderLayout.CENTER);
    JScrollPane pane = new JScrollPane(panel);
    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.add(pane, BorderLayout.CENTER);
    this.pack();
  }

  /**
   * Method to make the frame visible.
   */

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  /**
   * Method to refresh the animation. This is done in a loop that ends at the last value of the last
   * transformation. The panel's "refresh" method is called for every tick, and then sleeps at
   * whatever rate is inputted at the command line.
   */

  @Override
  public void refreshAnimation() {
    for (int i = 1; i < maxTick + 1; i++) {
      panel.refresh(i);
      try {
        Thread.sleep(1000 / speed);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void output(String outputFile, String string) {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }
}


