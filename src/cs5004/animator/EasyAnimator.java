package cs5004.animator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.controller.Controller;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;

import cs5004.animator.view.IView;
import cs5004.animator.view.PlaybackView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.VisualView;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilderImpl;

/**
 * This main() method will be the entry point for the program. It will take command-line arguments
 * in the form below : -in "name-of-animation-file" -view "type-of-view" -out "where-output-show-go"
 * -speed "integer-ticks-per-second". The arguments are parse and implemented into the animation.
 */

public final class EasyAnimator {

  /**
   * This is the main method which is the entry point for our program.
   *
   * @param args takes in string arguments into the main
   * @throws FileNotFoundException is thrown if the program can not find the files specified in the
   *                               arguments
   */

  public static void main(String[] args) throws FileNotFoundException {
    Readable r = new StringReader(String.join(" ", args));
    AnimatorModel model = null;
    IView view = null;
    Scanner scan = new Scanner(r);
    String viewType = "";
    String output = "";
    int speed = -1;
    Readable inFile = null;
    String filename = "";


    // Parse the command line.
    while (scan.hasNext()) {
      String input = scan.next();

      switch (input) {
        case "-in":
          if (scan.hasNext()) {
            filename = scan.next();
            inFile = new FileReader(filename);
          }
          break;
        case "-view":
          if (viewType.equals("") && scan.hasNext()) {
            viewType = scan.next();
          }
          break;
        case "-out":
          if (output.equals("") && scan.hasNext()) {
            output = scan.next();
          }
          break;
        case "-speed":
          if (speed == -1 && scan.hasNext()) {
            speed = Integer.parseInt(scan.next());
          }
          break;
        default:
          JFrame frame = new JFrame();
          frame.setSize(100, 100);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JOptionPane.showMessageDialog(frame, "Invalid input",
                  "Error", JOptionPane.ERROR_MESSAGE);
      }
    }

    // If 'speed' is not indicated by the command-line argument-- then it will default tto
    // speed = 1 tick / per second
    if (speed == -1) {
      speed = 1;
    }

    // If 'out' is not indicated by the command-line argument -- then it defaults to 'System.out'
    if (output.equals("") || output.equals("out")) {
      output = "System.out";
    }

    // Initialize a new animation builder.
    AnimationReader fileReader = new AnimationReader();
    AnimationBuilder<AnimatorModel> builder =
            new AnimationBuilderImpl();

    // Parse through files twice in order to initialize model and set its appear / disappear time.
    try {
      model = AnimationReader.parseFile(inFile, builder);
      model.getAppearDisappearTime(filename);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame,
              "An error was encounter while parsing the file",
              "Encountered Error", JOptionPane.ERROR_MESSAGE);
    }

    // Initialize a view.
    try {
      if (viewType.equalsIgnoreCase("svg")) {
        view = new SVGView(model, filename, speed);
        Controller c = new Controller(model, view, output);
        c.start();
      } else if (viewType.equalsIgnoreCase("text")) {
        view = new TextualView(model, filename, speed);
        Controller c = new Controller(model, view, output);
        c.start();
      } else if (viewType.equalsIgnoreCase("visual")) {
        assert model != null;
        view = new VisualView(speed, model);
        Controller c = new Controller(model, view);
        c.start();
      } else if (viewType.equalsIgnoreCase("playback")) {
        assert model != null;
        view = new PlaybackView(speed, model);
        Controller c = new Controller(model, view);
        c.start();
      } else {
        throw new IllegalArgumentException("Invalid view instantiation");
      }
    } catch (Exception e) {
      System.out.println("Error" + e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, "An Error was Encountered in View ",
              "Encountered Error ", JOptionPane.ERROR_MESSAGE);
    }
  }
}


