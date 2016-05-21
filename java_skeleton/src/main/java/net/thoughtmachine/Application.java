package main.java.net.thoughtmachine;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Application {

  private static final String input = "input.txt";

  /*public void loadInput() {
    InputStream is = getClass().getResourceAsStream(input);
    BufferedReader reader = new BufferedReader(new InputStreamReader(is));

    try {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }*/
//****************************string splitter ********************************
  Map<ArrayList<Integer>, Character> coord = new HashMap<>(); //position of the boat

  public void moveBoat(ArrayList<Integer> coordInput, String in){
    if(coord.containsKey(coordInput)){

    }
    else{
      System.out.println("Sorry you did not move any ship!");
    }


  }


  public void giveChar(String entry){
    //splitting content in input
    String entryNew = entry.replaceAll("\\s+","").replaceAll("\\,","");

    for(String x:entryNew.split("\\)")){
      ArrayList coordinate = new ArrayList();
      System.out.println(x);
      char[] xtoChar = x.toCharArray();
      coordinate.add(xtoChar[1]);
      coordinate.add(xtoChar[2]);
      coord.put(coordinate, xtoChar[3]);
    }

    for (Map.Entry<ArrayList<Integer>, Character> entryl : coord.entrySet()) {
      Character value = entryl.getValue();
      System.out.println(" value " + value);
    }
  }


  public int bracketCheck(String enter){ //check if bracket even & return how many ships
    //if error(bracket not equal) or no ship return 0
    int counter= 0;
    int shipAmount = 0;
    for(Character x: enter.toCharArray()){
      if(x=='('){
        counter++;
        shipAmount++;
      }
      else if(x==')'){
        counter--;
      }
    }
    if(counter!=0){
      return 0;
    }
    return shipAmount;
  }


  public List<String> fileReader(String inputFilePath) {
    ArrayList<String> lines = new ArrayList<>();

    try {
      return Files.readAllLines(Paths.get(inputFilePath));
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return lines;
  }

  public static void main(String... args) {
    Application app = new Application();
    List<String> lines;
    lines = app.fileReader(input);

    app.giveChar(lines.get(1));
  }
}
