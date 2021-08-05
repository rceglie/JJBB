package JJBB.model;

import java.util.ArrayList;

public class Enemy {

    int resolve = 0;
    int standsAlive = 1;
    ArrayList<Stand> stands = new ArrayList<Stand>();

    public Enemy(Stand s){
        stands.add(s);
    } // Constructor

    boolean isAlive(){
        standsAlive = 0;
        for (Stand stand : stands){
            if (stand.isAlive()){
                standsAlive++;
            }
        }
        return standsAlive > 0;
    }

    public int getResolve() { return resolve; }

    public void changeResolve(int i) {resolve = resolve + i;}

    ArrayList<Stand> getAllStands() { return stands; }

    Stand getStandNum(int i){
        return stands.get(i);
    }

    Stand getStand(int s){
        return stands.get(s);
    }

}
