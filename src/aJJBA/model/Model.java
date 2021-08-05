package aJJBA.model;

import aJJBA.model.*;

import java.util.ArrayList;

public interface Model {

    public void standSelected(int i);
    public void a1Selected();
    public void a2Selected();
    public void a3Selected();
    public void targetSelected(Stand target);
    public void moveSelected();
    public void enemyTurn();
    public void nextRound();

    public int getGameStatus();
    public Stand getSStand();
    public Stand getPlayerStand(int i);
    public Stand getEnemyStand(int i);
    public ArrayList<Stand> getTargets();
    public Player getPlayer();

}
