package cs5004.animator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import cs5004.animator.model.AnimatorModel;

/**
 * This interactive view extends the JFrame class and implements the methods in the view interface
 * as well as the action listener. This view has attributes such as an animation panel, the speed,
 * the timer, a loop, an action listener, the max number of ticks, the number of ticks as well as
 * different JButtons and a checkbox menu item.
 */

public class PlaybackView extends JFrame implements IView, ActionListener {
  private AnimationPanel panel;
  private int speed;
  private int tick = 1;
  private int maxTick;
  private Timer timer;
  private ActionListener actionListener;
  private AnimatorModel model;
  private JCheckBoxMenuItem loopButton;

  /**
   * Constructs a PlaybackView object in order to interact with a given animation. This view sets up
   * an action listener to be used in later methods, as well as sets the parameters for the panel
   * and frame. It creates multiple JButtons in order to control the displayed animation as well.
   *
   * @param speed speed of the animation
   * @param model the AnimationModel being used
   */

  public PlaybackView(int speed, AnimatorModel model) {
    super();

    // Set up action listener to be used with the animate method
    this.actionListener = e -> {
      if (tick < maxTick + 1) {
        panel.refresh(tick);
        tick++;
      }
      if (loopButton.getState() && tick >= maxTick) {
        model.restart();
        tick = 1;
      }
    };

    // Set up other attributes and initialize the panel.
    this.model = model;
    this.speed = speed;
    this.maxTick = model.getDisappearTime();
    this.setTitle("Welcome to Loge, Jenny, and Gerard's project!");
    this.setSize(model.getCanvasWidth(), model.getCanvasHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    panel = new AnimationPanel(model);
    panel.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.add(panel, BorderLayout.CENTER);
    this.pack();

    // Set up Panels to split into a Top Panel (VisualView) and Bottom Panel (buttons)
    JSplitPane splitPane = new JSplitPane();
    JPanel topPanel = panel;
    JPanel bottomPanel = new JPanel();

    // Create buttons for Bottom Panel
    JButton startButton = new JButton("Play");
    startButton.setActionCommand("start");
    startButton.addActionListener(this);

    JButton pauseButton = new JButton("Pause");
    pauseButton.setActionCommand("pause");
    pauseButton.addActionListener(this);

    loopButton = new JCheckBoxMenuItem("Loop");
    loopButton.setState(false);
    loopButton.addActionListener(this);

    JButton restartButton = new JButton("Restart");
    restartButton.setActionCommand("restart");
    restartButton.addActionListener(this);

    JButton increaseSpeed = new JButton("Increase Speed");
    increaseSpeed.setActionCommand("increase");
    increaseSpeed.addActionListener(this);

    JButton decreaseSpeed = new JButton("Decrease Speed");
    decreaseSpeed.setActionCommand("decrease");
    decreaseSpeed.addActionListener(this);

    // Configure the split panes.
    getContentPane().setLayout(new GridLayout());
    getContentPane().add(splitPane);
    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
    splitPane.setDividerLocation(model.getCanvasHeight() + 10);
    splitPane.setTopComponent(topPanel);
    splitPane.setBottomComponent(bottomPanel);

    // Configure layout of the bottom panel which contains our buttons.
    GridBagConstraints c = new GridBagConstraints();
    bottomPanel.add(startButton, c);
    bottomPanel.add(pauseButton, c);
    bottomPanel.add(loopButton, c);
    bottomPanel.add(restartButton, c);
    bottomPanel.add(increaseSpeed, c);
    bottomPanel.add(decreaseSpeed, c);

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
    timer = new Timer((1000 / speed), actionListener);
    timer.start();
  }

  /**
   * Outputs the view in a txt/svg file. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @param outputFile the output file.
   * @param string     the output originated in the view and copied to the outputFile.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public void output(String outputFile, String string) {
    throw new UnsupportedOperationException("This method is not implemented in the playback view");
  }

  /**
   * Method to return the AnimationPanel object in either the visual or interactive views. Throws an
   * UnsupportedOperationException if used with an unsupported view.
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
    return "playback";
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
    throw new UnsupportedOperationException("This method is not implemented in the playback view");
  }

  /**
   * Method to set what action is performed based on the given action command. When the "start"
   * button is pressed, the timer will start and the animation will play. The "pause" button stops
   * the timer and pauses the animation. The "increase" and "decrease" buttons adds / subtracts 20
   * to the given speed and sets the timer delay to this new amount. The "restart" button restarts
   * the timer and plays the animation from the beginning.
   *
   * @param e the action listener which interacts with each command
   */

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
        speed += 20;
        timer.setDelay((1000 / speed));
        break;
      case "decrease":
        if (speed - 20 > 0) {
          speed -= 20;
          timer.setDelay((1000 / speed));
        }
        break;
      case "restart":
        model.restart();
        tick = 1;
        timer.start();
        break;
      default:
        // do nothing
    }
  }

  /**
   * Method to return the Timer. Throws an UnsupportedOperationException if used with an unsupported
   * view.
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

  /**
   * Method to return the loop button of the view to be used for testing purposes only.
   *
   * @return loop button of the view
   */

  public JCheckBoxMenuItem getLoopButton() {
    return this.loopButton;
  }

}
