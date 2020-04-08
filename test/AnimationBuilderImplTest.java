import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilderImpl;

import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test class for AnimationBuilderImpl class. This test ensures that the builder is
 * successfully able to populate an AnimationModel when passing various shapes and transformations
 * into it.
 */

public class AnimationBuilderImplTest {
  AnimationBuilderImpl testBuild;

  // Sets up animation builder prior to each test
  @Before
  public void setUp() {
    testBuild = new AnimationBuilderImpl();
  }

  // Testing the builder when attempting to add a single shape and a single transformation.
  @Test
  public void test1() {
    testBuild.setBounds(0, 0, 360, 360);
    testBuild.declareShape("Carlos", "Rectangle");
    testBuild.addMotion("Carlos", 0, 0, 0, 5, 10, 250, 250, 250, 10, 100, 100, 5, 10,
            250, 250, 250);
    AnimatorModel m = testBuild.build();
    assertEquals(0, m.getTopLeftX());
    assertEquals(0, m.getTopLeftY());
    assertEquals(360, m.getCanvasHeight());
    assertEquals(360, m.getCanvasWidth());
    assertEquals("Shapes:\n"
            + "Name: Carlos\n"
            + "Type: Rectangle\n"
            + "Min corner: (0, 0), Width: 5, Height: 10, Color: (250, 250, 250)\n"
            + "\n"
            + "Shape Carlos moves from (0,0) to (100,100) from t=0 to t=10\n", m.getState());
  }

  // Testing the builder when adding a shape that transforms twice in a single entry.
  @Test
  public void test2() {
    testBuild.setBounds(0, 0, 360, 360);
    testBuild.declareShape("Greg", "ellipse");
    testBuild.addMotion("Greg", 0, 0, 0, 10, 10, 0, 0, 0, 15, 0, 0, 15, 11, 250, 60, 73);
    AnimatorModel m = testBuild.build();
    assertEquals("Shapes:\n"
            + "Name: Greg\n"
            + "Type: Oval\n"
            + "Center: (0, 0), X radius: 10, Y radius: 10, Color: (0, 0, 0)\n"
            + "\n"
            + "Shape Greg changes color from (0,0,0) to (250,60,73) from t=0 to t=15\n"
            + "Shape Greg scales from Width: 10, Height: 10 to Width: 15, Height: 11 from "
            + "t=0 to t=15\n", m.getState());
  }

  // Testing to make sure an exception is thrown when an invalid shape is entered.
  @Test(expected = IllegalArgumentException.class)
  public void test3() {
    testBuild.setBounds(0, 0, 360, 360);
    testBuild.declareShape("Grog", "Rhombus");
    testBuild.addMotion("Grog", 0, 0, 0, 10, 10, 0, 0, 0, 15, 40, 25, 10, 10, 250, 60, 73);
  }

  // Testing to make sure an exception is thrown when an invalid shape name is entered.
  @Test(expected = IllegalArgumentException.class)
  public void test4() {
    testBuild.setBounds(0, 0, 360, 360);
    testBuild.declareShape("Grog", "rectangle");
    testBuild.addMotion("Groog", 0, 0, 0, 10, 10, 0, 0, 0, 15, 40, 25, 10, 10, 250, 60, 73);
  }

}