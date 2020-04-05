package cs5004.animator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Scanner;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;

import cs5004.animator.view.IView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.VisualView;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilderImpl;


/**
 * This main() method will be the entry point for the program. It will take command-line arguments
 * in the form below : -in "name-of-animation-file" -view "type-of-view" -out "where-output-show-go"
 * -speed "integer-ticks-per-second"
 */

public final class EasyAnimator {
  public static void main(String[] args) throws FileNotFoundException {

    Readable r = new StringReader(String.join(" ", args));
    AnimatorModel model = null;
    Scanner scan = new Scanner(r);
    //String filename = "";
    String viewType = "";
    String output = "";
    double speed = -1;


    // when a string is parsed inFile represents the file to be read
    // command line arg " -in inFile.txt"
    Readable inFile = null;
    String filename = "";

    //TODO
    IView view = null;
    // IAnimationController controller = null;

    while (scan.hasNext()) {
      String input = scan.next();

      //TODO -- change var 'filename', viewType
      switch (input) {
        case "-in": // "name-of-animation-file"
          //if (filename.equals("") && scan.hasNext()) {
          //filename = scan.next();
          if (scan.hasNext()) {
            filename = scan.next();
            inFile = new FileReader(filename);
          }
          break;
        case "-view": // "type-of-view"
          if (viewType.equals("") && scan.hasNext()) {
            viewType = scan.next();
          }
          break;
        case "-out": // "where-output-show-go"
          if (output.equals("") && scan.hasNext()) {
            output = scan.next();
          }
          break;
        case "-speed": // "integer-ticks-per-second"
          if (speed == -1 && scan.hasNext()) {
            speed = Double.parseDouble(scan.next());
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


    //If 'speed' is not indicated by the command-line argument-- then it will default tto
    // speed = 1 tick / per second
    if (speed == -1) {
      speed = 1;
    }

    // if 'out' is not indicated by the command-line argument -- then it defaults to 'System.out'
    if (output.equals("") || output.equals("out")) {
      output = "System.out";
    }

    AnimationReader fileReader = new AnimationReader();
    AnimationBuilder<AnimatorModel> builder =
            new AnimationBuilderImpl();


    try {
      model = AnimationReader.parseFile(inFile, builder);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame,
              "File is Invalid ", "Encountered Error ", JOptionPane.ERROR_MESSAGE);
    }


    //TODO UPDATE:
    // 1. ConcreteClass File names to match what LM and GOC named them
    // 2. UPDATE what each view class takes in as parameters  -- update order if necessary

    try {
      if (viewType.equalsIgnoreCase("svg")) {
        SVGView view1 = new SVGView(model, filename, speed);
        view1.getState();
        view1.output(output, view1.getState());
      } else if (viewType.equalsIgnoreCase("text")) {
        TextualView view2 = new TextualView(model, filename, speed);
        view2.output(output, view2.getState());
      } else if (viewType.equalsIgnoreCase("visual")) {
        assert model != null;
        view = new VisualView(speed, model);
        view.makeVisible();
        view.refreshAnimation();
      } else {
        throw new IllegalArgumentException("Invalid view instantiation");
      }
    } catch (Exception e) {
      System.out.println("first error: " + e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame, "View Type is Invalid ",
              "Encountered Error ", JOptionPane.ERROR_MESSAGE);
    }
  }
}

