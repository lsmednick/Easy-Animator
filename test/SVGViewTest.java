import cs5004.animator.view.SVGView;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import cs5004.animator.EasyAnimator;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;


import static org.junit.Assert.assertEquals;


/**
 * This is a JUnit test class to evaluate if this animator's SVG view produces an accurate
 * output. SVG View class should produce a string that describes the animation, particularly
 * providing a description of the shape's attributes and and transformations.
 */

public class SVGViewTest {

  // Test that the SVGView produces the correct string output
  @Test
  public void TextualViewTest1() throws FileNotFoundException {

    AnimatorModel model;
    String filename = "toh-3.txt";
    Readable inFile = new FileReader(filename);

    AnimationBuilder<AnimatorModel> builder =
            new AnimationBuilderImpl();

    model = AnimationReader.parseFile(inFile, builder);
    SVGView view = new SVGView(model, filename, 1);
    assertEquals("<svg width=\"410\" height=\"220\" viewBox=\"145 50 555 270\" "
            + "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
            + "<rect id=\"disk1\" x=\"190\" y=\"180\" width=\"20\" height=\"30\" "
            + "fill=\"rgb(0,49,90)\" >\n"
            + "<animate attributeType=\"xml\" begin=\"25000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"180.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"36000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"47000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"89000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"490.0\" to=\"340.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"111000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"153000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"164000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"340.0\" to=\"190.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"175000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"217000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"228000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"239000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"180.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"CSS\" begin=\"249000.0ms\" dur=\"8000.0ms\" a"
            + "ttributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,255,0)\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "<rect id=\"disk2\" x=\"167\" y=\"210\" width=\"65\" height=\"30\" "
            + "fill=\"rgb(6,247,41)\" >\n"
            + "<animate attributeType=\"xml\" begin=\"57000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"68000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"167.0\" to=\"317.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"79000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"185000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"196000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"317.0\" to=\"467.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"207000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"CSS\" begin=\"217000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(0,255,0)\" fill=\"freeze\" "
            + "/>\n"
            + "</rect>\n"
            + "<rect id=\"disk3\" x=\"145\" y=\"240\" width=\"110\" height=\"30\" "
            + "fill=\"rgb(11,45,175)\" >\n"
            + "<animate attributeType=\"xml\" begin=\"121000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"132000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"x\" from=\"145.0\" to=\"445.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"143000.0ms\" dur=\"10000.0ms\" "
            + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"CSS\" begin=\"153000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(0,255,0)\" fill=\"freeze\" "
            + "/>\n"
            + "</rect>\n"
            + "</svg>", view.getState());
  }


  // Test that the SVGView produces the correct string output to file
  @Test
  public void TextualViewTest2() throws FileNotFoundException {
    EasyAnimator.main(new String[]{"-in toh-3.txt -view svg -out svgTextOutput.txt -speed 20"});

    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader("svgTextOutput.txt"));
      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();

      while (line != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
        line = bufferedReader.readLine();
      }
      assertEquals("<svg width=\"410\" height=\"220\" viewBox=\"145 50 555 270\" "
              + "version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
              + "<rect id=\"disk1\" x=\"190\" y=\"180\" width=\"20\" height=\"30\" "
              + "fill=\"rgb(0,49,90)\" >\n"
              + "<animate attributeType=\"xml\" begin=\"1250.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"180.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"1800.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"2350.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"4450.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5000.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"490.0\" to=\"340.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"5550.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7650.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8200.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"340.0\" to=\"190.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"8750.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10850.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11400.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"190.0\" to=\"490.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"11950.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"180.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"CSS\" begin=\"12450.0ms\" dur=\"400.0ms\" "
              + "attributeName=\"fill\" from=\"rgb(0,49,90)\" to=\"rgb(0,255,0)\" "
              + "fill=\"freeze\" />\n"
              + "</rect>\n"
              + "<rect id=\"disk2\" x=\"167\" y=\"210\" width=\"65\" height=\"30\" "
              + "fill=\"rgb(6,247,41)\" >\n"
              + "<animate attributeType=\"xml\" begin=\"2850.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"210.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3400.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"167.0\" to=\"317.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"3950.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9250.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"9800.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"317.0\" to=\"467.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"10350.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"210.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"CSS\" begin=\"10850.0ms\" dur=\"400.0ms\" "
              + "attributeName=\"fill\" from=\"rgb(6,247,41)\" to=\"rgb(0,255,0)\" "
              + "fill=\"freeze\" />\n"
              + "</rect>\n"
              + "<rect id=\"disk3\" x=\"145\" y=\"240\" width=\"110\" height=\"30\" "
              + "fill=\"rgb(11,45,175)\" >\n"
              + "<animate attributeType=\"xml\" begin=\"6050.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"240.0\" to=\"50.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"6600.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"x\" from=\"145.0\" to=\"445.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"xml\" begin=\"7150.0ms\" dur=\"500.0ms\" "
              + "attributeName=\"y\" from=\"50.0\" to=\"240.0\" fill=\"freeze\" />\n"
              + "<animate attributeType=\"CSS\" begin=\"7650.0ms\" dur=\"400.0000000000009ms\" "
              + "attributeName=\"fill\" from=\"rgb(11,45,175)\" to=\"rgb(0,255,0)\" fill=\""
              + "freeze\" />\n"
              + "</rect>\n"
              + "</svg>\n", stringBuilder.toString());
      bufferedReader.close();
    } catch (Exception e) {
      // do nothing
    }

  }
}

