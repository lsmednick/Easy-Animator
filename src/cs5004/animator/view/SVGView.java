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

import javax.swing.*;

import cs5004.animator.model.AbstractTransform;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.IShape;
import cs5004.animator.model.ITransform;

/**
 * This class represents a SVG view of the animation. It produces either an .svg file or an output
 * to System.out -- this is determined by the command line argument received by the main() in the
 * EasyAnimator class.
 */

public class SVGView implements IView {
  private AnimatorModel animation;
  private int speed;

  /**
   * Constructs the SVG view initializing an animation model, the name of the file where we are
   * getting the input and the speed/tempo of the SVG view.
   *
   * @param animation the animation model.
   * @param filename  the input file.
   * @param speed     the tempo of the animation.
   */

  public SVGView(AnimatorModel animation, String filename, int speed) {
    this.animation = animation;
    this.speed = speed;
  }

  /**
   * Gets the speed/tempo of the SVG animation.
   *
   * @return the tempo of the SVG view.
   */
  @Override
  public int getTempo() {
    return this.speed;
  }

  /**
   * This method implements the SVG view. Using a string builder it appends all the shapes and its
   * motions and finally return a string with the final result.
   *
   * @return a string with the result of the SVG view.
   * @throws IllegalStateException if there are no shapes in the text view/animation.
   */

  public String getViewState() throws IllegalStateException {
    if (animation.getShapeList().isEmpty()) {
      throw new IllegalStateException("There are no shapes in the animation\n");
    }

    StringBuilder string = new StringBuilder();

    // Setting width and height of the canvas
    int viewBoxWidth = (animation.getTopLeftX() + animation.getCanvasWidth());
    int viewBoxHeight = (animation.getTopLeftY() + animation.getCanvasHeight());

    string.append("<svg width=\"").append(animation.getCanvasWidth()).append("\" height=\"")
            .append(animation.getCanvasHeight()).append("\" viewBox=\"")
            .append(animation.getTopLeftX()).append(" ").append(animation.getTopLeftY())
            .append(" ").append(viewBoxWidth).append(" ").append(viewBoxHeight)
            .append("\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n");


    Map<String, IShape> map = animation.getShapeList();
    List<AbstractTransform> abstractList = animation.getTransformList();

    Collections.sort(abstractList);

    // Creating the entire SVG file
    for (String key : map.keySet()) {
      // Copying information about the shape
      string.append(map.get(key).shapeSVG());

      for (ITransform t : abstractList) {
        if (t.getShapeID().equals(map.get(key).getName())) {
          // Copying information about the shape's motions
          string.append(t.motionSVG(this.speed));
        }
      }
      string.append(map.get(key).shapeEndSVG());
    }
    string.append("</svg>");
    return string.toString();
  }

  /**
   * This method is used by both the text and the SVG view to output its result in a file. The
   * method creates a txt or svg file and also catches an IOException if no output file fails.
   */

  public void output(String outputFile, String string) {
    System.out.println("Printing SVG view in the file " + outputFile + "\n");

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
  public void makeVisible() {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }

  @Override
  public void animate() {

  }

  @Override
  public AnimationPanel getPanel() {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }

  @Override
  public String getViewType() {
    return "svg";
  }

  @Override
  public Timer getTimer() {
    throw new UnsupportedOperationException("This method is not implemented in the SVG view");
  }


}
