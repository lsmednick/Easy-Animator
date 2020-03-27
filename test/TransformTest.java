import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a JUnit test class to test AbstractTransform and the concrete classes
 * that extends it (ChangeColor, ChangePos, ChangeScale).
 * The concrete classes call upon the super class AbstractTransform to instantiate
 * the String shapeID, start time of the transformation, and end time of the transformation.
 * Exceptions are thrown in AbstractTransform for the fields mentioned previously. Additional
 * exceptions are thrown within each individual concrete class constructor.
 */

public class TransformTest {

  /**
   * Testing valid input for AbstractTransform and Concrete Classes (ChangeColor, ChangePos,
   * ChangeScale).
   * From AbstractTransform test getters and constructor.
   * From concrete classes test ToString and CompareTo methods.
   * From both AbstractTransform and concrete classes, test constructors. Concrete classes call
   * super class for instantiating name, startTime and EndTime.
   */

  @Test
  public void testAbstractTransformChangeColor(){
    AbstractShape bob = new Triangle(1.1,2.1,3,4,5,6.1,7.1,0,
            10, "Bob");


    AbstractTransform bobNewColor = new ChangeColor(bob, 3,4,5,
            6,7,8, 2, 9);
    assertEquals("Shape Bob changes color from (3,4,5) to (6,7,8) from t=2 to t=9\n",
            bobNewColor.toString());

    assertEquals("Bob", bobNewColor.getShapeID());
    assertEquals(2, bobNewColor.getStartTime());
    assertEquals(9,bobNewColor.getEndTime());
  }


  @Test
  public void testAbstractTransformChangePos(){
    AbstractShape bob = new Triangle(1.1,2.1,3,4,5,6.1,7.1,0,
            10, "Bob");

    AbstractTransform bobNewPosition = new ChangePos(bob, 1.1,2.1,3.1,4.1,
            5,6);
    assertEquals("Shape Bob moves from (1.1,2.1) to (3.1,4.1) from t=5 to t=6\n",
            bobNewPosition.toString());

    assertEquals("Bob", bobNewPosition.getShapeID());
    assertEquals(5, bobNewPosition.getStartTime());
    assertEquals(6, bobNewPosition.getEndTime());
  }


  @Test
  public void testAbstractTransformChangeScale(){
    AbstractShape bob = new Triangle(1.1,2.1,3,4,5,6.1,7.1,0,
            10, "Bob");

    AbstractTransform bobNewScale = new ChangeScale(bob, 6.1,7.1,8.1,9.1,
            5,6);
    assertEquals("Shape Bob scales from Width: 6.1, Height: 7.1 to Width: 8.1, "
                   +  "Height: 9.1 from t=5 to t=6\n",
            bobNewScale.toString());

    assertEquals("Bob", bobNewScale.getShapeID());
    assertEquals(5, bobNewScale.getStartTime());
    assertEquals(6, bobNewScale.getEndTime());
  }

  

 }

