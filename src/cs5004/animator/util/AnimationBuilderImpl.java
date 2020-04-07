package cs5004.animator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ShapeType;

/**
 * This class represents the implementation of the AnimationBuilder interface. This class is used
 * with AnimationReader in order to correctly populate the contents of a text file into an
 * AnimationModel. This is necessary to successfully run an animation utilizing text document data.
 */

public class AnimationBuilderImpl implements AnimationBuilder<AnimatorModel> {
  private AnimatorModel m;
  private Map<String, String> map;
  private List<String> list;

  /**
   * Method to construct an AnimationBuilder object. The constructor creates a hash map and array
   * list in order to store data to be implemented into the animation model.
   */

  public AnimationBuilderImpl() {
    this.map = new HashMap();
    this.list = new ArrayList<>();
  }

  /**
   * Constructs a final document.
   *
   * @return the newly constructed document
   */

  @Override
  public AnimatorModel build() {
    return m;
  }

  /**
   * Specify the bounding box to be used for the animation.
   *
   * @param x      The leftmost x value
   * @param y      The topmost y value
   * @param width  The width of the bounding box
   * @param height The height of the bounding box
   * @return This {@link AnimationBuilder}
   */

  @Override
  public AnimationBuilder<AnimatorModel> setBounds(int x, int y, int width, int height) {
    this.m = new AnimatorModelImpl(x, y, width, height);
    return this;
  }

  /**
   * Adds a new shape to the growing document.
   *
   * @param name The unique name of the shape to be added. No shape with this name should already
   *             exist.
   * @param type The type of shape (e.g. "ellipse", "rectangle") to be added. The set of supported
   *             shapes is unspecified, but should include "ellipse" and "rectangle" as a minimum.
   * @return This {@link AnimationBuilder}
   */

  @Override
  public AnimationBuilder<AnimatorModel> declareShape(String name, String type) {
    map.put(name, type);
    return this;
  }

  /**
   * Adds a transformation to the growing document.
   *
   * @param name The name of the shape (added with {@link AnimationBuilder#declareShape})
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   * @return This {@link AnimationBuilder}
   */

  @Override
  public AnimationBuilder<AnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
                                                   int h1, int r1, int g1, int b1, int t2, int x2,
                                                   int y2, int w2, int h2, int r2, int g2, int b2) {

    if (!list.contains(name)) {
      if (map.get(name).equalsIgnoreCase("ELLIPSE")) {
        m.addShape(name, ShapeType.OVAL, x1, y1, r1, g1, b1, w1, h1);
        list.add(name);
      } else if (map.get(name).equalsIgnoreCase("RECTANGLE")) {
        m.addShape(name, ShapeType.RECTANGLE, x1, y1, r1, g1, b1, w1, h1);
        list.add(name);
      } else {
        throw new IllegalArgumentException("Shape is invalid\n");
      }
    }

    if (x1 != x2 || y1 != y2) {
      m.changePos(name, x1, y1, x2, y2, t1, t2);
    }
    if (r1 != r2 || g1 != g2 || b1 != b2) {
      m.changeColor(name, r1, g1, b1, r2, g2, b2, t1, t2);
    }
    if (w1 != w2 || h1 != h2) {
      m.changeScale(name, w1, h1, w2, h2, t1, t2);
    }
    if (x1 == x2 && y1 == y2 && r1 == r2 && g1 == g2 && b1 == b2 && w1 == w2 && h1 == h2) {
      m.changePos(name, x1, y1, x2, y2, t1, t2);
    }
    return this;
  }

}
