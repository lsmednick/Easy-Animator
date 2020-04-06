import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import cs5004.animator.EasyAnimator;
import cs5004.animator.model.AnimatorModel;
import cs5004.animator.model.AnimatorModelImpl;
import cs5004.animator.model.ShapeType;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.IView;
import cs5004.animator.view.AbstractView;
import cs5004.animator.view.AnimationPanel;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.VisualView;

import static org.junit.Assert.assertEquals;


/**
 * This is a JUnit test class to evaluate if this animator's textual view produces an accurate
 * output. Textual View class should produce a string that describes the animation, particularly
 * providing a description of the shape's attributes and and transformations.
 *
 *
 *  * in the form below : -in "name-of-animation-file" -view "type-of-view" -out "where-output-show-go"
 *  * -speed "integer-ticks-per-second".
 */

public class TextualViewTest {

  // Produce a System.out output by reading the file 'toh-3'.txt
  @Test
  public void TextualViewTest1() throws FileNotFoundException {
    AnimatorModel model;
    String filename = "toh-3.txt";
    Readable inFile = new FileReader(filename);

    AnimationBuilder<AnimatorModel> builder =
            new AnimationBuilderImpl();

    model = AnimationReader.parseFile(inFile, builder);
    TextualView view = new TextualView(model, filename, 1);
    assertEquals("Name: disk1\n"
            + "Type: Rectangle\n"
            + "Min corner: (190, 180), Width: 20, Height: 30, Color: (0, 49, 90)\n"
            + "\n"
            + "Name: disk2\n"
            + "Type: Rectangle\n"
            + "Min corner: (167, 210), Width: 65, Height: 30, Color: (6, 247, 41)\n"
            + "\n"
            + "Name: disk3\n"
            + "Type: Rectangle\n"
            + "Min corner: (145, 240), Width: 110, Height: 30, Color: (11, 45, 175)\n"
            + "\n"
            + "disk1 appears at time t=1 and disappears at t=302\n"
            + "disk2 appears at time t=1 and disappears at t=302\n"
            + "disk3 appears at time t=1 and disappears at t=302\n"
            + "\n"
            + "Text view is running at 1.0 ticks per second\n"
            + "\n"
            + "Shape disk1 moves from (190,180) to (190,180) from t=1 to t=1\n"
            + "Shape disk1 moves from (190,180) to (190,180) from t=1 to t=25\n"
            + "Shape disk2 moves from (167,210) to (167,210) from t=1 to t=1\n"
            + "Shape disk2 moves from (167,210) to (167,210) from t=1 to t=57\n"
            + "Shape disk3 moves from (145,240) to (145,240) from t=1 to t=1\n"
            + "Shape disk3 moves from (145,240) to (145,240) from t=1 to t=121\n"
            + "Shape disk1 moves from (190,180) to (190,50) from t=25 to t=35\n"
            + "Shape disk1 moves from (190,50) to (190,50) from t=35 to t=36\n"
            + "Shape disk1 moves from (190,50) to (490,50) from t=36 to t=46\n"
            + "Shape disk1 moves from (490,50) to (490,50) from t=46 to t=47\n"
            + "Shape disk1 moves from (490,50) to (490,240) from t=47 to t=57\n"
            + "Shape disk1 moves from (490,240) to (490,240) from t=57 to t=89\n"
            + "Shape disk2 moves from (167,210) to (167,50) from t=57 to t=67\n"
            + "Shape disk2 moves from (167,50) to (167,50) from t=67 to t=68\n"
            + "Shape disk2 moves from (167,50) to (317,50) from t=68 to t=78\n"
            + "Shape disk2 moves from (317,50) to (317,50) from t=78 to t=79\n"
            + "Shape disk2 moves from (317,50) to (317,240) from t=79 to t=89\n"
            + "Shape disk1 moves from (490,240) to (490,50) from t=89 to t=99\n"
            + "Shape disk2 moves from (317,240) to (317,240) from t=89 to t=185\n"
            + "Shape disk1 moves from (490,50) to (490,50) from t=99 to t=100\n"
            + "Shape disk1 moves from (490,50) to (340,50) from t=100 to t=110\n"
            + "Shape disk1 moves from (340,50) to (340,50) from t=110 to t=111\n"
            + "Shape disk1 moves from (340,50) to (340,210) from t=111 to t=121\n"
            + "Shape disk1 moves from (340,210) to (340,210) from t=121 to t=153\n"
            + "Shape disk3 moves from (145,240) to (145,50) from t=121 to t=131\n"
            + "Shape disk3 moves from (145,50) to (145,50) from t=131 to t=132\n"
            + "Shape disk3 moves from (145,50) to (445,50) from t=132 to t=142\n"
            + "Shape disk3 moves from (445,50) to (445,50) from t=142 to t=143\n"
            + "Shape disk3 moves from (445,50) to (445,240) from t=143 to t=153\n"
            + "Shape disk1 moves from (340,210) to (340,50) from t=153 to t=163\n"
            + "Shape disk3 changes color from (11,45,175) to (0,255,0) from t=153 to t=161\n"
            + "Shape disk3 moves from (445,240) to (445,240) from t=161 to t=302\n"
            + "Shape disk1 moves from (340,50) to (340,50) from t=163 to t=164\n"
            + "Shape disk1 moves from (340,50) to (190,50) from t=164 to t=174\n"
            + "Shape disk1 moves from (190,50) to (190,50) from t=174 to t=175\n"
            + "Shape disk1 moves from (190,50) to (190,240) from t=175 to t=185\n"
            + "Shape disk1 moves from (190,240) to (190,240) from t=185 to t=217\n"
            + "Shape disk2 moves from (317,240) to (317,50) from t=185 to t=195\n"
            + "Shape disk2 moves from (317,50) to (317,50) from t=195 to t=196\n"
            + "Shape disk2 moves from (317,50) to (467,50) from t=196 to t=206\n"
            + "Shape disk2 moves from (467,50) to (467,50) from t=206 to t=207\n"
            + "Shape disk2 moves from (467,50) to (467,210) from t=207 to t=217\n"
            + "Shape disk1 moves from (190,240) to (190,50) from t=217 to t=227\n"
            + "Shape disk2 changes color from (6,247,41) to (0,255,0) from t=217 to t=225\n"
            + "Shape disk2 moves from (467,210) to (467,210) from t=225 to t=302\n"
            + "Shape disk1 moves from (190,50) to (190,50) from t=227 to t=228\n"
            + "Shape disk1 moves from (190,50) to (490,50) from t=228 to t=238\n"
            + "Shape disk1 moves from (490,50) to (490,50) from t=238 to t=239\n"
            + "Shape disk1 moves from (490,50) to (490,180) from t=239 to t=249\n"
            + "Shape disk1 changes color from (0,49,90) to (0,255,0) from t=249 to t=257\n"
            + "Shape disk1 moves from (490,180) to (490,180) from t=257 to t=302", view.getState());
  }

  // Take in toh-3.txt that is file check if the output.txt file is correct
  @Test
  public void TextualViewTest2() throws FileNotFoundException {
    EasyAnimator.main(new String[]{"-in toh-3.txt -view text -out text-transcript2.txt"});

    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader("text-transcript2.txt"));
      StringBuilder stringBuilder = new StringBuilder();
      String line = bufferedReader.readLine();

      while (line != null) {
        stringBuilder.append(line);
        stringBuilder.append("\n");
        line = bufferedReader.readLine();
      }
      assertEquals("Name: disk1\n"
              + "Type: Rectangle\n"
              + "Min corner: (190, 180), Width: 20, Height: 30, Color: (0, 49, 90)\n"
              + "\n"
              + "Name: disk2\n"
              + "Type: Rectangle\n"
              + "Min corner: (167, 210), Width: 65, Height: 30, Color: (6, 247, 41)\n"
              + "\n"
              + "Name: disk3\n"
              + "Type: Rectangle\n"
              + "Min corner: (145, 240), Width: 110, Height: 30, Color: (11, 45, 175)\n"
              + "\n"
              + "disk1 appears at time t=1 and disappears at t=302\n"
              + "disk2 appears at time t=1 and disappears at t=302\n"
              + "disk3 appears at time t=1 and disappears at t=302\n"
              + "\n"
              + "Text view is running at 1.0 ticks per second\n"
              + "\n"
              + "Shape disk1 moves from (190,180) to (190,180) from t=1 to t=1\n"
              + "Shape disk1 moves from (190,180) to (190,180) from t=1 to t=25\n"
              + "Shape disk2 moves from (167,210) to (167,210) from t=1 to t=1\n"
              + "Shape disk2 moves from (167,210) to (167,210) from t=1 to t=57\n"
              + "Shape disk3 moves from (145,240) to (145,240) from t=1 to t=1\n"
              + "Shape disk3 moves from (145,240) to (145,240) from t=1 to t=121\n"
              + "Shape disk1 moves from (190,180) to (190,50) from t=25 to t=35\n"
              + "Shape disk1 moves from (190,50) to (190,50) from t=35 to t=36\n"
              + "Shape disk1 moves from (190,50) to (490,50) from t=36 to t=46\n"
              + "Shape disk1 moves from (490,50) to (490,50) from t=46 to t=47\n"
              + "Shape disk1 moves from (490,50) to (490,240) from t=47 to t=57\n"
              + "Shape disk1 moves from (490,240) to (490,240) from t=57 to t=89\n"
              + "Shape disk2 moves from (167,210) to (167,50) from t=57 to t=67\n"
              + "Shape disk2 moves from (167,50) to (167,50) from t=67 to t=68\n"
              + "Shape disk2 moves from (167,50) to (317,50) from t=68 to t=78\n"
              + "Shape disk2 moves from (317,50) to (317,50) from t=78 to t=79\n"
              + "Shape disk2 moves from (317,50) to (317,240) from t=79 to t=89\n"
              + "Shape disk1 moves from (490,240) to (490,50) from t=89 to t=99\n"
              + "Shape disk2 moves from (317,240) to (317,240) from t=89 to t=185\n"
              + "Shape disk1 moves from (490,50) to (490,50) from t=99 to t=100\n"
              + "Shape disk1 moves from (490,50) to (340,50) from t=100 to t=110\n"
              + "Shape disk1 moves from (340,50) to (340,50) from t=110 to t=111\n"
              + "Shape disk1 moves from (340,50) to (340,210) from t=111 to t=121\n"
              + "Shape disk1 moves from (340,210) to (340,210) from t=121 to t=153\n"
              + "Shape disk3 moves from (145,240) to (145,50) from t=121 to t=131\n"
              + "Shape disk3 moves from (145,50) to (145,50) from t=131 to t=132\n"
              + "Shape disk3 moves from (145,50) to (445,50) from t=132 to t=142\n"
              + "Shape disk3 moves from (445,50) to (445,50) from t=142 to t=143\n"
              + "Shape disk3 moves from (445,50) to (445,240) from t=143 to t=153\n"
              + "Shape disk1 moves from (340,210) to (340,50) from t=153 to t=163\n"
              + "Shape disk3 changes color from (11,45,175) to (0,255,0) from t=153 to t=161\n"
              + "Shape disk3 moves from (445,240) to (445,240) from t=161 to t=302\n"
              + "Shape disk1 moves from (340,50) to (340,50) from t=163 to t=164\n"
              + "Shape disk1 moves from (340,50) to (190,50) from t=164 to t=174\n"
              + "Shape disk1 moves from (190,50) to (190,50) from t=174 to t=175\n"
              + "Shape disk1 moves from (190,50) to (190,240) from t=175 to t=185\n"
              + "Shape disk1 moves from (190,240) to (190,240) from t=185 to t=217\n"
              + "Shape disk2 moves from (317,240) to (317,50) from t=185 to t=195\n"
              + "Shape disk2 moves from (317,50) to (317,50) from t=195 to t=196\n"
              + "Shape disk2 moves from (317,50) to (467,50) from t=196 to t=206\n"
              + "Shape disk2 moves from (467,50) to (467,50) from t=206 to t=207\n"
              + "Shape disk2 moves from (467,50) to (467,210) from t=207 to t=217\n"
              + "Shape disk1 moves from (190,240) to (190,50) from t=217 to t=227\n"
              + "Shape disk2 changes color from (6,247,41) to (0,255,0) from t=217 to t=225\n"
              + "Shape disk2 moves from (467,210) to (467,210) from t=225 to t=302\n"
              + "Shape disk1 moves from (190,50) to (190,50) from t=227 to t=228\n"
              + "Shape disk1 moves from (190,50) to (490,50) from t=228 to t=238\n"
              + "Shape disk1 moves from (490,50) to (490,50) from t=238 to t=239\n"
              + "Shape disk1 moves from (490,50) to (490,180) from t=239 to t=249\n"
              + "Shape disk1 changes color from (0,49,90) to (0,255,0) from t=249 to t=257\n"
              + "Shape disk1 moves from (490,180) to (490,180) from t=257 to t=302\n",
              stringBuilder.toString());
      bufferedReader.close();
    } catch (Exception e) {
      // do nothing
    }
  }



  //  // Take in an .txt that is file and produce an output .txt file that is also empty
//  @Test
//  public void TextualViewTest3() throws FileNotFoundException {
//    AnimatorModel model;
//    String filename = "empty.txt";
//    Readable inFile = new FileReader(filename);
//
//    AnimationBuilder<AnimatorModel> builder =
//            new AnimationBuilderImpl();
//
//    model = AnimationReader.parseFile(inFile, builder);
//    TextualView view = new TextualView(model, filename, 1);
//    view.output("emptyOutput.txt", "");
//
//    BufferedReader bufferedReader = null;
//    try {
//      bufferedReader = new BufferedReader(new FileReader("emptyOutput.txt"));
//      StringBuilder stringBuilder = new StringBuilder();
//      String line = bufferedReader.readLine();
//
//      while (line != null) {
//        stringBuilder.append(line);
//        stringBuilder.append("\n");
//        line = bufferedReader.readLine();
//      }
//      assertEquals("", stringBuilder.toString());
//      bufferedReader.close();
//    } catch (Exception e) {
//      // do nothing
//    }
//  }

//    //TODO
//    // Take in an .txt that is file and produce an output to the console (System.out)
//    // that is also empty
//    @Test
//    public void TextualViewTest4() throws FileNotFoundException {
//      AnimatorModel model;
//      String filename = "empty.txt";
//      Readable inFile = new FileReader(filename);
//
//      AnimationBuilder<AnimatorModel> builder =
//              new AnimationBuilderImpl();
//
//      model = AnimationReader.parseFile(inFile, builder);
//      TextualView view = new TextualView(model, filename, 1);
//      view.output("System.out", "");
//
//      assertEquals(" ", view.getState());
//
//  }




}
