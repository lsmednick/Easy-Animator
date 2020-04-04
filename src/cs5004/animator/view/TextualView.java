package cs5004.animator.view;

import java.util.Collections;

import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ITransform;

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
      string.append(animation.getShapeList().get(key).toString());
    }

    Collections.sort(animation.getTransformList());
    for (ITransform t : animation.getTransformList()) {
      string.append(t.toString());
    }

    return string.toString();
  }
}

    /*
    for (String key : animation.getShapeList().keySet()) {
      string.append("Create ");

      switch (animation.getShapeList().get(key).getType()) {
        case RECTANGLE:
          string.append("rectangle ").append(animation.getShapeList().get(key).getName());
          string.append(" with corner at (").append(animation.getShapeList().get(key).getX());
          string.append(",").append(animation.getShapeList().get(key).getY()).append(") width ");
          string.append(animation.getShapeList().get(key).getWidth()).append(" and height ");
          string.append(animation.getShapeList().get(key).getHeight()).append("\n");
          break;
        case OVAL:
          string.append("oval ").append(animation.getShapeList().get(key).getName());
          string.append(" with center at (").append(animation.getShapeList().get(key).getX());
          string.append(",").append(animation.getShapeList().get(key).getY()).append(") radius ");
          string.append(animation.getShapeList().get(key).getWidth()).append(" and ");
          string.append(animation.getShapeList().get(key).getHeight()).append("\n");
          break;
      }
      string.append("\n");
    }

    for (AbstractTransform t : animation.getTransformList()) {
      switch (t.getTransformType()) {
        case MOVE:
          string.append(t.getShapeID()).append(" moves from (");
          string.append(t.getFromX()).append(",");
          string.append(t.getFromY()).append(") to (");
          string.append(t.getToX()).append(",");
          string.append(t.getToY()).append(") from time t=");
          string.append(t.getStartTime()).append(" to t=");
          string.append(t.getEndTime()).append("\n");
          break;
        case COLOR:
          string.append(t.getShapeID()).append(" changes from ");
          // TODO: add from color info here
          string.append(" to ");
          // TODO: add to color info here
          string.append(" from time t=").append(t.getStartTime());
          string.append(" to t=").append(t.getEndTime());
          string.append("\n");
          break;
        case SCALE:
          string.append(t.getShapeID()).append(" changes ");
          if (t.getFromWidth() != t.getToWidth()) {
            string.append(" width from ");
            string.append(t.getFromWidth());
            string.append(" to ").append(t.getToWidth());
            string.append(" and length from ");
            string.append(t.getFromLength()).append(" to ");
            string.append(t.getToLength());
            string.append(" from time t=");
            string.append(t.getStartTime()).append(" to t=");
            string.append(t.getEndTime()).append("\n");
          } else if (t.getFromWidth() != t.getToWidth()) {
            string.append(" width from ");
            string.append(t.getFromWidth()).append(" to ");
            string.append(t.getToWidth()).append(" from time t=");
            string.append(t.getStartTime()).append(" to t=");
            string.append(t.getEndTime()).append("\n");
          } else if (t.getFromLength() != t.getToLength()) {
            string.append(" length from ");
            string.append(t.getFromLength()).append(" to ");
            string.append(t.getToLength());
            string.append(" from time t=");
            string.append(t.getStartTime()).append(" to t=");
            string.append(t.getEndTime()).append("\n");
          }
          break;
      }
    }
    return string.toString().trim();
  }
     */
