package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.Timer;

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
   * Outputs the view in a txt/svg file. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @param outputFile the output file.
   * @param string the output originated in the view and copied to the outputFile.
   * @throws UnsupportedOperationException when used with an unsupported view.
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

  /**
   * Method to make the view visible. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public void makeVisible() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("This method is not implemented in the text view");
  }

  /**
   * Method to play the animation with the specified tempo. Throws an UnsupportedOperationException
   * if used with an unsupported view.
   *
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public void animate() {
    throw new UnsupportedOperationException("This method is not implemented in the text view");
  }

  /**
   * Method to return the AnimationPanel object in either the visual or interactive views. Throws
   * an UnsupportedOperationException if used with an unsupported view.
   *
   * @return AnimationPanel being used with view
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public AnimationPanel getPanel() {
    throw new UnsupportedOperationException("This method is not implemented in the text view");
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
    return "text";
  }

  /**
   * Method to return the Timer. Throws an UnsupportedOperationException if used with an
   * unsupported view.
   *
   * @return the Timer.
   * @throws UnsupportedOperationException when used with an unsupported view.
   */

  @Override
  public Timer getTimer() {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
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
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }
}