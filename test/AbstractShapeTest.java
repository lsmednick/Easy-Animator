import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractShapeTest {

  @Test
  public void testToStringOval() {
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    assertEquals("Name: Carlos\n"
            + "Type: Oval\n"
            + "Center: (5.0, 5.0), X radius: 4.5, Y radius: 7.7, Color: (24, 56, 215)\n"
            + "Appears at t=0\n"
            + "Disappears at t=10\n\n", hi.toString());
  }

  @Test
  public void testToStringRectangle() {
    AbstractShape hi = new Rectangle(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    assertEquals("Name: Carlos\n"
            + "Type: Rectangle\n"
            + "Min corner: (5.0, 5.0), Width: 4.5, Height: 7.7, Color: (24, 56, 215)\n"
            + "Appears at t=0\n"
            + "Disappears at t=10\n\n", hi.toString());
  }

  @Test
  public void testToStringTriangle() {
    AbstractShape hi = new Triangle(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    assertEquals("Name: Carlos\n"
            + "Type: Triangle\n"
            + "Min corner: (5.0, 5.0), Width: 4.5, Height: 7.7, Color: (24, 56, 215)\n"
            + "Appears at t=0\n"
            + "Disappears at t=10\n\n", hi.toString());
  }


  @Test
  public void testGetState(){
    AnimatorModelImpl model = new AnimatorModelImpl();
    model.addShape("Carlos", ShapeType.RECTANGLE, 1,2,3,4,5,6,7,0,10);

    model.changePos("Carlos",1,2,3,4, 5, 6);

    assertEquals("Shapes:\n"
            + "Name: Carlos\n"
            + "Type: Rectangle\n"
            + "Min corner: (1.0, 2.0), Width: 6.0, Height: 7.0, Color: (3, 4, 5)\n"
            + "Appears at t=0\n"
            + "Disappears at t=10\n"
            + "\n"
            + "Shape Carlos moves from (1.0,2.0) to (3.0,4.0) from t=5 to t=6\n", model.getState());
  }


  // TODO -- DELETE all Setters tests?
  @Test
  public void testSetters(){
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");

    hi.setCoordinates(10,10);
    hi.setColor(34,55,91);
    hi.setScaling(2,2);

    assertEquals("Name: Carlos\n"
            + "Type: Oval\n"
            + "Center: (10.0, 10.0), X radius: 9.0, Y radius: 15.4, Color: (34, 55, 91)\n"
            + "Appears at t=0\n"
            + "Disappears at t=10\n\n", hi.toString());
  }


  //Exception is thrown if coordinates are negative numbers
  @Test (expected = IllegalArgumentException.class)
  public void testInValidSetterCoordinates(){
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    hi.setCoordinates(-1,-1);
  }

  //Exception is thrown if color value is not within range of 0 - 255
  @Test (expected = IllegalArgumentException.class)
  public void testInValidSetterColor(){
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    hi.setColor(-1,-1, -1);
  }

  //Exception is throw if color value is not within range of 0 - 255
  @Test (expected = IllegalArgumentException.class)
  public void testInValidSetterColor2(){
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    hi.setColor(256,256, 256);
  }

  //Exception is throw if color value is not within range of 0 - 255
  @Test (expected = IllegalArgumentException.class)
  public void testInValidSetterScaling(){
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    hi.setScaling(-1,-1);
  }








  }

