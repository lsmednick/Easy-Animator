import cs5004.animator.view.SVGView;
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

public class SVGViewTest {

//
//if (viewType.equalsIgnoreCase("svg")) {
//    SVGView view1 = new SVGView(model, filename, speed);
//    view1.getState();
//    view1.output(output, view1.getState());
//
//
//}
