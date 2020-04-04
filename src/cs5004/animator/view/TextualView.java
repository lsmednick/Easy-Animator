package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.ITransform;

public class TextualView implements IView{
  private AnimatorModel animation;
  private String filename;
  private double speed;

  public TextualView(AnimatorModel animation, String filename, double speed) {
    this.animation = animation;
    this.filename = filename;
    this.speed = speed;
  }

  public String getState() throws IllegalStateException {
    if (animation.getShapeList().isEmpty()) {
      throw new IllegalStateException("There are no shapes in the animation\n");
    }

    StringBuilder string = new StringBuilder();
    for (String key : animation.getShapeList().keySet()) {
      string.append(animation.getShapeList().get(key).toString());
    }

    for (String key : animation.getAppearDisappearTime(filename).keySet()){
      string.append(animation.getAppearDisappearTime(filename).get(key));
    }
    string.append("\n");

    Collections.sort(animation.getTransformList());
    for (ITransform t : animation.getTransformList()) {
      string.append(t.toString());
    }

    System.out.print(string.toString());
    return string.toString().trim();
  }

  @Override
  public void output(String outputFile) {
    System.out.println("Printing text view in the file " + outputFile + "\n");

    try {
      BufferedWriter output;
      if (outputFile.equals("System.out")) {
        output = new BufferedWriter(new OutputStreamWriter(System.out));
      } else {
        File outFile = new File(outputFile);
        output = new BufferedWriter(new FileWriter(outFile));
      }
      output.write(this.getState());
      output.close();
    } catch (IOException iea) {
      System.out.println("Could not find file" + outputFile);
    }
  }

  @Override
  public void makeVisible() {

  }

  @Override
  public void setShapePosition(double x, double y) {

  }

  @Override
  public void refreshAnimation() {

  }
}