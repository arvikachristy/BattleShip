package java1.net.thoughtmachine;

import main.java1.net.thoughtmachine.ShipStore;
import main.java1.net.thoughtmachine.ValidParan;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ApplicationTest {
  ValidParan moveTest = new ValidParan();

  static int board = 15;
  static ShipStore[][] boardArray= new ShipStore[board][board];
  ArrayList<ShipStore> deadShip = new ArrayList<>();

  @Before
  public void setup(){
    ShipStore initialShips = new ShipStore(0,3,"E");
    boardArray[0][3] = initialShips;
  }

  @Test
  public void testShootShip (){
    ShipStore shootShip = new ShipStore(0,3,"S");
    assertEquals(shootShip.getX(),boardArray[0][3].getX());
    assertNotEquals(shootShip.getDir(),boardArray[0][3].getDir());
  }


  @Test
  public void testMoveParser() {
    int xDir = 0;
    int yDir = 1;
    String dir = "M";
    ShipStore coordInput = new ShipStore(xDir,yDir, dir);

    assertEquals(coordInput.getX(), moveTest.movingShip("(0, 1) M").getX());
    assertEquals(coordInput.getY(), moveTest.movingShip("(0, 1) M    ").getY());
    assertEquals(coordInput.getDir(), moveTest.movingShip("(0, 1) M").getDir());
  }


  @Test
  public void testSinkParser() {
    int xDir = 0;
    int yDir = 1;
    ShipStore coordInput = new ShipStore(xDir,yDir);
    assertEquals(coordInput.getX(), moveTest.shootShip("       (  0,1)").getX());
    assertEquals(coordInput.getY(), moveTest.shootShip("(0        ,1)").getY());
  }







}
