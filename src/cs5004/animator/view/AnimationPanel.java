package cs5004.animator.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;

import javax.swing.*;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.IShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;

public class AnimationPanel extends JPanel {
  private AnimatorModel model;
  private Map<String, IShape> shapeMap;

  public AnimationPanel(AnimatorModel m) {
    super();
    this.model = m;
    this.shapeMap = m.getShapeList();
    this.setBackground(new Color(255, 255, 255));
  }

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

  public void refresh(int tick) {
    shapeMap = model.getShapesAtTick(tick);
    this.repaint();
  }

}
