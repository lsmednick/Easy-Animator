package cs5004.animator.view;

import java.util.Collections;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.ITransform;

public class TextualView extends AbstractView implements IView {
  private AnimatorModel animation;
  private String filename;
  private double speed;

  // TODO: figure what to do with speed
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

    return string.toString().trim();
  }

  @Override
  public void makeVisible() {

  }

  @Override
  public void refreshAnimation() {

  }
}