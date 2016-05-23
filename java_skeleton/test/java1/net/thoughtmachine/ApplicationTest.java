package java1.net.thoughtmachine;

import main.java1.net.thoughtmachine.ShipStore;
import main.java1.net.thoughtmachine.ValidParan;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
  ValidParan moveTest = new ValidParan();

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
