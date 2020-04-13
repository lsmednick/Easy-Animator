package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
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
  private int tick = 1;
  private int maxTick;
  private Timer timer;

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
   * Method to make the view visible. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  /**
   * Method to play the animation with the specified tempo. Throws an UnsupportedOperationException
   * if used with an unsupported view.
   *
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public void animate() {
    ActionListener a = e -> {
      if (tick < maxTick + 1) {
        panel.refresh(tick);
        tick++;
      }
    };
    timer = new Timer((1000 / speed), a);
    timer.start();
  }

  /**
   * Outputs the view in a txt/svg file. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @param outputFile the output file.
   * @param string the output originated in the view and copied to the outputFile.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public void output(String outputFile, String string) {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }

  /**
   * Method to return the AnimationPanel object in either the visual or interactive views. Throws
   * an UnsupportedOperationException if used with an unsupported view.
   *
   * @return AnimationPanel being used with view
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public AnimationPanel getPanel() {
    return this.panel;
  }

  /**
   * Method to return a view's type. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return type of a given view
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public String getViewType() {
    return "visual";
  }

  /**
   * Method to return the state of the view. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return a string with the view state.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public String getViewState() {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }

  /**
   * Method to return the Timer. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return the Timer.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public Timer getTimer() {
    return this.timer;
  }

  /**
   * A method to return the speed of an animation. Throws an UnsupportedOperationException if used
   * with an unsupported view.
   *
   * @return the speed of an animation
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public int getTempo() {
    return this.speed;
  }

}


