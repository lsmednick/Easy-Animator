package cs5004.animator.view;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.AbstractTransform;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.IShape;
import cs5004.animator.model.ITransform;

/**
 * This class represents a SVG view of the animation. It produces either an .svg file or an output
 * to System.out -- this is determined by the command line argument received by the
 * main() in the EasyAnimator class.
 */

public class SVGView extends AbstractView implements IView {
  private AnimatorModel animation;
  private String filename;
  private double speed;
  private int maxTick;

  public SVGView(AnimatorModel animation, String filename, double speed) {
    this.speed = speed;
    animation.getAppearDisappearTime(filename);
    this.maxTick = animation.getDisappearTime();
    this.animation = animation;
    this.filename = filename;
  }

  public double getSpeed() {
    return this.speed;
  }

  public String getState() throws IllegalStateException {
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

  @Override
  public void makeVisible() {

  }

  @Override
  public void refreshAnimation() {

  }
}
