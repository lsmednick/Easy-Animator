import java.awt.*;

public class AnimatorModelImpl implements AnimatorModel{



  //TODO how to access the ISHAPE and how to consider timeStart and timeEnd
  @Override
  public void move(IShape shape, double toX, double toY, int moveStartTime, int moveEndTime) throws IllegalArgumentException {
      if (toX < 0) {
        throw new IllegalArgumentException( "can't move to a negative X coordinate");
      }
      if (toY < 0 ) {
        throw new IllegalArgumentException( "can't move to a negative Y coordinate ");
      }

      shape.setCoordinates(toX, toY);

      //TODO -- how to deal with moveStarTime, moveEndTime
  }

  @Override
  public void changeColor(IShape shape, int r, int g, int b) {
    shape.setColor(r,g,b);
  }


  //TODO -- leave this for now
  @Override
  public void changeShape(Shape myShape) {
  }


  @Override
  public void scaling(IShape shape, int scalingHeight, int scalingWidth) {
    shape.setScaling(scalingHeight, scalingWidth);
  }


  //TODo -- leave this for now
  @Override
  public void changeLayer(int layer) {
  }
}
