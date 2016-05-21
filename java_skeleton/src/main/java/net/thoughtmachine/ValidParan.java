package main.java.net.thoughtmachine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Vika
 */
public class ValidParan extends MoveBoat{
    private String input;

    //splitting each coordinate & map it into its movement
    public HashMap<Point,String> movementBoat(String enter){
        HashMap<Point, String> result = new HashMap<>();
        Point pointRes = new Point();
        //split paran and the string
        String entryNew = enter.replaceAll("\\s+","").replaceAll("\\(","");
        ArrayList<String> store  = new ArrayList<>();
        for(String x: entryNew.split("\\)")){
            store.add(x);
        }
        char[] convert=store.get(0).toCharArray();
        pointRes.setLocation(Character.getNumericValue(convert[0]), Character.getNumericValue(convert[2]));

        result.put(pointRes, store.get(1));
        return result;
    }

    public Point sunkBoat(String enter){
        Point pointRes = new Point();
        //split paran and the string
        String entryNew = enter.replaceAll("\\s+","").replaceAll("\\(","");
        ArrayList<String> store  = new ArrayList<>();
        for(String x: entryNew.split("\\)")){
            store.add(x);
        }
        char[] convert=store.get(0).toCharArray();
        pointRes.setLocation(Character.getNumericValue(convert[0]), Character.getNumericValue(convert[2]));

        return pointRes;
    }

}
