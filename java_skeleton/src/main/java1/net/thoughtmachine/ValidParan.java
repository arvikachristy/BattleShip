package main.java1.net.thoughtmachine;

/**
 * Created by Vika on 21/05/2016.
 */

public class ValidParan{

    public ShipStore movingShip(String entry){
        String entryNew = entry.replaceAll("\\s+","").replaceAll("\\(","");
        String[] res = entryNew.split("\\)");
        String[] coordinateNo = res[0].split(","); //found 0,0
        ShipStore newMove = new ShipStore(Integer.parseInt(coordinateNo[0]), Integer.parseInt(coordinateNo[1]), res[1]);
        return newMove;
    }

    public ShipStore shootShip(String entry){
        String entryNew = entry.replaceAll("\\s+","").replaceAll("\\(","").replaceAll("\\)","");
        String[] res = entryNew.split(",");
        ShipStore newShoot = new ShipStore(Integer.parseInt(res[0]), Integer.parseInt(res[1]));
        return newShoot;
    }



}
