package main.java1.net.thoughtmachine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

  private static final String input = "input.txt";
  private static int board;
  private static ShipStore[][] boardArray;
  private static ArrayList<ShipStore> deadShip = new ArrayList<>();


  public void sunkShip(ShipStore coordInput){
    int xDir = coordInput.getX();//9
    int yDir = coordInput.getY(); //2
    if(boardArray[xDir][yDir] != null) { //if there's a boat to shoot
      deadShip.add(boardArray[xDir][yDir]);
      boardArray[xDir][yDir]=null;
    }
    else{
      System.out.println("Sorry you didn't shoot anything");
    }
  }

  public void moveBoat(ShipStore coordInput){
    char[] rotate = {'N','E','S','W'};
    int xDir = coordInput.getX();//0
    int yDir = coordInput.getY(); //0
    char[] dir = coordInput.getDir().toCharArray(); //M,MRELM
    if(boardArray[xDir][yDir] != null) { //if coord exist in the list of boats, get its nav
      ShipStore newPosition = new ShipStore(xDir,yDir,boardArray[xDir][yDir].getDir());
      int xNew = newPosition.getX(); //0 now copy
      int yNew = newPosition.getY(); //0 now copy
      char initialDir = newPosition.getDir().charAt(0);//N now copy

      for (Character x : dir) {
          if(x=='R') {
            int p=0;
              while(p<rotate.length-1){
                if(initialDir=='W'){
                  initialDir = 'N';
                  p=rotate.length-1;
                }
                if (initialDir == rotate[p]) {
                initialDir = rotate[p + 1];
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
            if(initialDir=='N'){
              initialDir = 'W';
              p=0;
            }
            if (initialDir == rotate[p]) {
              initialDir = rotate[p - 1];
              p=0;
            }
            else{
              p--;
            }
          }
        }
        if(x=='M'){
          //assuming if it hits the wall, it wont do anything
          if(initialDir=='N' && newPosition.getY()+1<= board){
            yNew++;
          }
          if(initialDir=='E' && newPosition.getX()+1 <=board){
            xNew++;
          }
          if(initialDir=='S' && newPosition.getY()-1>=0){
            yNew--;
          }
          if(initialDir=='W' && newPosition.getX()-1 >=0){
            xNew--;
          }
        }
      }
      boardArray[xDir][yDir]= null;
      ShipStore finalShip = new ShipStore(xNew,yNew,Character.toString(initialDir));
      boardArray[xNew][yNew] = finalShip;
    }
    else{
      System.out.println("Sorry you did not move or rotate any ship!");
    }

  }

  public void setBoat(String entry){
    String entryNew = entry.replaceAll("\\s+","").replaceAll("\\(","");

    for(String k:entryNew.split("\\)")){
      String temp = k;
      for(String i: temp.split("(?<=Alpha)")){
          String[] parts = i.split(",");
          ShipStore newShip = new ShipStore(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), parts[2]);//store the ship located
          boardArray [newShip.getX()][newShip.getY()] = newShip;
      }
    }
  }

  public static void main(String... args) throws IOException {
    Application app = new Application();
    FileReader read = new FileReader();
    List<String> lines;
    lines = read.fileReader(input);

    if(lines.size()<2){
      System.out.println("Please input initial ships!");
    }else {
      //Setting up the board...
      board = Integer.parseInt(lines.get(0));
      boardArray = new ShipStore[board][board];

      //Setting up the ships...
      app.setBoat(lines.get(1));

      //storing all move and sunk shots tryout 2
      ValidParan paran = new ValidParan();

      for (int x = 2; x < lines.size(); x++) {
        String newLine = lines.get(x).replaceAll("\\s+", "");
        if (lines.get(x).isEmpty()) {
          continue;
        }
        if (newLine.charAt(newLine.length() - 1) != ')') { //it's a movement
          app.moveBoat(paran.movingShip(lines.get(x)));
        } else {//it's a sunk!
          app.sunkShip(paran.shootShip(lines.get(3)));
        }
      }
      ArrayList<ShipStore> printRes = new ArrayList<>();
      for (int q = 0; q < board; q++) {
        for (int z = 0; z < board; z++) {
          if (boardArray[q][z] != null) {
            printRes.add(boardArray[q][z]);
          }
        }
      }
      PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
      for (ShipStore f : printRes) {
        out.println("(" + f.getX() + "," + f.getY() + "," + f.getDir() + ")");
      }
      for (ShipStore m : deadShip) {
        out.println("(" + m.getX() + "," + m.getY() + "," + m.getDir() + ")" + " SUNK");
      }
      out.close();
    }
  }
}
