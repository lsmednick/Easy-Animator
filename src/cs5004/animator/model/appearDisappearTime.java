package cs5004.animator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TODO  -- set appear/disappear time in AnimatorModelImpl

public class appearDisappearTime {

  List<String> list = new ArrayList<>();
  Map<String, String > mapDisappear = new HashMap<>();
  Map<String, String > mapAppear = new HashMap<>();

   String shapeID2;
   String disappearTime;
   String appearTime;

  public void appearDisappear(String filename) {

  //parse a file if it contains the shape
  File file = new File(filename);
  Scanner in;

  try {
    in = new Scanner(file);
    while (in.hasNext()) {
      String line = in.nextLine();

      //TODO -- Not sure if we need this -- can delete
      //if line has exactly 3 words in it, we know it declares a shape -- add it to 'list'
      if (line.length() > 0 && line.split("\\s+").length == 3) {
        String shapeID = line.split(" ")[1];
        list.add(shapeID);
      }

      //if line has exactly 18 words in it, we know it is a transformation
      // mapDisappear
//      if (line.length() > 0 && line.split("\\s+").length == 18) {
//        mapDisappear.put(line.split(" ")[1], line.split(" ")[11]);
//        try {
//          mapAppear.get(line.split(" ")[1]).toString();
//        } catch (Exception e) {
//          mapAppear.put(line.split(" ")[1], line.split(" ")[11]);
//        }
//      }
//    }
      //For lines that declare transformations -- put appear/disappear times into a map
      if (line.length() > 0 && line.split("\\s+").length == 18){
        shapeID2 = line.split(" ")[1];
        disappearTime = line.split(" ")[11];
        appearTime = line.split(" ")[2];
        // map for each unique shape at what tick it disappears
        mapDisappear.put(shapeID2,disappearTime);
        // map for each unique shape at the first tick it appears
        try {
          mapAppear.get(shapeID2);
        } catch (Exception e) {
          mapAppear.put(shapeID2,appearTime);
        }
      }
    }

  } catch (FileNotFoundException e) {
    e.printStackTrace();
  }

//        //for testing only
//        for(Object shape:list) {
//           System.out.println("shape list = " + shape);
//        }
//        for(Object name:mapDisappear.keySet()) {
//            String key = name.toString();
//            String value = mapDisappear.get(name).toString();
//            System.out.println("mapDisappear: " + key + " " + value);
//        }
//        for( Object name:mapAppear.keySet()) {
//          String key = name.toString();
//          String value = mapAppear.get(name).toString();
//          System.out.println("mapAppear: " + key + " " + value);
//        }

    }

}





