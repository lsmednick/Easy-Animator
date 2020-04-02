package cs5004.animator;

import java.io.StringReader;
import java.util.Scanner;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.controller.IAnimationController;
import cs3500.animator.controller.InteractiveController;
import cs3500.animator.controller.SVGController;
import cs3500.animator.controller.TextController;
import cs3500.animator.controller.VisualController;
import cs3500.animator.model.IAnimationModel;
import cs3500.animator.model.SimpleAnimationModel;
import cs3500.animator.model.Utils;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs3500.animator.starter.TweenModelBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilderImpl;


/**
 * Entry point into the program and runs the animation.
 */
public class Main {

  public static void main(String[] args) {

    Readable r = new StringReader(String.join(" ", args));
    AnimatorModel model = null;
    Scanner scan = new Scanner(r);
    String filename = "";
    String viewType = "";
    String output = "";
    double speed = -1;

    //TODO
    IView view = null;
    // IAnimationController controller = null;

    // TODO -- Rename 'in'
    while (scan.hasNext()) {
      String in = scan.next();

      //TODO -- change var 'filename', viewType
      switch (in) {
        case "-in" : // "name-of-animation-file"
          if (filename.equals("") && scan.hasNext()) {
          filename = scan.next();
          }
          break;
        case "-view" : // "type-of-view"
          if (viewType.equals("") && scan.hasNext()) {
            viewType = scan.next();
          }
          break;
        case "-out" : // "where-output-show-go"
          if (output.equals("") && scan.hasNext()) {
            output = scan.next();
          }
          break;
        case "-speed" : // "integer-ticks-per-second"
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

    if (speed == -1) {
      speed = 1;
    }
    if (output.equals("") || output.equals("out")) {
      output = "System.out";
    }

    AnimationReader fileReader = new AnimationReader();
    AnimationBuilder<AnimatorModel> simpleBuilder =
            new AnimationBuilderImpl();


    try {
      model = fileReader.parseFile(filename, simpleBuilder);
    } catch (Exception e) {
      //System.out.println(e.getMessage());
      JFrame frame = new JFrame();
      frame.setSize(100, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JOptionPane.showMessageDialog(frame,
              "Invalid file", "Error", JOptionPane.ERROR_MESSAGE);
    }








  }



  }

}
