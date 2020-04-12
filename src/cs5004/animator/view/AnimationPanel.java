package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;

import javax.swing.JPanel;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;

/**
 * This class represents an animation panel to be included in our VisualView class. This panel takes
 * in the animator model in order to call the appropriate "getter" functions are retrieve necessary
 * data. This panel is able to retrieve a map of shapes, paint those shapes, and repaint them
 * repeatedly for each "tick" in a given animation.
 */

public class AnimationPanel extends JPanel {
  private AnimatorModel model;
  private Map<String, IShape> shapeMap;

  /**
   * Method to construct an AnimationPanel object. It takes in a model m in order to retrieve the
   * current map of shapes. Additionally, the constructor sets up a white background for the
   * animation to be displayed on.
   *
   * @param m the current animation model
   */

  public AnimationPanel(AnimatorModel m) {
    super();
    this.model = m;
    this.shapeMap = m.getShapeList();
    this.setBackground(new Color(255, 255, 255));
  }

  /**
   * Method to paint the contents of the shape map onto the animation panel. This is done by looping
   * through the map and drawing either an oval or rectangle according to its specified x / y
   * coordinates, width, and height.
   *
   * @param g graphics object to draw onto animation panel
   */

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    for (IShape shape : shapeMap.values()) {
      g2d.setColor(new Color(shape.getR(), shape.getG(), shape.getB()));
      if (shape instanceof Oval) {
        g2d.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        g2d.drawOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
      } else if (shape instanceof Rectangle) {
        g2d.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
        g2d.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
      }
    }
  }

  /**
   * Method to refresh the map of shapes in order to display each from of the animation properly.
   * The getShapesAtTick method in the model is called upon in order to obtain each updated map,
   * while repaint redraws the shapes to the animation panel.
   *
   * @param tick the current time of the animation
   */

  public void refresh(int tick) {
    shapeMap = model.getShapesAtTick(tick);
    this.repaint();
  }
}
