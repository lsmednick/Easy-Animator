import org.junit.Test;

import cs5004.animator.model.AbstractShape;
import cs5004.animator.model.Oval;
import cs5004.animator.model.Rectangle;

import static org.junit.Assert.assertEquals;

/**
 * This is a JUnit test class that the AbstractShape abstract class and the concrete classes that
 * extend it (Oval and Rectangle). Testing Exceptions for Invalid input AbstractShape
 * Constructor. Oval and Rectangle calls the super class AbstractShape to instantiate all
 * parameters. Exceptions are thrown in  AbstractShape's constructor. IllegalArgumentException
 * thrown if width or height is below 0. IllegalArgumentException thrown  if rgb values are not
 * between 0-255 inclusive. IllegalArgumentException thrown  if the x or y-coordinates are negative
 * (we're assuming the display will only work within the first quadrant, i.e. only positive x and y
 * values -- this may be modified upon further instruction). IllegalArgumentException thrown if the
 * String name is null.
 */

public class ShapeTest {

  // Testing ovals
  @Test
  public void testOval() {
    AbstractShape bob = new Oval(1, 2, 3, 4, 5, 6, 7, "Bob");
    assertEquals(1, bob.getX(), 0.01);
    assertEquals(2, bob.getY(), 0.01);
    assertEquals(3, bob.getR(), 0.01);
    assertEquals(4, bob.getG(), 0.01);
    assertEquals(5, bob.getB(), 0.01);
    assertEquals(6, bob.getWidth(), 0.01);
    assertEquals(7, bob.getHeight(), 0.01);
    assertEquals("Bob", bob.getName());
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidRedNegative() {
    new Oval(1, 2, -3, 4, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidRedGreaterThanMax() {
    new Oval(1, 2, 256, 4, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidGreenNegative() {
    new Oval(1, 2, 3, -4, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidGreenGreaterThanMax() {
    new Oval(1, 2, 4, 256, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidBlueNegative() {
    new Oval(1, 2, 3, 4, -5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidBlueGreaterThanMax() {
    new Oval(1, 2, 3, 4, 256, 6, 7, "Bob");
  }

  // IllegalArgumentException thrown if width or height is below 0.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidWidth() {
    new Oval(1, 2, 3, 4, 5, -6, 7, "Bob");
  }

  // IllegalArgumentException thrown if width or height is below 0.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidHeight() {
    new Oval(1, 2, 3, 4, 5, 6, -7, "Bob");
  }

  //IllegalArgumentException thrown if String name is null.
  @Test(expected = IllegalArgumentException.class)
  public void testOvalStringNameNull() {
    new Oval(1, 2, 3, 4, 5, 6, 7, null);
  }

  // Testing Rectangles
  @Test
  public void testRectangle() {
    AbstractShape bob = new Rectangle(1, 2, 3, 4, 5, 6, 7, "Bob");
    assertEquals(1, bob.getX(), 0.01);
    assertEquals(2, bob.getY(), 0.01);
    assertEquals(3, bob.getR(), 0.01);
    assertEquals(4, bob.getG(), 0.01);
    assertEquals(5, bob.getB(), 0.01);
    assertEquals(6, bob.getWidth(), 0.01);
    assertEquals(7, bob.getHeight(), 0.01);
    assertEquals("Bob", bob.getName());
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidRedNegative() {
    new Rectangle(1, 2, -3, 4, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidRedGreaterThanMax() {
    new Rectangle(1, 2, 256, 4, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidGreenNegative() {
    new Rectangle(1, 2, 3, -4, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidGreenGreaterThanMax() {
    new Rectangle(1, 2, 4, 256, 5, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidBlueNegative() {
    new Rectangle(1, 2, 3, 4, -5, 6, 7, "Bob");
  }

  // IllegalArgumentException thrown  if rgb values are not between 0-255 inclusive.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidBlueGreaterThanMax() {
    new Rectangle(1, 2, 3, 4, 256, 6, 7, "Bob");
  }

  //IllegalArgumentException thrown if width is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidWidth() {
    new Rectangle(1, 2, 3, 4, 5, -6, 7, "Bob");
  }

  //IllegalArgumentException thrown if height is negative.
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleInvalidHeight() {
    new Rectangle(1, 2, 3, 4, 5, 6, -7, "Bob");
  }

  //IllegalArgumentException thrown if String name is null
  @Test(expected = IllegalArgumentException.class)
  public void testRectangleStringNameNull() {
    new Rectangle(1, 2, 3, 4, 5, 6, 7, null);
  }
}