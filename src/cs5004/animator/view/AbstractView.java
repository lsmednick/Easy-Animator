package cs5004.animator.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 */

public abstract class AbstractView implements IView {

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
      System.out.println("Could not find file" + outputFile);
    }
  }
}
