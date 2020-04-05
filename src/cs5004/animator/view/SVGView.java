package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.ITransform;
import cs5004.animator.model.ShapeType;

public class SVGView implements IView {
  private AnimatorModel animation;
  private String filename;
  private double speed;

  // TODO: figure what to do with speed
  public SVGView(AnimatorModel animation, String filename, double speed) {
    this.animation = animation;
    this.filename = filename;
    this.speed = speed;
  }

  public String getState() throws IllegalStateException {
    if (animation.getShapeList().isEmpty()) {
      throw new IllegalStateException("There are no shapes in the animation\n");
    }

    StringBuilder string = new StringBuilder();

    // Setting width and height of the canvas
    string.append("<svg width=\"").append(animation.getCanvasWidth()).append("\" height=\"")
            .append(animation.getCanvasHeight())
            .append("\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n");

    Collections.sort(animation.getTransformList());

    // Creating the entire SVG file
    for (String key : animation.getShapeList().keySet()) {
      if (animation.getShapeList().get(key).getType() == ShapeType.RECTANGLE) {
        string.append("<rect id=\"").append(animation.getShapeList().get(key).getName())
                .append("\" x=\"").append(animation.getShapeList().get(key).getX())
                .append("\" y =\"").append(animation.getShapeList().get(key).getY())
                .append("\" width=\"").append(animation.getShapeList().get(key).getWidth())
                .append("\" height=\"").append(animation.getShapeList().get(key).getHeight())
                .append("\" fill=\"rgb(").append(animation.getShapeList().get(key).getR())
                .append(",").append(animation.getShapeList().get(key).getG()).append(",")
                .append(animation.getShapeList().get(key).getB())
                .append(")\" visibility=\"visible\" >\n");

        for (ITransform t : animation.getTransformList()) {
          if (t.getShapeID().equals(animation.getShapeList().get(key).getName())) {
            switch (t.getTransformType()) {
              case MOVE:
                string.append("<animate attributeType=\"xml\" begin=\"").append(t.getStartTime())
                        .append("s\" dur=\"").append(t.getEndTime() - t.getStartTime())
                        .append("s\" attributeName=\"\n");
                // TODO: get access to attribute (eg. cx/cy/x/y) and timing of motion

              case COLOR:
                string.append("<animate attributeType=\"CSS\" begin=\"").append(t.getStartTime())
                        .append("s\" dur=\"").append(t.getEndTime() - t.getStartTime())
                        .append("s\" attributeName=\"fill\" from=\"rgb(\n");
                // TODO: figure out how to use rgb values for colors

              case SCALE:


            }
          }
        }
        string.append("</rect>\n");
      } else {
        string.append("<ellipse id=\"").append(animation.getShapeList().get(key).getName())
                .append("\" cx=\"").append(animation.getShapeList().get(key).getX())
                .append("\" cy =\"").append(animation.getShapeList().get(key).getY())
                .append("\" rx=\"").append(animation.getShapeList().get(key).getWidth())
                .append("\" ry=\"").append(animation.getShapeList().get(key).getHeight())
                .append("\" fill=\"rgb(").append(animation.getShapeList().get(key).getR())
                .append(",").append(animation.getShapeList().get(key).getG()).append(",")
                .append(animation.getShapeList().get(key).getB())
                .append(")\" visibility=\"visible\" >\n");

        // TODO: copy-paste the previous loop here (more the for loop in a private funct)
        string.append("</ellipse>\n");
      }
    }

    string.append("</svg>");
    return string.toString().trim();
  }


  // TODO: create an abstract class and move this method there (delete in textualview)
  @Override
  public void output(String outputFile) {
    System.out.println("Printing SVG view in the file " + outputFile + "\n");

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