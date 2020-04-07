package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * This abstract class implements view interface and declares a common method
 * used by both the text and the SVG view to output its result in a file. The
 * method creates a txt or svg file and also throws an IOException if no output
 * file fails.
 */

public abstract class AbstractView implements IView {

  @Override
  public void output(String outputFile, String string) {
    System.out.println("Printing text view in the file " + outputFile + "\n");

    try {
      BufferedWriter output;
      if (outputFile.equals("System.out")) {
        output = new BufferedWriter(new OutputStreamWriter(System.out));
      } else {
        File outFile = new File(outputFile);
        output = new BufferedWriter(new FileWriter(outFile));
      }
      output.write(string);
      output.close();
    } catch (IOException iea) {
      System.out.println("Output file " + outputFile + " failed");
    }
  }
}
