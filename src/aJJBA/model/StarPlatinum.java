package aJJBA.model;

import aJJBA.model.Enemy;
import aJJBA.model.Stand;

import java.util.ArrayList;

public class StarPlatinum implements Stand {

    // Variables

    String name = "Star Platinum";
    int position = 0;
    double health = 500;

    int a1Cost = 10;
    int a2Cost = 2;
    int a3Cost = 6;

    String a1Feedback;

    String a1Name = "Punch";
    String a2Name = "Star Finger";
    String a3Name = "Ora Barrage";

    public StarPlatinum(int p){
        super();
        position = p;
    }

    // Abilities

    public String ability1(Stand t){
        t.changeHealth(-250);
        return name + " dealt 50 damage to " + t.getName() + " with " + a1Name;
    }

    public void ability2(Stand t){
        t.changeHealth(100);
    }

    public void ability3(Stand t){
        t.changeHealth(-200);
    }

    // Range abilities

    public ArrayList<Stand> inRangeA1(Enemy e){
        ArrayList<Stand> ret = new ArrayList<Stand>();
        for (int i = 0; i < e.getAllStands().size(); i++){
            int epos = e.getStandNum(i).getPosition();
            if (epos == position - 6 ||
                    epos == position - 5 ||
                    epos == position - 4 ||
                    epos == position - 1 ||
                    epos == position + 1 ||
                    epos == position + 4 ||
                    epos == position + 5 ||
                    epos == position + 6){
                ret.add(e.getStandNum(i));
            }
        }
        return ret;
    }

    // Other

    public void changeHealth(double h){
        this.health = this.health + h;
    }

    public boolean isAlive(){
        return health > 0;
    }

    // Getters

    public int getPosition(){
        return position;
    }

    public void setPosition(int i) {position = i;}

    public double getHealth(){
        return health;
    }

    public String getName(){
        return name;
    }

    public int getA1Cost(){ return a1Cost; }
    public int getA2Cost(){ return a2Cost; }
    public int getA3Cost(){ return a3Cost; }

    public String getA1Name(){ return a1Name; }
    public String getA2Name(){ return a2Name; }
    public String getA3Name(){ return a3Name; }

}
