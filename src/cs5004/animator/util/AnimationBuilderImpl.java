package cs5004.animator.util;

import java.util.HashMap;
import java.util.Map;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ShapeType;

public class AnimationBuilderImpl implements AnimationBuilder<AnimatorModel> {
  private AnimatorModel m = new AnimatorModelImpl();
  private Map<String, String> map = new HashMap();

  @Override
  public AnimatorModel build() {
    return m;
  }

  @Override
  public AnimationBuilder<AnimatorModel> setBounds(int x, int y, int width, int height) {
    return null;
  }

  @Override
  public AnimationBuilder<AnimatorModel> declareShape(String name, String type) {
    map.put(name, type);
    return null;
  }

  @Override
  public AnimationBuilder<AnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
                                                   int h1, int r1, int g1, int b1, int t2, int x2,
                                                   int y2, int w2, int h2, int r2, int g2, int b2) {
    if (!map.containsKey(name)){
      switch (map.get(name).toUpperCase()) {
        case "OVAL":
          m.addShape(name, ShapeType.OVAL, x1, y1, r1, g1, b1, w1, h1, t1, t2);
          break;
        case "RECTANGLE":
          m.addShape(name, ShapeType.RECTANGLE, x1, y1, r1, g1, b1, w1, h1, t1, t2);
          break;
        case "TRIANGLE":
          m.addShape(name, ShapeType.TRIANGLE, x1, y1, r1, g1, b1, w1, h1, t1, t2);
          break;
      }
    }

    if (x1 != x2 || y1 != y2){
      m.changePos(name, x1, y1, x2, y2, t1, t2);
    } else if (r1 != r2 || g1 != g2 || b1 != b2) {
      m.changeColor(name, r1, g1, b1, r2, g2, b2, t1, t2);
    } else if (w1 != w2 || h1 != h2) {
      m.changeScale(name, w1, h1, w2, h2, t1, t2);
    } else {
      m.changePos(name, x1, y1, x2, y2, t1, t2);;
    }
    return this;
  }
}
