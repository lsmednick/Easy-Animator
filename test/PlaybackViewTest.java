import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;

import cs5004.animator.controller.Controller;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is a JUnit Test Suite for the concrete class PlaybackView.
 * It confirms if the GUI within this class is able to be conduct the correct implementations
 * when the client interacts with the GUI. This is done by confirming the ActionListeners are called
 * when the GUI (JButton) components are activated.
 */

public class PlaybackViewTest {
  AnimatorModel model;
  String filename;

  //TODO -- TEST LOOPs

  @Before
  public void init() throws FileNotFoundException {
    // Read-in a file for testing
    filename = "toh-3.txt";
    Readable inFile = new FileReader(filename);

    // Create Model
    AnimationBuilder<AnimatorModel> builder =
            new AnimationBuilderImpl();
    model = AnimationReader.parseFile(inFile, builder);
  }

  // Test if the Controller method start() animate a PlayBackView
  @Test
  public void testControllerPlayBack() {
    model.getAppearDisappearTime(filename);

    // Create View
    PlaybackView view = new PlaybackView(1, model, filename);

    // Create Controller and start animation
    Controller c = new Controller(model, view, 1);
    c.start();

    // Test the animation is visible
    assertTrue(view.isVisible());


    // Test if the Animation is Running when we signal 'play' to ActionListener
    JButton playButton = new JButton("play");
    ActionEvent e = new ActionEvent(playButton, 1, "PLAY");
    view.actionPerformed(e);
    assertTrue(view.getTimer().isRunning());

    // Test if the Animation is Paused when we signal 'pause' to ActionListener
    JButton pauseButton = new JButton("pause");
    ActionEvent e2 = new ActionEvent(pauseButton, 1, "pause");
    view.actionPerformed(e2);
    assertFalse(view.getTimer().isRunning());

    // Test if the Animation is Restarted when we signal 'restart' to ActionListener
    JButton restartButton = new JButton("restart");
    ActionEvent e3 = new ActionEvent(restartButton, 1, "restart");
    view.actionPerformed(e3);
    assertFalse ( view.getTimer().isRunning());

    // Test if the Animation tempo is Increased when we signal 'increase' to ActionListener
    // Increase is set to default '20', increase ticks per second by 20
    JButton increaseButton = new JButton("increase");
    ActionEvent e4 = new ActionEvent(increaseButton, 1, "increase");
    view.actionPerformed(e4);
    assertEquals(21, view.getTempo());

    // Test if the Animation tempo is Decreased when we signal 'decrease' to ActionListener
    // Increase is set to default '20', increase ticks per second by 20
    JButton decreaseButton = new JButton("decrease");
    ActionEvent e5 = new ActionEvent(decreaseButton, 1, "decrease");
    view.actionPerformed(e5);
    assertEquals(1, view.getTempo());


  }

}