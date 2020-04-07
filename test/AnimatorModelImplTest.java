import org.junit.Test;

import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ShapeType;

import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test class for the cs5004.animator.model.AnimatorModelImpl class. Every method of
 * the model is tested by checking the string representation of the added shapes / transformations
 * to ensure they are displaying the correct information.
 */

public class AnimatorModelImplTest {
  AnimatorModelImpl testModel;

  // Testing the addShape method by adding one of each shape type to the model. Testing getState
  // in this method as well.
  @Test
  public void testAddShape1() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Judi Dench", ShapeType.OVAL, 50, 35, 45, 164, 100, 7, 3);
    testModel.addShape("Jason Derulo", ShapeType.OVAL, 5, 10, 104, 69, 4, 10, 10);
    testModel.addShape("Taylor Swift", ShapeType.RECTANGLE, 10, 3, 70, 250, 18, 7, 6);
    assertEquals("Shapes:\n"
            + "Name: Judi Dench\n"
            + "Type: Oval\n"
            + "Center: (50, 35), X radius: 7, Y radius: 3, Color: (45, 164, 100)\n"
            + "\n"
            + "Name: Jason Derulo\n"
            + "Type: Oval\n"
            + "Center: (5, 10), X radius: 10, Y radius: 10, Color: (104, 69, 4)\n"
            + "\n"
            + "Name: Taylor Swift\n"
            + "Type: Rectangle\n"
            + "Min corner: (10, 3), Width: 7, Height: 6, Color: (70, 250, 18)\n\n",
            testModel.getState());
  }

  // Testing the addShape method when entering invalid height value.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape4() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Jennifer Hudson", ShapeType.RECTANGLE, 5, 6, 107, 16, 10, 4, -1);
  }

  // Testing the addShape method when entering invalid width value.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape5() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Jennifer Hudson", ShapeType.RECTANGLE, 5, 6, 107, 16, 10, -4, 0);
  }

  // Testing the addShape method when entering a null string ID.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape6() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape(null, ShapeType.RECTANGLE, 5, 6, 107, 16, 10, 7, 8);
  }

  // Testing the changePos method by transforming one of each shape.
  @Test
  public void testChangePos1() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Ian McKellen", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3);
    testModel.addShape("Rebel Wilson", ShapeType.RECTANGLE, 5, 10, 109, 69, 4, 10, 10);
    testModel.addShape("Idris Elba", ShapeType.RECTANGLE, 10, 3, 70, 250, 18, 7, 6);
    testModel.changePos("Ian McKellen", 6, 3, 7, 4, 3, 6);
    testModel.changePos("Rebel Wilson", 5, 10, 8, 2, 2, 20);
    testModel.changePos("Idris Elba", 10, 3, 3, 3, 9, 14);
    assertEquals("Shapes:\n"
                    + "Name: Ian McKellen\n"
                    + "Type: Oval\n"
                    + "Center: (6, 3), X radius: 7, Y radius: 3, Color: (4, 178, 100)\n"
                    + "\n"
                    + "Name: Rebel Wilson\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (5, 10), Width: 10, Height: 10, Color: (109, 69, 4)\n"
                    + "\n"
                    + "Name: Idris Elba\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (10, 3), Width: 7, Height: 6, Color: (70, 250, 18)\n"
                    + "\n"
                    + "Shape Rebel Wilson moves from (5,10) to (8,2) from t=2 to t=20\n"
                    + "Shape Ian McKellen moves from (6,3) to (7,4) from t=3 to t=6\n"
                    + "Shape Idris Elba moves from (10,3) to (3,3) from t=9 to t=14\n",
            testModel.getState());
  }

  // Testing the changePos method when entering a shape ID that does not exist in the model.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos4() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changePos("Natalie Portman", 6, 3, 7, 4, 3, 6);
  }

  // Testing the changePos method when entering negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos5() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changePos("Laurie Davidson", 6, 3, 7, 4, -3, -6);
  }

  // Testing the changePos method when placing end time before start time.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos6() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changePos("Laurie Davidson", 6, 3, 7, 4, 5, 3);
  }

  // Testing the changeColor method by transforming one of each shape.
  @Test
  public void testChangeColor1() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Ian McKellen", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3);
    testModel.addShape("Rebel Wilson", ShapeType.RECTANGLE, 5, 10, 109, 69, 4, 10, 10);
    testModel.addShape("Idris Elba", ShapeType.RECTANGLE, 10, 3, 70, 250, 18, 7, 6);
    testModel.changeColor("Ian McKellen", 4, 178, 100, 100, 178, 200, 2, 10);
    testModel.changeColor("Rebel Wilson", 109, 69, 4, 213, 20, 201, 2, 3);
    testModel.changeColor("Idris Elba", 70, 250, 18, 100, 200, 50, 9, 10);
    assertEquals("Shapes:\n"
            + "Name: Ian McKellen\n"
            + "Type: Oval\n"
            + "Center: (6, 3), X radius: 7, Y radius: 3, Color: (4, 178, 100)\n"
            + "\n"
            + "Name: Rebel Wilson\n"
            + "Type: Rectangle\n"
            + "Min corner: (5, 10), Width: 10, Height: 10, Color: (109, 69, 4)\n"
            + "\n"
            + "Name: Idris Elba\n"
            + "Type: Rectangle\n"
            + "Min corner: (10, 3), Width: 7, Height: 6, Color: (70, 250, 18)\n"
            + "\n"
            + "Shape Rebel Wilson changes color from (109,69,4) to (213,20,201) from t=2 to t=3\n"
            + "Shape Ian McKellen changes color from (4,178,100) to (100,178,200) from t=2 "
                    + "to t=10\n"
            + "Shape Idris Elba changes color from (70,250,18) to (100,200,50) from t=9 to t=10\n",
            testModel.getState());
  }

  // Testing the changeColor method when attempting to change to the same color.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor2() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeColor("Francesca Hayward", 4, 178, 100, 4, 178, 100, 2, 13);
  }

  // Testing the changeColor method when entering a shape ID that does not exist in the model.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor4() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeColor("Rum Tum Tugger", 100, 100, 100, 200, 200, 200, 0, 3);
  }

  // Testing the changeColor method when entering negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor5() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeColor("Laurie Davidson", 4, 178, 100, 4, 30, 120, -3, -5);
  }

  // Testing the changeColor method when placing end time before start time.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor6() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeColor("Laurie Davidson", 4, 178, 100, 4, 30, 120, 5, 3);
  }

  // Testing the changeScale method by transforming one of each shape.
  @Test
  public void testChangeScale1() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Ian McKellen", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3);
    testModel.addShape("Rebel Wilson", ShapeType.RECTANGLE, 5, 10, 109, 69, 4, 10, 10);
    testModel.addShape("Idris Elba", ShapeType.RECTANGLE, 10, 3, 70, 250, 18, 7, 6);
    testModel.changeScale("Ian McKellen", 7, 3, 10, 6, 2, 5);
    testModel.changeScale("Rebel Wilson", 10, 10, 8, 2, 2, 20);
    testModel.changeScale("Idris Elba", 7, 6, 3, 2, 9, 12);
    assertEquals("Shapes:\n"
            + "Name: Ian McKellen\n"
            + "Type: Oval\n"
            + "Center: (6, 3), X radius: 7, Y radius: 3, Color: (4, 178, 100)\n"
            + "\n"
            + "Name: Rebel Wilson\n"
            + "Type: Rectangle\n"
            + "Min corner: (5, 10), Width: 10, Height: 10, Color: (109, 69, 4)\n"
            + "\n"
            + "Name: Idris Elba\n"
            + "Type: Rectangle\n"
            + "Min corner: (10, 3), Width: 7, Height: 6, Color: (70, 250, 18)\n"
            + "\n"
            + "Shape Ian McKellen scales from Width: 7, Height: 3 to Width: 10, Height: 6 from t=2 "
            + "to t=5\n"
            + "Shape Rebel Wilson scales from Width: 10, Height: 10 to Width: 8, Height: 2 from t=2"
            + " to t=20\n"
            + "Shape Idris Elba scales from Width: 7, Height: 6 to Width: 3, Height: 2 from t=9 to"
            + " t=12\n", testModel.getState());
  }

  // Testing the changeScale method when attempting to scale to the same size.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale2() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeScale("Francesca Hayward", 7, 3, 7, 3, 3, 6);
  }

  // Testing the changeScale method when attempting to create a duplicate transformation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale3() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeScale("Francesca Hayward", 7, 3, 7, 3, 3, 6);
    testModel.changeScale("Francesca Hayward", 7, 3, 7, 3, 3, 6);
  }

  // Testing the changeScale method when entering a shape ID that does not exist in the model.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale4() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeScale("Insert: Actor not in Cats (2019)", 7, 3, 7, 3, 3, 6);
  }

  // Testing the changeScale method when entering negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale5() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeScale("Laurie Davidson", 7, 3, 7, 4, -3, -6);
  }

  // Testing the changeScale method when placing end time before start time.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale6() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Laurie Davidson", ShapeType.RECTANGLE, 6, 3, 4, 178, 100, 7, 3);
    testModel.changeScale("Laurie Davidson", 7, 3, 6, 4, 5, 3);
  }

  // Testing a generic model use where multiple shapes are created and multiple transformations are
  // applied to them.
  @Test
  public void testMultiple() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.addShape("Judi Dench", ShapeType.OVAL, 50, 35, 45, 164, 100, 7, 3);
    testModel.addShape("Jason Derulo", ShapeType.RECTANGLE, 5, 10, 104, 69, 4, 10, 10);
    testModel.addShape("Taylor Swift", ShapeType.RECTANGLE, 10, 3, 70, 250, 18, 7, 6);
    testModel.changePos("Judi Dench", 50, 35, 30, 20, 3, 6);
    testModel.changePos("Taylor Swift", 10, 3, 5, 5, 3, 10);
    testModel.changePos("Judi Dench", 30, 20, 15, 10, 7, 14);
    testModel.changeColor("Jason Derulo", 104, 69, 4, 200, 200, 200, 2, 4);
    testModel.changeColor("Taylor Swift", 70, 250, 18, 150, 30, 67, 4, 7);
    testModel.changeScale("Judi Dench", 7, 3, 10, 15, 2, 4);
    testModel.changeScale("Jason Derulo", 10, 10, 20, 10, 2, 8);
    assertEquals("Shapes:\n"
                    + "Name: Judi Dench\n"
                    + "Type: Oval\n"
                    + "Center: (50, 35), X radius: 7, Y radius: 3, Color: (45, 164, 100)\n"
                    + "\n"
                    + "Name: Jason Derulo\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (5, 10), Width: 10, Height: 10, Color: (104, 69, 4)\n"
                    + "\n"
                    + "Name: Taylor Swift\n"
                    + "Type: Rectangle\n"
                    + "Min corner: (10, 3), Width: 7, Height: 6, Color: (70, 250, 18)\n"
                    + "\n"
                    + "Shape Jason Derulo changes color from (104,69,4) to (200,200,200) from "
                    + "t=2 to t=4\n"
                    + "Shape Judi Dench scales from Width: 7, Height: 3 to Width: 10, Height: "
                    + "15 from t=2 to t=4\n"
                    + "Shape Jason Derulo scales from Width: 10, Height: 10 to Width: 20, Height: "
                    + "10 from t=2 to t=8\n"
                    + "Shape Judi Dench moves from (50,35) to (30,20) from t=3 to t=6\n"
                    + "Shape Taylor Swift moves from (10,3) to (5,5) from t=3 to t=10\n"
                    + "Shape Taylor Swift changes color from (70,250,18) to (150,30,67) from "
                    + "t=4 to t=7\n"
                    + "Shape Judi Dench moves from (30,20) to (15,10) from t=7 to t=14\n",
            testModel.getState());
  }

  // Throw Exception in cs5004.animator.model.AnimatorModelImpl if unique shape ID
  // is not found in the shapeList -- i.e. trying to transformation a shape that
  // doesn't exists in our animation
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidShapeIDChangePos() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.changePos(null, 6, 7, 8, 9,
            11, 12);
  }

  // Throw Exception in cs5004.animator.model.AnimatorModelImpl if unique shape ID
  // is not found in the shapeList -- i.e. trying to transformation a shape that
  // doesn't exists in our animation
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidShapeIDChangeScale() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.changeScale(null, 6, 7, 8, 9,
            11, 12);
  }

  // Throw Exception in cs5004.animator.model.AnimatorModelImpl if unique shape ID
  // is not found in the shapeList -- i.e. trying to transformation a shape that
  // doesn't exists in our animation
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidShapeIDChangeColor() {
    testModel = new AnimatorModelImpl(0, 0, 700, 700);
    testModel.changeColor(null, 6, 7, 8, 9,
            11, 12, 20, 29);
  }
}