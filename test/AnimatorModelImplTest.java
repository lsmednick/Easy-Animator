import org.junit.Test;

import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ShapeType;

import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test class for the cs5004.animator.model.AnimatorModelImpl class. Every method of the model is tested
 * by checking the string representation of the added shapes / transformations to ensure they are
 * displaying the correct information.
 */

public class AnimatorModelImplTest {
  AnimatorModelImpl testModel;

  // Testing the addShape method by adding one of each shape type to the model. Testing getState
  // in this method as well.
  @Test
  public void testAddShape1() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Judi Dench", ShapeType.OVAL, 50, 35, 45, 164, 100, 7, 3, 0, 15);
    testModel.addShape("Jason Derulo", ShapeType.TRIANGLE, 5, 10, 104, 69, 4, 10, 10, 1, 27);
    testModel.addShape("Taylor Swift", ShapeType.RECTANGLE, 10.5, 3, 70, 250, 18, 7.5, 6, 3, 20);
    assertEquals("Shapes:\n"
            + "Name: Taylor Swift\n"
            + "Type: cs5004.animator.model.Rectangle\n"
            + "Min corner: (10.5, 3.0), Width: 7.5, Height: 6.0, Color: (70, 250, 18)\n"
            + "Appears at t=3\n"
            + "Disappears at t=20\n"
            + "\n"
            + "Name: Judi Dench\n"
            + "Type: cs5004.animator.model.Oval\n"
            + "Center: (50.0, 35.0), X radius: 7.0, Y radius: 3.0, Color: (45, 164, 100)\n"
            + "Appears at t=0\n"
            + "Disappears at t=15\n"
            + "\n"
            + "Name: Jason Derulo\n"
            + "Type: cs5004.animator.model.Triangle\n"
            + "Min corner: (5.0, 10.0), Width: 10.0, Height: 10.0, Color: (104, 69, 4)\n"
            + "Appears at t=1\n"
            + "Disappears at t=27\n"
            + "\n", testModel.getState());
  }

  // Testing the addShape method when attempting to input negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape2() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("James Corden", ShapeType.OVAL, 53, 34, 100, 16, 10, 7, 3, -4, -1);
  }

  // Testing the addShape method when attempting place end time after the start time.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape3() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Jennifer Hudson", ShapeType.TRIANGLE, 5, 3, 107, 16, 10, 7, 3, 5, 2);
  }

  // Testing the addShape method when entering negative x / y coordinates.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape4() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Jennifer Hudson", ShapeType.TRIANGLE, -4, -2, 107, 16, 10, 7, 3, 5, 2);
  }

  // Testing the addShape method when entering invalid width / height values.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape5() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Jennifer Hudson", ShapeType.TRIANGLE, 5, 6, 107, 16, 10, -4, 0, 5, 2);
  }

  // Testing the addShape method when entering a null string ID.
  @Test(expected = IllegalArgumentException.class)
  public void testAddShape6() {
    testModel = new AnimatorModelImpl();
    testModel.addShape(null, ShapeType.TRIANGLE, 5, 6, 107, 16, 10, 7, 8, 5, 2);
  }

  // Testing the changePos method by transforming one of each shape.
  @Test
  public void testChangePos1() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Ian McKellen", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.addShape("Rebel Wilson", ShapeType.TRIANGLE, 5, 10, 109, 69, 4, 10, 10, 1, 27);
    testModel.addShape("Idris Elba", ShapeType.RECTANGLE, 10.5, 3, 70, 250, 18, 7.5, 6, 8, 21);
    testModel.changePos("Ian McKellen", 6, 3, 7, 4, 3, 6);
    testModel.changePos("Rebel Wilson", 5, 10, 8, 2, 2, 20);
    testModel.changePos("Idris Elba", 10.5, 3, 3, 3, 9, 14);
    assertEquals("Shapes:\n"
                    + "Name: Rebel Wilson\n"
                    + "Type: cs5004.animator.model.Triangle\n"
                    + "Min corner: (5.0, 10.0), Width: 10.0, Height: 10.0, Color: (109, 69, 4)\n"
                    + "Appears at t=1\n"
                    + "Disappears at t=27\n"
                    + "\n"
                    + "Name: Idris Elba\n"
                    + "Type: cs5004.animator.model.Rectangle\n"
                    + "Min corner: (10.5, 3.0), Width: 7.5, Height: 6.0, Color: (70, 250, 18)\n"
                    + "Appears at t=8\n"
                    + "Disappears at t=21\n"
                    + "\n"
                    + "Name: Ian McKellen\n"
                    + "Type: cs5004.animator.model.Oval\n"
                    + "Center: (6.0, 3.0), X radius: 7.0, Y radius: 3.0, Color: (4, 178, 100)\n"
                    + "Appears at t=0\n"
                    + "Disappears at t=15\n"
                    + "\n"
                    + "Shape Rebel Wilson moves from (5.0,10.0) to (8.0,2.0) from t=2 to t=20\n"
                    + "Shape Ian McKellen moves from (6.0,3.0) to (7.0,4.0) from t=3 to t=6\n"
                    + "Shape Idris Elba moves from (10.5,3.0) to (3.0,3.0) from t=9 to t=14\n",
            testModel.getState());
  }

  // Testing the changePos method when attempting to move to the same position.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos2() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changePos("Francesca Hayward", 6, 3, 6, 3, 3, 6);
  }

  // Testing the changePos method when attempting to create a duplicate transformation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos3() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changePos("Francesca Hayward", 6, 3, 7, 4, 3, 6);
    testModel.changePos("Francesca Hayward", 6, 3, 7, 4, 3, 6);
  }

  // Testing the changePos method when entering a shape ID that does not exist in the model.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos4() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changePos("Natalie Portman", 6, 3, 7, 4, 3, 6);
  }

  // Testing the changePos method when entering negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos5() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changePos("Laurie Davidson", 6, 3, 7, 4, -3, -6);
  }

  // Testing the changePos method when placing end time before start time.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePos6() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changePos("Laurie Davidson", 6, 3, 7, 4, 5, 3);
  }

  // Testing the changePos method when attempting to transform shape outside of its appearance /
  // disappearance times.
  @Test (expected = IllegalArgumentException.class)
  public void testChangePos7() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changePos("Laurie Davidson", 6, 3, 7, 4, 0, 16);
  }

  // Testing the changeColor method by transforming one of each shape.
  @Test
  public void testChangeColor1() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Ian McKellen", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.addShape("Rebel Wilson", ShapeType.TRIANGLE, 5, 10, 109, 69, 4, 10, 10, 1, 27);
    testModel.addShape("Idris Elba", ShapeType.RECTANGLE, 10.5, 3, 70, 250, 18, 7.5, 6, 8, 21);
    testModel.changeColor("Ian McKellen", 4, 178, 100, 100, 178, 200, 2, 10);
    testModel.changeColor("Rebel Wilson", 109, 69, 4, 213, 20, 201, 2, 3);
    testModel.changeColor("Idris Elba", 70, 250, 18, 100, 200, 50, 9, 10);
    assertEquals("Shapes:\n"
                    + "Name: Rebel Wilson\n"
                    + "Type: cs5004.animator.model.Triangle\n"
                    + "Min corner: (5.0, 10.0), Width: 10.0, Height: 10.0, Color: (109, 69, 4)\n"
                    + "Appears at t=1\n"
                    + "Disappears at t=27\n"
                    + "\n"
                    + "Name: Idris Elba\n"
                    + "Type: cs5004.animator.model.Rectangle\n"
                    + "Min corner: (10.5, 3.0), Width: 7.5, Height: 6.0, Color: (70, 250, 18)\n"
                    + "Appears at t=8\n"
                    + "Disappears at t=21\n"
                    + "\n"
                    + "Name: Ian McKellen\n"
                    + "Type: cs5004.animator.model.Oval\n"
                    + "Center: (6.0, 3.0), X radius: 7.0, Y radius: 3.0, Color: (4, 178, 100)\n"
                    + "Appears at t=0\n"
                    + "Disappears at t=15\n"
                    + "\n"
                    + "Shape Rebel Wilson changes color from (109,69,4) to (213,20,201) "
                    + "from t=2 to t=3\n"
                    + "Shape Ian McKellen changes color from (4,178,100) to (100,178,200) "
                    + "from t=2 to t=10\n"
                    + "Shape Idris Elba changes color from (70,250,18) to (100,200,50) "
                    + "from t=9 to t=10\n", testModel.getState());
  }

  // Testing the changeColor method when attempting to change to the same color.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor2() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeColor("Francesca Hayward", 4, 178, 100, 4, 178, 100, 2, 13);
  }

  // Testing the changeColor method when attempting to create a duplicate transformation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor3() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeColor("Francesca Hayward", 4, 178, 100, 60, 170, 130, 2, 13);
    testModel.changeColor("Francesca Hayward", 4, 178, 100, 60, 170, 130, 2, 13);
  }

  // Testing the changeColor method when entering a shape ID that does not exist in the model.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor4() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeColor("Rum Tum Tugger", 100, 100, 100, 200, 200, 200, 0, 3);
  }

  // Testing the changeColor method when entering negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor5() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeColor("Laurie Davidson", 4, 178, 100, 4, 30, 120, -3, -5);
  }

  // Testing the changeColor method when placing end time before start time.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColor6() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeColor("Laurie Davidson", 4, 178, 100, 4, 30, 120, 5, 3);
  }

  // Testing the changeColor method when attempting to transform shape outside of its appearance /
  // disappearance times.
  @Test (expected = IllegalArgumentException.class)
  public void testChangeColor7() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeColor("Laurie Davidson", 4, 178, 100, 4, 30, 120, 0, 17);
  }

  // Testing the changeScale method by transforming one of each shape.
  @Test
  public void testChangeScale1() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Ian McKellen", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.addShape("Rebel Wilson", ShapeType.TRIANGLE, 5, 10, 109, 69, 4, 10, 10, 1, 27);
    testModel.addShape("Idris Elba", ShapeType.RECTANGLE, 10.5, 3, 70, 250, 18, 7.5, 6, 8, 21);
    testModel.changeScale("Ian McKellen", 7, 3, 10, 6, 2, 5);
    testModel.changeScale("Rebel Wilson", 10, 10, 8, 2, 2, 20);
    testModel.changeScale("Idris Elba", 7.5, 6, 3, 2, 9, 12);
    assertEquals("Shapes:\n"
                    + "Name: Rebel Wilson\n"
                    + "Type: cs5004.animator.model.Triangle\n"
                    + "Min corner: (5.0, 10.0), Width: 10.0, Height: 10.0, Color: (109, 69, 4)\n"
                    + "Appears at t=1\n"
                    + "Disappears at t=27\n"
                    + "\n"
                    + "Name: Idris Elba\n"
                    + "Type: cs5004.animator.model.Rectangle\n"
                    + "Min corner: (10.5, 3.0), Width: 7.5, Height: 6.0, Color: (70, 250, 18)\n"
                    + "Appears at t=8\n"
                    + "Disappears at t=21\n"
                    + "\n"
                    + "Name: Ian McKellen\n"
                    + "Type: cs5004.animator.model.Oval\n"
                    + "Center: (6.0, 3.0), X radius: 7.0, Y radius: 3.0, Color: (4, 178, 100)\n"
                    + "Appears at t=0\n"
                    + "Disappears at t=15\n"
                    + "\n"
                    + "Shape Ian McKellen scales from Width: 7.0, Height: 3.0 to Width: 10.0, "
                    + "Height: 6.0 from t=2 to t=5\n"
                    + "Shape Rebel Wilson scales from Width: 10.0, Height: 10.0 to Width: 8.0, "
                    + "Height: 2.0 from t=2 to t=20\n"
                    + "Shape Idris Elba scales from Width: 7.5, Height: 6.0 to Width: 3.0, Height: "
                    + "2.0 from t=9 to t=12\n", testModel.getState());
  }

  // Testing the changeScale method when attempting to scale to the same size.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale2() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeScale("Francesca Hayward", 7, 3, 7, 3, 3, 6);
  }

  // Testing the changeScale method when attempting to create a duplicate transformation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale3() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Francesca Hayward", ShapeType.OVAL, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeScale("Francesca Hayward", 7, 3, 7, 3, 3, 6);
    testModel.changeScale("Francesca Hayward", 7, 3, 7, 3, 3, 6);
  }

  // Testing the changeScale method when entering a shape ID that does not exist in the model.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale4() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeScale("Insert: Actor not in Cats (2019)", 7, 3, 7, 3, 3, 6);
  }

  // Testing the changeScale method when entering negative start / end times.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale5() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeScale("Laurie Davidson", 7, 3, 7, 4, -3, -6);
  }

  // Testing the changeScale method when placing end time before start time.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScale6() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeScale("Laurie Davidson", 7, 3, 6, 4, 5, 3);
  }

  // Testing the changeScale method when attempting to transform shape outside of its appearance /
  // disappearance times.
  @Test (expected = IllegalArgumentException.class)
  public void testChangeScale7() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Laurie Davidson", ShapeType.TRIANGLE, 6, 3, 4, 178, 100, 7, 3, 0, 15);
    testModel.changeScale("Laurie Davidson", 7, 3, 7, 4, 0, 18);
  }

  // Testing a generic model use where multiple shapes are created and multiple transformations are
  // applied to them.
  @Test
  public void testMultiple() {
    testModel = new AnimatorModelImpl();
    testModel.addShape("Judi Dench", ShapeType.OVAL, 50, 35, 45, 164, 100, 7, 3, 0, 15);
    testModel.addShape("Jason Derulo", ShapeType.TRIANGLE, 5, 10, 104, 69, 4, 10, 10, 1, 27);
    testModel.addShape("Taylor Swift", ShapeType.RECTANGLE, 10.5, 3, 70, 250, 18, 7.5, 6, 3, 20);
    testModel.changePos("Judi Dench", 50, 35, 30, 20, 3, 6);
    testModel.changePos("Taylor Swift", 10.5, 3, 5, 5, 3, 10);
    testModel.changePos("Judi Dench", 30, 20, 15, 10, 7, 14);
    testModel.changeColor("Jason Derulo", 104, 69, 4, 200, 200, 200, 2, 4);
    testModel.changeColor("Taylor Swift", 70, 250, 18, 150, 30, 67, 4, 7);
    testModel.changeScale("Judi Dench", 7, 3, 10, 15, 2, 4);
    testModel.changeScale("Jason Derulo", 10, 10, 20, 10, 2, 8);
    assertEquals("Shapes:\n"
            + "Name: Taylor Swift\n"
            + "Type: cs5004.animator.model.Rectangle\n"
            + "Min corner: (10.5, 3.0), Width: 7.5, Height: 6.0, Color: (70, 250, 18)\n"
            + "Appears at t=3\n"
            + "Disappears at t=20\n"
            + "\n"
            + "Name: Judi Dench\n"
            + "Type: cs5004.animator.model.Oval\n"
            + "Center: (50.0, 35.0), X radius: 7.0, Y radius: 3.0, Color: (45, 164, 100)\n"
            + "Appears at t=0\n"
            + "Disappears at t=15\n"
            + "\n"
            + "Name: Jason Derulo\n"
            + "Type: cs5004.animator.model.Triangle\n"
            + "Min corner: (5.0, 10.0), Width: 10.0, Height: 10.0, Color: (104, 69, 4)\n"
            + "Appears at t=1\n"
            + "Disappears at t=27\n\n"
            + "Shape Jason Derulo changes color from (104,69,4) to (200,200,200) from t=2 to t=4\n"
            + "Shape Judi Dench scales from Width: 7.0, Height: 3.0 to Width: 10.0, Height: 15.0 "
            + "from t=2 to t=4\n"
            + "Shape Jason Derulo scales from Width: 10.0, Height: 10.0 to Width: 20.0, Height: "
            + "10.0 from t=2 to t=8\n"
            + "Shape Judi Dench moves from (50.0,35.0) to (30.0,20.0) from t=3 to t=6\n"
            + "Shape Taylor Swift moves from (10.5,3.0) to (5.0,5.0) from t=3 to t=10\n"
            + "Shape Taylor Swift changes color from (70,250,18) to (150,30,67) from t=4 to t=7\n"
            + "Shape Judi Dench moves from (30.0,20.0) to (15.0,10.0) from t=7 to t=14\n",
            testModel.getState());
  }
}