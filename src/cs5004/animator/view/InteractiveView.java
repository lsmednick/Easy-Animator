package cs5004.animator.view;
import java.awt.*;
import javax.swing.*;
import cs5004.animator.model.AnimatorModel;

public class InteractiveView extends javax.swing.JFrame implements IView {
  IView view;
  private JSplitPane splitPane;  // split the window in top and bottom
  private JPanel topPanel;       // container panel for the top
  private JPanel bottomPanel;    // container panel for the bottom
  private JButton button;         // and a "send" button

  private AnimationPanel panel;
  private int speed;
  private int maxTick;

  public InteractiveView(int speed, AnimatorModel model) {

    // TODO -- Refactor we taken in a visualView object and can add a panel with buttons
    // TODO -- need to refactor Views to be started by Controller
    // TODO -- set up ActionListeners for buttons
    // TODO -- optimize the view of JFrame


    // Copied code from VisualView  to be displayed on  Top Panel
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
//    JScrollPane pane = new JScrollPane(panel);
//    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//    this.add(pane, BorderLayout.CENTER);
    this.pack();

    // Set up Panels to split into a Top Panel (VisualView) and Bottom Panel (buttons)
    this.splitPane = new JSplitPane();
    this.topPanel = panel;         // our top component
    this.bottomPanel = new JPanel();      // our bottom component

    // Create buttons for Bottom Panel
    JButton startButton = new JButton("Start");
    JButton pauseButton = new JButton("Pause");
    JButton resumeButton = new JButton("Resume");
    JButton enableLoopButton = new JButton("Enable Looping");
    JButton disableLoopButton = new JButton("Disable Looping");
    JButton increaseSpeed = new JButton("Increase Speed");
    JButton decreaseSpeed = new JButton("Decrease Speed");

    // TODO -- Figure out we don't need 'setPerferredSize'
    // Initialize parameters of JFrame
    setPreferredSize(new Dimension(model.getCanvasWidth(), model.getCanvasWidth()));
    getContentPane().setLayout(new GridLayout());
    getContentPane().add(splitPane);

    // TODO -- figure out of we can optimize the Divder location
    // Configure the split panes.
    splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  // we want it to split the window vertically
    splitPane.setDividerLocation(300);                    // the initial position of the divider is 200 (our window is 400 pixels high)
    splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
    splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel"


    // Configure layout of the bottom panel which contains our buttons.
    GridBagConstraints c = new GridBagConstraints();
    bottomPanel.add(startButton, c);
    bottomPanel.add(pauseButton, c);
    bottomPanel.add(resumeButton, c);
    bottomPanel.add(enableLoopButton, c);
    bottomPanel.add(disableLoopButton, c);
    bottomPanel.add(increaseSpeed, c);
    bottomPanel.add(decreaseSpeed, c);


    // calling pack() at the end, will ensure that every layout and size we just defined gets applied before the stuff becomes visible
    this.pack();

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
    return null;
  }

  @Override
  public String getViewType() {
    return "playback";
  }

  @Override
  public String getFileName() {
    return null;
  }

  @Override
  public String getViewState() {
    return null;
  }
}

