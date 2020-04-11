package cs5004.animator.view;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.AbstractTransform;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.IShape;
import cs5004.animator.model.ITransform;

/**
 * This class represents a textual view of our EasyAnimator. The output of the Textual view is a
 * string that describes the animation including the shapes' attributes and transformations. The
 * output can be produced in a .txt file or to System.out -- depending on the command line
 * argument.
 */

public class TextualView implements IView {
  private AnimatorModel animation;
  private String filename;
  private double speed;

  /**
   * Constructs the text view initializing an animation model, the name of the file where we are
   * getting the input and the speed/tempo of the text view.
   *
   * @param animation the animation model.
   * @param filename  the input file.
   * @param speed     the tempo of the animation.
   */

  public TextualView(AnimatorModel animation, String filename, double speed) {
    this.animation = animation;
    this.filename = filename;
    this.speed = speed;
  }

  /**
   * This method implements the text view. Using a string builder it appends all the shapes and its
   * motions and finally return a string with the final result.
   *
   * @return a string with the result of the text view.
   * @throws IllegalStateException if there are no shapes in the text view/animation.
   */

  public String getViewState() throws IllegalStateException {
    if (animation.getShapeList().isEmpty()) {
      throw new IllegalStateException("There are no shapes in the animation\n");
    }

    StringBuilder string = new StringBuilder();

    Map<String, IShape> map = animation.getShapeList();
    List<AbstractTransform> abstractList = animation.getTransformList();
    Map<String, String> timing = animation.getAppearDisappearTime(filename);

    Collections.sort(animation.getTransformList());

    for (String key : map.keySet()) {
      string.append(map.get(key).toString());
    }

    for (String key : timing.keySet()) {
      string.append(timing.get(key));
    }
    string.append("\n");

    string.append("Text view is running at ").append(speed).append(" ticks per second\n\n");

    for (ITransform t : abstractList) {
      string.append(t.toString());
    }

    return string.toString().trim();
  }

  /**
   * This method is used by both the text and the SVG view to output its result in a file. The
   * method creates a txt or svg file and also catches an IOException if no output file fails.
   */

  public void output(String outputFile, String string) {
    System.out.println("Printing text view in the file " + outputFile + "\n");

    try {
      BufferedWriter output;
      if (outputFile.equals("System.out")) {
        output = new BufferedWriter(new OutputStreamWriter(System.out));
      } else {
        File outFile = new File(outputFile);
        output = new BufferedWriter(new FileWriter(outFile));
      }
      output.write(string);
      output.close();
    } catch (IOException iea) {
      System.out.println("Output file " + outputFile + " failed");
    }
  }

  @Override
  public void makeVisible() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This method is not implemented in the text view");
  }

  @Override
  public void animate() {

  }

  @Override
  public AnimationPanel getPanel() {
    throw new UnsupportedOperationException("This method is not implemented in the text view");
  }

  @Override
  public String getViewType() {
    return "text";
  }

}