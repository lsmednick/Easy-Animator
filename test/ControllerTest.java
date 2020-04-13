import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JButton;

import cs5004.animator.EasyAnimator;
import cs5004.animator.controller.Controller;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.VisualView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This is a JUnit test suite to evaluate if the Controller is correctly coordinating
 * the Model and View to create a animation (VisualView and PlayBack view) or produce a text based
 * representation of our animation (TextualView and SVGView).
 */

public class ControllerTest {
  AnimatorModel model;
  String filename;

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
  public void testControllerPlayBack()  {
    model.getAppearDisappearTime(filename);

    // Create View
    PlaybackView view = new PlaybackView(1, model);

    // Create Controller and start animation
    Controller c = new Controller(model, view);
    c.start();

    // Test the animation is visible
    assertTrue(view.isVisible());

    // Test if the Animation is Running when we signal 'play' to action listener
    JButton playButton = new JButton("play");
    ActionEvent e = new ActionEvent(playButton, 1, "PLAY");
    view.actionPerformed(e);
    assertTrue(view.getTimer().isRunning());


  }

  // Test if the Controller can play a VisualView animation
  @Test
  public void testControllerVisual() {
    model.getAppearDisappearTime(filename);

    // Create View
    VisualView view = new VisualView(1, model);

    // Create Controller and start animation
    Controller c = new Controller(model, view);
    c.start();

    // Test if Controller was able to call on makeVisible and animate methods in VisualView
    // to play the animation
    assertTrue(view.isVisible());
    assertTrue(view.getTimer().isRunning());

  }

  // Test that the controller is able to create an output for TextualView
  @Test
  public void testControllerTextual() throws FileNotFoundException {
    EasyAnimator.main(new String[]{"-in toh-3.txt -view text -out textualView_transcript.txt"});

    BufferedReader bufferedReader;
    try {
      bufferedReader = new BufferedReader(new FileReader("textualView_transcript.txt"));
      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();

      while (line != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
        line = bufferedReader.readLine();
      }
      assertEquals("Name: disk1\n"
                      + "Type: Rectangle\n"
                      + "Min corner: (190, 180), Width: 20, Height: 30, Color: (0, 49, 90)\n"
                      + "\n"
                      + "Name: disk2\n"
                      + "Type: Rectangle\n"
                      + "Min corner: (167, 210), Width: 65, Height: 30, Color: (6, 247, 41)\n"
                      + "\n"
                      + "Name: disk3\n"
                      + "Type: Rectangle\n"
                      + "Min corner: (145, 240), Width: 110, Height: 30, Color: (11, 45, 175)\n"
                      + "\n"
                      + "disk1 appears at time t=1 and disappears at t=302\n"
                      + "disk2 appears at time t=1 and disappears at t=302\n"
                      + "disk3 appears at time t=1 and disappears at t=302\n"
                      + "\n"
                      + "Text view is running at 1.0 ticks per second\n"
                      + "\n"
                      + "Shape disk1 moves from (190,180) to (190,180) from t=1 to t=1\n"
                      + "Shape disk1 moves from (190,180) to (190,180) from t=1 to t=25\n"
                      + "Shape disk2 moves from (167,210) to (167,210) from t=1 to t=1\n"
                      + "Shape disk2 moves from (167,210) to (167,210) from t=1 to t=57\n"
                      + "Shape disk3 moves from (145,240) to (145,240) from t=1 to t=1\n"
                      + "Shape disk3 moves from (145,240) to (145,240) from t=1 to t=121\n"
                      + "Shape disk1 moves from (190,180) to (190,50) from t=25 to t=35\n"
                      + "Shape disk1 moves from (190,50) to (190,50) from t=35 to t=36\n"
                      + "Shape disk1 moves from (190,50) to (490,50) from t=36 to t=46\n"
                      + "Shape disk1 moves from (490,50) to (490,50) from t=46 to t=47\n"
                      + "Shape disk1 moves from (490,50) to (490,240) from t=47 to t=57\n"
                      + "Shape disk1 moves from (490,240) to (490,240) from t=57 to t=89\n"
                      + "Shape disk2 moves from (167,210) to (167,50) from t=57 to t=67\n"
                      + "Shape disk2 moves from (167,50) to (167,50) from t=67 to t=68\n"
                      + "Shape disk2 moves from (167,50) to (317,50) from t=68 to t=78\n"
                      + "Shape disk2 moves from (317,50) to (317,50) from t=78 to t=79\n"
                      + "Shape disk2 moves from (317,50) to (317,240) from t=79 to t=89\n"
                      + "Shape disk1 moves from (490,240) to (490,50) from t=89 to t=99\n"
                      + "Shape disk2 moves from (317,240) to (317,240) from t=89 to t=185\n"
                      + "Shape disk1 moves from (490,50) to (490,50) from t=99 to t=100\n"
                      + "Shape disk1 moves from (490,50) to (340,50) from t=100 to t=110\n"
                      + "Shape disk1 moves from (340,50) to (340,50) from t=110 to t=111\n"
                      + "Shape disk1 moves from (340,50) to (340,210) from t=111 to t=121\n"
                      + "Shape disk1 moves from (340,210) to (340,210) from t=121 to t=153\n"
                      + "Shape disk3 moves from (145,240) to (145,50) from t=121 to t=131\n"
                      + "Shape disk3 moves from (145,50) to (145,50) from t=131 to t=132\n"
                      + "Shape disk3 moves from (145,50) to (445,50) from t=132 to t=142\n"
                      + "Shape disk3 moves from (445,50) to (445,50) from t=142 to t=143\n"
                      + "Shape disk3 moves from (445,50) to (445,240) from t=143 to t=153\n"
                      + "Shape disk1 moves from (340,210) to (340,50) from t=153 to t=163\n"
                      + "Shape disk3 changes color from (11,45,175) to (0,255,0) "
                      + "from t=153 to t=161\n"
                      + "Shape disk3 moves from (445,240) to (445,240) from t=161 to t=302\n"
                      + "Shape disk1 moves from (340,50) to (340,50) from t=163 to t=164\n"
                      + "Shape disk1 moves from (340,50) to (190,50) from t=164 to t=174\n"
                      + "Shape disk1 moves from (190,50) to (190,50) from t=174 to t=175\n"
                      + "Shape disk1 moves from (190,50) to (190,240) from t=175 to t=185\n"
                      + "Shape disk1 moves from (190,240) to (190,240) from t=185 to t=217\n"
                      + "Shape disk2 moves from (317,240) to (317,50) from t=185 to t=195\n"
                      + "Shape disk2 moves from (317,50) to (317,50) from t=195 to t=196\n"
                      + "Shape disk2 moves from (317,50) to (467,50) from t=196 to t=206\n"
                      + "Shape disk2 moves from (467,50) to (467,50) from t=206 to t=207\n"
                      + "Shape disk2 moves from (467,50) to (467,210) from t=207 to t=217\n"
                      + "Shape disk1 moves from (190,240) to (190,50) from t=217 to t=227\n"
                      + "Shape disk2 changes color from (6,247,41) to (0,255,0) from "
                      + "t=217 to t=225\n"
                      + "Shape disk2 moves from (467,210) to (467,210) from t=225 to t=302\n"
                      + "Shape disk1 moves from (190,50) to (190,50) from t=227 to t=228\n"
                      + "Shape disk1 moves from (190,50) to (490,50) from t=228 to t=238\n"
                      + "Shape disk1 moves from (490,50) to (490,50) from t=238 to t=239\n"
                      + "Shape disk1 moves from (490,50) to (490,180) from t=239 to t=249\n"
                      + "Shape disk1 changes color from (0,49,90) to (0,255,0) from "
                      + "t=249 to t=257\n"
                      + "Shape disk1 moves from (490,180) to (490,180) from t=257 to t=302\n",
              stringBuilder.toString());
      bufferedReader.close();
    } catch (Exception e) {
      // do nothing
    }
  }


  // Test that the Controller can create an output for SVGView
  @Test
  public void testControllerSVG() throws FileNotFoundException {
    EasyAnimator.main(new String[]{"-in toh-3.txt -view svg -out svgTextOutput.txt -speed 20"});

    BufferedReader bufferedReader;
    try {
      bufferedReader = new BufferedReader(new FileReader("svgTextOutput.txt"));
      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();

      while (line != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
        line = bufferedReader.readLine();
      }
      assertEquals("<svg width=\"410\" height=\"220\" viewBox=\"145 50 555 270\" "
              + "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
              + "<rect id=\"disk1\" x=\"190\" y=\"180\" width=\"20\" height=\"30\" "
              + "fill=\"rgb(0,49,90)\" >\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"0.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"0.0ms\" "
              + "attributeName=\"y\" from=\"180.0\" to=\"180.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"1200.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"1200.0ms\" "
              + "attributeName=\"y\" from=\"180.0\" to=\"180.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1250.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1250.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"180.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1750.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1750.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1800.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1800.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2300.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2300.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2350.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2350.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2850.0ms\" dur=\"1600.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2850.0ms\" dur=\"1600.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4450.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4450.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4950.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4950.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5000.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5000.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5500.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5500.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5550.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5550.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6050.0ms\" dur=\"1600.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6050.0ms\" dur=\"1600.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7650.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7650.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8150.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8150.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8200.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8200.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8700.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8700.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8750.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8750.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9250.0ms\" dur=\"1600.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9250.0ms\" dur=\"1600.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10850.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10850.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11350.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11350.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11400.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11400.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11900.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11900.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11950.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11950.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"180.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"CSS\" begin=\"12450.0ms\" dur=\"400.0ms\" "
              + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,255,0)\" fill=\"freeze\" "
              + "/>\n"
              + "<animate attributeType=\"xml\" begin=\"12850.0ms\" dur=\"2250.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"12850.0ms\" dur=\"2250.0ms\" "
              + "attributeName=\"y\" from=\"180.0\" to=\"180.0\" fill=\"freeze\" />\n"
              + "</rect>\n"
              + "<rect id=\"disk2\" x=\"167\" y=\"210\" width=\"65\" height=\"30\" "
              + "fill=\"rgb(6,247,41)\" >\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"0.0ms\" "
              + "attributeName=\"x\" from=\"167.0\" to=\"167.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"0.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"2800.0ms\" "
              + "attributeName=\"x\" from=\"167.0\" to=\"167.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"2800.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2850.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"167.0\" to=\"167.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2850.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3350.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"167.0\" to=\"167.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3350.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3400.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"167.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3400.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3900.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3900.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3950.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3950.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4450.0ms\" dur=\"4800.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4450.0ms\" dur=\"4800.0ms\""
              + " attributeName=\"y\" from=\"240.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9250.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9250.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9750.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9750.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9800.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"467.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9800.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10300.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"467.0\" to=\"467.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10300.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10350.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"467.0\" to=\"467.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10350.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"CSS\" begin=\"10850.0ms\" dur=\"400.0ms\" "
              + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(0,255,0)\" fill=\"freeze\" "
              + "/>\n"
              + "<animate attributeType=\"xml\" begin=\"11250.0ms\" dur=\"3850.0ms\" "
              + "attributeName=\"x\" from=\"467.0\" to=\"467.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11250.0ms\" dur=\"3850.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "</rect>\n"
              + "<rect id=\"disk3\" x=\"145\" y=\"240\" width=\"110\" height=\"30\" "
              + "fill=\"rgb(11,45,175)\" >\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"0.0ms\" "
              + "attributeName=\"x\" from=\"145.0\" to=\"145.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"0.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"6000.0ms\" "
              + "attributeName=\"x\" from=\"145.0\" to=\"145.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"50.0ms\" dur=\"6000.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6050.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"145.0\" to=\"145.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6050.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6550.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"145.0\" to=\"145.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6550.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6600.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"145.0\" to=\"445.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6600.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7100.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"x\" from=\"445.0\" to=\"445.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7100.0ms\" dur=\"50.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7150.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"445.0\" to=\"445.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7150.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"CSS\" begin=\"7650.0ms\" dur=\"400.0000000000009ms\" "
              + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(0,255,0)\" fill=\"freeze\""
              + " />\n"
              + "<animate attributeType=\"xml\" begin=\"8050.000000000001ms\" dur=\""
              + "7049.999999999999ms\" attributeName=\"x\" from=\"445.0\" to=\"445.0\" fill=\""
              + "freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8050.000000000001ms\" dur=\""
              + "7049.999999999999ms\" attributeName=\"y\" from=\"240.0\" to=\"240.0\" fill=\""
              + "freeze\" />\n"
              + "</rect>\n"
              + "</svg>\n", stringBuilder.toString());
      bufferedReader.close();
    } catch (Exception e) {
      // do nothing
    }
  }


}







