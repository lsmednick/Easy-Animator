import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a JUnit test class to test AbstractTransform and the concrete classes that extends it
 * (ChangeColor, ChangePos, ChangeScale). The concrete classes call upon the super class
 * AbstractTransform to instantiate the String shapeID, start time of the transformation, and end
 * time of the transformation. Exceptions are thrown in AbstractTransform for the fields mentioned
 * previously. Additional exceptions are thrown within each individual concrete class constructor.
 */

public class TransformTest {

  /**
   * Testing valid input for AbstractTransform and Concrete Classes (ChangeColor, ChangePos,
   * ChangeScale). From AbstractTransform test getters and constructor. From concrete classes test
   * ToString and CompareTo methods. From both AbstractTransform and concrete classes, test
   * constructors. Concrete classes call super class for instantiating name, startTime and EndTime.
   */

  //Test valid input for ChangeColor (calls super AbstractTransform to instantiate some fields)
  @Test
  public void testAbstractTransformChangeColor() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");


    AbstractTransform bobNewColor = new ChangeColor(bob, 3, 4, 5,
            6, 7, 8, 2, 9);
    assertEquals("Shape Bob changes color from (3,4,5) to (6,7,8) from t=2 to t=9\n",
            bobNewColor.toString());

    assertEquals("Bob", bobNewColor.getShapeID());
    assertEquals(2, bobNewColor.getStartTime());
    assertEquals(9, bobNewColor.getEndTime());
  }

  //Test valid input for ChangePos (calls super AbstractTransform to instantiate some fields)
  @Test
  public void testAbstractTransformChangePos() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");

    AbstractTransform bobNewPosition = new ChangePos(bob, 1.1, 2.1, 3.1, 4.1,
            5, 6);
    assertEquals("Shape Bob moves from (1.1,2.1) to (3.1,4.1) from t=5 to t=6\n",
            bobNewPosition.toString());

    assertEquals("Bob", bobNewPosition.getShapeID());
    assertEquals(5, bobNewPosition.getStartTime());
    assertEquals(6, bobNewPosition.getEndTime());
  }

  //Test valid input for ChangeScale (calls super AbstractTransform to instantiate some fields)
  @Test
  public void testAbstractTransformChangeScale() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");

    AbstractTransform bobNewScale = new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            5, 6);
    assertEquals("Shape Bob scales from Width: 6.1, Height: 7.1 to Width: 8.1, "
                    + "Height: 9.1 from t=5 to t=6\n",
            bobNewScale.toString());

    assertEquals("Bob", bobNewScale.getShapeID());
    assertEquals(5, bobNewScale.getStartTime());
    assertEquals(6, bobNewScale.getEndTime());
  }

  //Test compareTo method in AbstractTransform when startTimes are different.
  @Test
  public void testCompareToStartTimes() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");
    AbstractTransform bobNewScale = new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            5, 8);
    AbstractTransform bobNewScale2 = new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            7, 8);

    assertEquals(-2, bobNewScale.compareTo(bobNewScale2));
  }

  //Test compareTo method in AbstractTransform when endTimes are different.
  @Test
  public void testCompareToEndTimes() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");
    AbstractTransform bobNewScale = new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            5, 6);
    AbstractTransform bobNewScale2 = new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            5, 7);

    assertEquals(-1, bobNewScale.compareTo(bobNewScale2));
  }

  /**
   * Testing AbstractTransform Exceptions.
   */

  //Throws Exception in AbstractTransform constructor if the startTime is negative
  @Test(expected = IllegalArgumentException.class)
  public void testStartTimeNegative() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");

    new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            -5, 6);
  }

  //Throws Exception in AbstractTransform constructor if endTime is negative
  @Test(expected = IllegalArgumentException.class)
  public void testEndTimeNegative() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");

    new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            5, -6);
  }

  //Throws Exception in AbstractTransform constructor if endTime occurs before start time
  @Test(expected = IllegalArgumentException.class)
  public void testEndTimeBeforeStartTime() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 0,
            10, "Bob");

    new ChangeScale(bob, 6.1, 7.1, 8.1, 9.1,
            6, 5);
  }

  /**
   * Testing ChangeColor Exceptions.
   */

  //Throws Exception in ChangeColor constructor if startTime of transformation occurs
  //before appears of shape in animation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorConstructorStartTimeInvalid() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeColor(bob, 3, 4, 5, 6, 7, 8, 1, 10);
  }

  //Throws Exception in ChangeColor constructor if endTime of transformation occurs
  //after shape has disappeared from animation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorConstructorEndTimeInvalid() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeColor(bob, 3, 4, 5, 6, 7, 8, 6, 12);
  }


  /**
   * Testing ChangePOS Exceptions
   */

  //Throws Exception in ChangePos constructor if startTime of transformation occurs
  //before appears of shape in animation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePosConstructorStartTimeInvalid() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangePos(bob, 1.1, 2.1, 3.1, 4.1, 4, 8);
  }

  //Throws Exception in ChangePos constructor if endTime of transformation occurs
  //after shape has disappeared from animation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePosConstructorEndTimeInvalid() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangePos(bob, 1.1, 2.1, 3.1, 4.1, 6, 23);
  }

  //Throws Exception in ChangeColor constructor fromX is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePosConstructorNegativeFromX() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangePos(bob, -1.1, 2.1, 3.1, 4.1, 6, 9);
  }

  //Throws Exception in ChangeColor constructor fromY is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePosConstructorNegativeFromY() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangePos(bob, 1.1, -2.1, 3.1, 4.1, 6, 9);
  }

  //Throws Exception in ChangeColor constructor toX is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePosConstructorNegativeToX() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangePos(bob, 1.1, 2.1, -3.1, 4.1, 6, 9);
  }

  //Throws Exception in ChangeColor constructor toY is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangePosConstructorNegativeToY() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangePos(bob, 1.1, 2.1, 3.1, -4.1, 6, 9);
  }


  /**
   * Testing ChangeScale Exceptions.
   */

  //Throws Exception in ChangeScale constructor if startTime of transformation occurs
  //before appears of shape in animation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorStartTimeInvalid() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeScale(bob, 1.1, 2.1, 3.1, 4.1, 4, 8);
  }

  //Throws Exception in ChangeScale constructor if endTime of transformation occurs
  //after shape has disappeared from animation.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorEndTimeInvalid() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeScale(bob, 1.1, 2.1, 3.1, 4.1, 6, 23);

  }

  //Throws Exception in ChangeScale constructor fromWidth is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeFromX() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeScale(bob, -6.1, 7.1, 3.1, 4.1, 6, 9);
  }

  //Throws Exception in ChangeScale constructor fromHeight is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeFromY() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeScale(bob, 6.1, -7.1, 3.1, 4.1, 6, 9);
  }

  //Throws Exception in ChangeScale constructor toWidth is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeToX() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeScale(bob, 6.1, 7.1, -3.1, 4.1, 6, 9);
  }

  //Throws Exception in ChangeScale constructor toHeight is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testChangeScaleConstructorNegativeToY() {
    AbstractShape bob = new Triangle(1.1, 2.1, 3, 4, 5, 6.1, 7.1, 5,
            10, "Bob");

    new ChangeScale(bob, 6.1, 7.1, 3.1, -4.1, 6, 9);
  }

}

