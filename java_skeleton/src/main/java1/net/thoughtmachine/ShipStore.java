package main.java1.net.thoughtmachine;

/**
 * Created by Vika on 21/05/2016.
 */
public class ShipStore {

    private int x;
    private int y;
    private String dir;

    public ShipStore(int x, int y){
        this.x=x;
        this.y=y;
    }

    public ShipStore(int x, int y, String dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getDir(){
        return dir;
    }


}
