package cs5004.animator.view;

/**
 * This is an interface to be implemented by each of our views. The primary goal of this interface
 * is to encapsulate all types of views, despite the fact that certain views may not utilize
 * certain methods of the interface.
 */

public interface IView {

  /**
   * Method to make the view visible.
   */

  void makeVisible();

  /**
   * Method to refresh the animation in VisualView. This is done in a loop that ends at the last
   * value of the last transformation. The panel's "refresh" method is called for every tick, and
   * then sleeps at whatever rate is inputted at the command line.
   */

  void refreshAnimation();

  /**
   * Outputs the view in a txt/svg file.
   *
   * @param outputFile the output file.
   * @param string the output originated in the view and copied to the outputFile.
   */

  void output(String outputFile, String string);
}
