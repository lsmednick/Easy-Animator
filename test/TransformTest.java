import org.junit.Test;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.AbstractTransform;
import cs5004.animator.model.ChangeColor;
import cs5004.animator.model.ChangePos;
import cs5004.animator.model.ChangeScale;
import cs5004.animator.model.Rectangle;

import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test class to test cs5004.animator.model.AbstractTransform and the concrete classes that extends it
 * (cs5004.animator.model.ChangeColor, cs5004.animator.model.ChangePos, cs5004.animator.model.ChangeScale). The concrete classes call upon the super class
 * cs5004.animator.model.AbstractTransform to instantiate the String shapeID, start time of the transformation, and end
 * time of the transformation. Exceptions are thrown in cs5004.animator.model.AbstractTransform for the fields mentioned
 * previously. Additional exceptions are thrown within each individual concrete class constructor.
 */

public class TransformTest {

  /**
   * Testing valid input for cs5004.animator.model.AbstractTransform and Concrete Classes
   * (cs5004.animator.model.ChangeColor, cs5004.animator.model.ChangePos,
   * cs5004.animator.model.ChangeScale). From cs5004.animator.model.AbstractTransform test getters
   * and constructor. From concrete classes test ToString and CompareTo methods. From both
   * cs5004.animator.model.AbstractTransform and concrete classes, test constructors. Concrete
   * classes call super class for instantiating name, startTime and EndTime.
   */

  // Test valid input for cs5004.animator.model.ChangeColor
  // (calls super cs5004.animator.model.AbstractTransform to instantiate some fields)
  @Test
  public void testAbstractTransformChangeColor() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    AbstractTransform bobNewColor = new ChangeColor(bob, 3, 4, 5,
            6, 7, 8, 2, 9);
    assertEquals("Shape Bob changes color from (3,4,5) to (6,7,8) from t=2 to t=9\n",
            bobNewColor.toString());

    assertEquals("Bob", bobNewColor.getShapeID());
    assertEquals(2, bobNewColor.getStartTime());
    assertEquals(9, bobNewColor.getEndTime());
  }

  // Test valid input for cs5004.animator.model.ChangePos
  // (calls super cs5004.animator.model.AbstractTransform to instantiate some fields)
  @Test
  public void testAbstractTransformChangePos() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    AbstractTransform bobNewPosition = new ChangePos(bob, 1, 2, 3, 4,
            5, 6);
    assertEquals("Shape Bob moves from (1,2) to (3,4) from t=5 to t=6\n",
            bobNewPosition.toString());

    assertEquals("Bob", bobNewPosition.getShapeID());
    assertEquals(5, bobNewPosition.getStartTime());
    assertEquals(6, bobNewPosition.getEndTime());
  }

  // Test valid input for cs5004.animator.model.ChangeScale
  // (calls super cs5004.animator.model.AbstractTransform to instantiate some fields)
  @Test
  public void testAbstractTransformChangeScale() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    AbstractTransform bobNewScale = new ChangeScale(bob, 6, 7, 8, 9,
            5, 6);
    assertEquals("Shape Bob scales from Width: 6, Height: 7 to Width: 8, "
                    + "Height: 9 from t=5 to t=6\n",
            bobNewScale.toString());

    assertEquals("Bob", bobNewScale.getShapeID());
    assertEquals(5, bobNewScale.getStartTime());
    assertEquals(6, bobNewScale.getEndTime());
  }

  // Test compareTo method in cs5004.animator.model.AbstractTransform when startTimes are different.
  @Test
  public void testCompareToStartTimes() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");
    AbstractTransform bobNewScale = new ChangeScale(bob, 6, 7, 8, 9,
            5, 8);
    AbstractTransform bobNewScale2 = new ChangeScale(bob, 6, 7, 8, 9,
            7, 8);

    assertEquals(-2, bobNewScale.compareTo(bobNewScale2));
  }

  // Test compareTo method in cs5004.animator.model.AbstractTransform when endTimes are different.
  @Test
  public void testCompareToEndTimes() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");
    AbstractTransform bobNewScale = new ChangeScale(bob, 6, 7, 8, 9,
            5, 6);
    AbstractTransform bobNewScale2 = new ChangeScale(bob, 6, 7, 8, 9,
            5, 7);

    assertEquals(-1, bobNewScale.compareTo(bobNewScale2));
  }

  // Testing cs5004.animator.model.AbstractTransform Exceptions.
  // Throws Exception in cs5004.animator.model.AbstractTransform constructor if the startTime is negative
  @Test(expected = IllegalArgumentException.class)
  public void testStartTimeNegative() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    new ChangeScale(bob, 6, 7, 8, 9,
            -5, 6);
  }

  // Throws Exception in cs5004.animator.model.AbstractTransform constructor if endTime is negative
  @Test(expected = IllegalArgumentException.class)
  public void testEndTimeNegative() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    new ChangeScale(bob, 6, 7, 8, 9,
            5, -6);
  }

  // Throws Exception in cs5004.animator.model.AbstractTransform constructor if endTime
  // occurs before start time
  @Test(expected = IllegalArgumentException.class)
  public void testEndTimeBeforeStartTime() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    new ChangeScale(bob, 6, 7, 8, 9,
            6, 5);
  }

  // Throws Exception in cs5004.animator.model.ChangeScale constructor fromWidth is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeFromX() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    new ChangeScale(bob, -6, 7, 3, 4, 6, 9);
  }

  // Throws Exception in cs5004.animator.model.ChangeScale constructor fromHeight is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeFromY() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7,  "Bob");

    new ChangeScale(bob, 6, -7, 3, 4, 6, 9);
  }

  // Throws Exception in cs5004.animator.model.ChangeScale constructor toWidth is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeToX() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    new ChangeScale(bob, 6, 7, -3, 4, 6, 9);
  }

  // Throws Exception in cs5004.animator.model.ChangeScale constructor toHeight is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeToY() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");

    new ChangeScale(bob, 6, 7, 3, -4, 6, 9);
  }

  // Throw Exception in cs5004.animator.model.AbstractTransform if IShape object is null
  @Test(expected = IllegalArgumentException.class)
  public void testNullShapeScale(){
    new ChangeScale(null, 6, 7, 8, 9,
            6, 5);
  }

  // Throw Exception in cs5004.animator.model.AbstractTransform if IShape object is null
  @Test(expected = IllegalArgumentException.class)
  public void testNullShapeColor(){
    new ChangeColor(null, 6, 7, 8, 9,
            11, 12, 3, 4);
  }

  // Throw Exception in cs5004.animator.model.AbstractTransform if IShape object is null
  @Test(expected = IllegalArgumentException.class)
  public void testNullShapePosition(){
    new ChangePos(null, 6, 7, 8, 9,
            11, 12);
  }
}

