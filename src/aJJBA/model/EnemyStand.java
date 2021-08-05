package aJJBA.model;

import java.util.ArrayList;

public class EnemyStand implements Stand {

    // Variables


    String name = "Enemy Stand";
    int position = 0;
    double health = 500;

    int a1Cost = 0;
    int a2Cost = 0;
    int a3Cost = 0;

    String a1Name = "";
    String a2Name = "";
    String a3Name = "";

    public EnemyStand(int p){
        super();
        position = p;
    }

    // Abilities

    public String ability1(Stand t){
        t.changeHealth(-50);
        return name + " dealt 25 damage to " + t.getName();
    }

    public void ability2(Stand t){

    }

    public void ability3(Stand t){

    }

    // Range functions

    public ArrayList<Stand> inRangeA1(Enemy e){
        ArrayList<Stand> ret = new ArrayList<Stand>();
        return ret;
    }

    // Other

    public void changeHealth(double h){
        this.health = this.health + h;
    }

    // Getters

    public int getPosition(){
        return position;
    }

    public void setPosition(int i) {position = i;}

    public double getHealth(){
        return health;
    }

    public boolean isAlive(){
        return health > 0;
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