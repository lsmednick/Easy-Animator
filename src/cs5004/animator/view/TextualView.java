package cs5004.animator.view;

import cs5004.animator.model.AbstractTransform;
import cs5004.animator.model.AnimatorModelImpl;

public class TextualView {
  private AnimatorModelImpl animation;

  public TextualView(AnimatorModelImpl animation) {
    this.animation = animation;
  }

  public String getState() throws IllegalStateException {
    if (animation.getShapeList().isEmpty()) {
      throw new IllegalStateException("There are no shapes in the animation\n");
    }

    StringBuilder string = new StringBuilder();

    for (String key : animation.getShapeList().keySet()) {
      string.append("Create ");

      // TODO: transform rgb integers into a string (e.g. "blue", "red", "black")
      switch (animation.getShapeList().get(key).getType()) {
        case RECTANGLE:
          // TODO: add color info here
          string.append("rectangle ").append(animation.getShapeList().get(key).getName());
          string.append(" with corner at (").append(animation.getShapeList().get(key).getX());
          string.append(",").append(animation.getShapeList().get(key).getY()).append(") width ");
          string.append(animation.getShapeList().get(key).getWidth()).append(" and height ");
          string.append(animation.getShapeList().get(key).getHeight()).append("\n");
          break;
        case OVAL:
          // TODO: add color info here
          string.append("oval ").append(animation.getShapeList().get(key).getName());
          string.append(" with center at (").append(animation.getShapeList().get(key).getX());
          string.append(",").append(animation.getShapeList().get(key).getY()).append(") radius ");
          string.append(animation.getShapeList().get(key).getWidth()).append(" and ");
          string.append(animation.getShapeList().get(key).getHeight()).append("\n");
          break;
      }
      string.append("\n");
    }

    // TODO: after figuring out the dis/appear times, add info here

    // TODO: figure how to iterate through the list of getTransformList to retrieve info
    for (AbstractTransform t : animation.getTransformList()) {
      switch (animation.getTransformList().get(t).getTransformType()) {
        case MOVE:
          string.append(animation.getTransformList().get(t).getShapeID()).append(" moves from (");
          string.append(animation.getTransformList().get(t).getFromX()).append(",");
          string.append(animation.getTransformList().get(t).getFromY()).append(") to (");
          string.append(animation.getTransformList().get(t).getToX()).append(",");
          string.append(animation.getTransformList().get(t).getToY()).append(") from time t=");
          string.append(animation.getTransformList().get(t).getStartTime()).append(" to t=");
          string.append(animation.getTransformList().get(t).getEndTime()).append("\n");
          break;
        case COLOR:
          string.append(animation.getTransformList().get(t).getShapeID()).append(" changes from ");
          // TODO: add from color info here
          string.append(" to ");
          // TODO: add to color info here
          string.append(" from time t=").append(animation.getTransformList().get(t).getStartTime());
          string.append(" to t=").append(animation.getTransformList().get(t).getEndTime())
          string.append("\n");
          break;
        case SCALE:
          string.append(animation.getTransformList().get(t).getShapeID()).append(" changes ");
          if (animation.getTransformList().get(t).getFromWidth()
                  != animation.getTransformList().get(t).getToWidth()) {
            string.append(" width from ")
            string.append(animation.getTransformList().get(t).getFromWidth());
            string.append(" to ").append(animation.getTransformList().get(t).getToWidth());
            string.append(" and length from ")
            string.append(animation.getTransformList().get(t).getFromLength()).append(" to ");
            string.append(animation.getTransformList().get(t).getToLength());
            string.append(" from time t=");
            string.append(animation.getTransformList().get(t).getStartTime()).append(" to t=");
            string.append(animation.getTransformList().get(t).getEndTime()).append("\n");
          } else if (animation.getTransformList().get(t).getFromWidth()
                  != animation.getTransformList().get(t).getToWidth()) {
            string.append(" width from ");
            string.append(animation.getTransformList().get(t).getFromWidth()).append(" to ");
            string.append(animation.getTransformList().get(t).getToWidth()).append(" from time t=");
            string.append(animation.getTransformList().get(t).getStartTime()).append(" to t=");
            string.append(animation.getTransformList().get(t).getEndTime()).append("\n");
          } else if (animation.getTransformList().get(t).getFromLength()
                  != animation.getTransformList().get(t).getToLength()) {
            string.append(" length from ");
            string.append(animation.getTransformList().get(t).getFromLength()).append(" to ");
            string.append(animation.getTransformList().get(t).getToLength());
            string.append(" from time t=");
            string.append(animation.getTransformList().get(t).getStartTime()).append(" to t=");
            string.append(animation.getTransformList().get(t).getEndTime()).append("\n");
          }
          break;
      }
    }
    return string.toString().trim();
  }
}
