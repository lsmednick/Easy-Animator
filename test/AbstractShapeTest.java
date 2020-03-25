import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractShapeTest {

  @Test
  public void testToString() {
    AbstractShape hi = new Oval(5, 5, 24, 56, 215, 4.5, 7.7, 0, 10, "Carlos");
    assertEquals("Name: Carlos\n"
            + "Type: Oval\n"
            + "Position: (5.0, 5.0)\n"
            + "Width: 4.5\n"
            + "Height: 7.7\n"
            + "Color: (24, 56, 215)\n"
            + "Starting Time: 0\n"
            + "End Time: 10", hi.toString());
  }

}