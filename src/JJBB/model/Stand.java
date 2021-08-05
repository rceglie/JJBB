package JJBB.model;

import java.util.ArrayList;

public interface Stand {

    // Variables

    ArrayList<String> status = new ArrayList<String>(); // list of all status effects on this stand (may need to be put in stand classes


    // Stand's 3 abilities

    String ability1(Stand t);
    void ability2(Stand t);
    void ability3(Stand t);
    
    
    // Other

    void changeHealth(double h);

    boolean isAlive();

    
    // Getters

    int getPosition();

    void setPosition(int i);

    double getHealth();

    int getA1Cost();
    int getA2Cost();
    int getA3Cost();

    String getA1Name();
    String getA2Name();
    String getA3Name();

    ArrayList<Stand> inRangeA1(Enemy enemy);

    String getName();
}
