package cs5004.animator.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import cs5004.animator.model.AnimatorModel;

public class InteractiveView extends JFrame implements IView {
  private AnimationPanel panel;
  private String filename;
  private JButton startButton;
  private JButton pauseButton;

  public InteractiveView(int speed, AnimatorModel model, String filename) {

    // TODO -- Refactor we taken in a visualView object and can add a panel with buttons
    // TODO -- need to refactor Views to be started by Controller
    // TODO -- set up ActionListeners for buttons
    // TODO -- optimize the view of JFrame

    // Copied code from VisualView  to be displayed on  Top Panel
    super();
    this.filename = filename;
    int maxTick = model.getDisappearTime();
    this.setTitle("Welcome to Loge, Jenny, and Gerard's project!");
    this.setSize(model.getCanvasWidth(), model.getCanvasHeight());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    panel = new AnimationPanel(model);
    panel.setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()));
    this.add(panel, BorderLayout.CENTER);
    this.pack();

    // Set up Panels to split into a Top Panel (VisualView) and Bottom Panel (buttons)
    // split the window in top and bottom
    JSplitPane splitPane = new JSplitPane();
    // container panel for the top
    JPanel topPanel = panel;
    // container panel for the bottom
    JPanel bottomPanel = new JPanel();

    // Create buttons for Bottom Panel
    startButton = new JButton("Start");
    startButton.setActionCommand("start");

    pauseButton = new JButton("Pause");
    pauseButton.setActionCommand("pause");

    JButton enableLoopButton = new JButton("Enable Looping");
    JButton disableLoopButton = new JButton("Disable Looping");
    JButton increaseSpeed = new JButton("Increase Speed");
    increaseSpeed.addNotify();
    JButton decreaseSpeed = new JButton("Decrease Speed");

    // Initialize parameters of JFrame
    setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasHeight()+115));
    getContentPane().setLayout(new GridLayout());
    getContentPane().add(splitPane);

    // Configure the split panes.
    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
    splitPane.setDividerLocation(model.getCanvasHeight()+10);
    splitPane.setTopComponent(topPanel);
    splitPane.setBottomComponent(bottomPanel);


    // Configure layout of the bottom panel which contains our buttons.
    GridBagConstraints c = new GridBagConstraints();
    bottomPanel.add(startButton, c);
    bottomPanel.add(pauseButton, c);
    bottomPanel.add(enableLoopButton, c);
    bottomPanel.add(disableLoopButton, c);
    bottomPanel.add(increaseSpeed, c);
    bottomPanel.add(decreaseSpeed, c);

    this.pack();

  }

  @Override
  public void addListeners(ActionListener e) {
    startButton.addActionListener(e);
    pauseButton.addActionListener(e);

  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
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
  public String getFileName() {
    return filename;
  }

  @Override
  public String getViewState() {
    return null;
  }
}

