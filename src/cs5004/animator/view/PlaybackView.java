package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.model.AnimatorModel;

public class PlaybackView extends JFrame implements IView, ActionListener {
  private AnimationPanel panel;
  private int speed;
  private int tick = 1;
  private int maxTick;
  private Timer timer;
  private ActionListener a;
  private AnimatorModel model;

  private JButton startButton;
  private JButton pauseButton;
  private JButton restartButton;
  private JButton increaseSpeed;
  private JButton decreaseSpeed;
  private JCheckBoxMenuItem loopButton;


  public PlaybackView(int speed, AnimatorModel model, String filename) {

    // TODO -- Refactor we taken in a visualView object and can add a panel with buttons
    // TODO -- need to refactor Views to be started by Controller
    // TODO -- set up ActionListeners for buttons
    // TODO -- optimize the view of JFrame


    // Copied code from VisualView  to be displayed on  Top Panel
    super();
    a = e -> {
      if (tick < maxTick + 1) {
        panel.refresh(tick);
        tick++;
      }
      if (loopButton.getState() && tick >= maxTick) {
        model.restart();
        tick = 1;
      }
    };
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
    startButton = new JButton("Play");
    startButton.setActionCommand("start");
    startButton.addActionListener(this);

    pauseButton = new JButton("Pause");
    pauseButton.setActionCommand("pause");
    pauseButton.addActionListener(this);

    loopButton = new JCheckBoxMenuItem("Loop");
    loopButton.setState(false);
    loopButton.addActionListener(this);

    restartButton = new JButton("Restart");
    restartButton.setActionCommand("restart");
    restartButton.addActionListener(this);

    increaseSpeed = new JButton("Increase Speed");
    increaseSpeed.setActionCommand("increase");
    increaseSpeed.addActionListener(this);

    decreaseSpeed = new JButton("Decrease Speed");
    decreaseSpeed.setActionCommand("decrease");
    decreaseSpeed.addActionListener(this);

    // Initialize parameters of JFrame
    setPreferredSize(new Dimension(model.getCanvasWidth()+5, model.getCanvasHeight() + 115));
    getContentPane().setLayout(new GridLayout());
    getContentPane().add(splitPane);

    // Configure the split panes.
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

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void animate() {
    timer = new Timer((1000 / speed), a);
    timer.start();
  }

  @Override
  public void output(String outputFile, String string) {

  }

  @Override
  public AnimationPanel getPanel() {
    return this.panel;
  }

  @Override
  public String getViewType() {
    return "playback";
  }

  @Override
  public String getViewState() {
    return null;
  }

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
        speed -= 20;
        timer.setDelay((1000 / speed));
        break;
      case "restart":
        model.restart();
        tick = 1;
    }
  }

 @Override
  public Timer getTimer() {
    return this.timer;
  }

  @Override
  public int getTempo(){
    return this.speed;
  }

}
