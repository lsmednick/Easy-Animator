import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ShapeTest {

  @Test
  public void testOval() {
    AbstractShape bob = new Oval(1.1,2.1,3,4,5,6.1,7.1,8,
            9, "Bob");
    assertEquals(1.1, bob.getX(),0.01);
    assertEquals(2.1, bob.getY(), 0.01);
    assertEquals(3, bob.getR(), 0.01);
    assertEquals(4, bob.getG(), 0.01);
    assertEquals(5, bob.getB(), 0.01);
    assertEquals(6.1, bob.getWidth(), 0.01);
    assertEquals(7.1, bob.getHeight(), 0.01);
    assertEquals(8, bob.getStartTime(), 0.01);
    assertEquals(9, bob.getEndTime(), 0.01);
    assertEquals("Bob", bob.getName());
  }





  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidRedNegative(){
    AbstractShape bob = new Oval(1.1,2.1,-3,4,5,6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidRedGreaterThanMax(){
    AbstractShape bob = new Oval(1.1,2.1,256,4,5,6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidGreenNegative(){
    AbstractShape bob = new Oval(1.1,2.1,3,-4,5,6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidGreenGreaterThanMax(){
    AbstractShape bob = new Oval(1.1,2.1,4,256,5,6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidBlueNegative(){
    AbstractShape bob = new Oval(1.1,2.1,3,4,-5,6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidBlueGreaterThanMax(){
    AbstractShape bob = new Oval(1.1,2.1,3,4, 256,6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidWidth(){
    AbstractShape bob = new Oval(1.1,2.1,3,4,5,-6.1,7.1,8,
            9, "Bob");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOvalInvalidHeight(){
    AbstractShape bob = new Oval(1.1,2.1,3,4,5,6.1,-7.1,8,
            9, "Bob");
  }



}