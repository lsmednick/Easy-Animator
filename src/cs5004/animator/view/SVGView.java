package cs5004.animator.view;

import java.util.Collections;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.ITransform;

public class SVGView extends AbstractView implements IView {
  private AnimatorModel animation;
  private String filename;
  private double speed;

  public SVGView(AnimatorModel animation, String filename, double speed) {
    this.animation = animation;
    this.filename = filename;
    this.speed = speed;
  }

  public double getSpeed() {
    return this.speed;
  }

  // TODO: figure out what to do with speed
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
      // Copying information about the shape
      string.append(animation.getShapeList().get(key).shapeSVG());

      for (ITransform t : animation.getTransformList()) {
        if (t.getShapeID().equals(animation.getShapeList().get(key).getName())) {
          // Copying information about the shape's motions
          string.append(t.motionSVG());
        }
      }
      string.append(animation.getShapeList().get(key).shapeEndSVG());
    }
    string.append("</svg>");
    return string.toString();
  }

  @Override
  public void makeVisible() {

  }

  @Override
  public void refreshAnimation() {

  }
}