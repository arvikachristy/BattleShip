package main.java.net.thoughtmachine;


import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

  private static final String input = "input.txt";
  static Map<Point, Character> coord = new HashMap<>(); //position of the boat
  ArrayList<Point> boatsList = new ArrayList<>();
  static int board;

  public void moveBoat(Point coordInput, String in){
    char[] inArray = in.toCharArray();
    char[] rotate = {'N','E','S','W'};
    if(coord.containsKey(coordInput)) { //if coord exist in the list of boats, get its nav
      char dir = coord.get(coordInput); //getting navigation
      Point newPosition = new Point();
      newPosition.setLocation(coordInput);

      for (Character x : inArray) {
       System.out.println("dir" + dir +"input" +x);
          if(x=='R') {
            int p=0;
              while(p<rotate.length-1){
                if(dir=='W'){
                  dir = 'N';
                  p=rotate.length-1;
                }
                if (dir == rotate[p]) {
                dir = rotate[p + 1];
                p=rotate.length-1;
              }
              else{
                p++;
              }
            }
        }
        if(x=='L'){
          int p=3;
          while(p>0){
            if(dir=='N'){
              dir = 'W';
              p=0;
            }
            if (dir == rotate[p]) {
              dir = rotate[p - 1];
              p=0;
            }
            else{
              p--;
            }
          }
        }
        if(x=='M'){
          //assuming if it hits the wall, it wont do anything
          if(dir=='N' && newPosition.y+1<= board){
            newPosition.y++;
          }
          if(dir=='E' && newPosition.x+1 <=board){
            newPosition.x++;
          }
          if(dir=='S' && newPosition.y-1>=0){
            newPosition.y--;
          }
          if(dir=='W' && newPosition.x-1 >=0){
            newPosition.x--;
          }
        }
      }
      coord.put(newPosition, dir);
      coord.remove(coordInput);
      System.out.println(newPosition);
    }
    else{
      System.out.println("Sorry you did not move or rotate any ship!");
    }

  }

//***QUeSTION 2****
  public void giveChar(String entry){
    //splitting content in input
    String entryNew = entry.replaceAll("\\s+","").replaceAll("\\,","");

    for(String x:entryNew.split("\\)")){
      Point newboat = new Point();
      char[] xtoChar = x.toCharArray();
      newboat.setLocation(Character.getNumericValue(xtoChar[1]),Character.getNumericValue(xtoChar[2]));
      System.out.println(newboat.getLocation());
      coord.put(newboat, xtoChar[3]);
    }

    for (Map.Entry<Point, Character> entryl : coord.entrySet()) {
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
    board = Integer.parseInt(lines.get(0));

    app.giveChar(lines.get(1));
    for (Map.Entry<Point, Character> entry : coord.entrySet()) {
      System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
    }
    //testing
    Point poo = new Point();
    poo.setLocation(0,0);
    app.moveBoat(poo, "MRMLMM");

    for (Map.Entry<Point, Character> entry : coord.entrySet()) {
      System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
    }
  }
}
