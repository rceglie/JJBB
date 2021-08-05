package JJBB.model;

import java.util.ArrayList;

public class ModelImpl implements Model{

    Player player;
    Enemy enemy;

    int gameStatus;
    // 0 = Select Stand
    // 1 = Select Action
    // 2 = Select Target
    // 3 = You died
    // 4 = You won
    Stand sStand;
    int ability = 0;

    ArrayList<Stand> targets = new ArrayList<>();

    public ModelImpl(){

        StarPlatinum stand1 = new StarPlatinum(13);
        EnemyStand enemyStand = new EnemyStand(7);

        // Make the player + enemy

        player = new Player(stand1);
        enemy = new Enemy(enemyStand);

        gameStatus = 0;

    }

    public void standSelected(int i){
        System.out.println(player.getStand(i).getName() + " was selected");
        sStand = player.getStand(i);
        gameStatus = 1;
        printMap(player.getStand(0),enemy.getStand(0));
    }

    public void a1Selected(){
        if (player.getResolve() >= sStand.getA1Cost()){
            gameStatus = 2;
            System.out.println("Selected ability 1");
            targets = sStand.inRangeA1(enemy);
            ability = 1;
        } else {
            System.out.println("Not enough resolve");
        }
    }

    public void a2Selected(){
        gameStatus = 2;
        System.out.println("Selected ability 1");
    }

    public void a3Selected(){
        gameStatus = 2;
        System.out.println("Selected ability 1");
    }

    public void targetSelected(Stand target){
        switch(ability) {   // Actually uses ability on target
            case 1:
                sStand.ability1(target);
                player.changeResolve(-1 * sStand.getA1Cost());
        }
        // Resets ui
        gameStatus = 0;
        sStand = null;
        ability = 0;

        enemyTurn();
    }

    public void enemyTurn(){
        if (enemy.isAlive()) {
            //printStands(p, e);
            enemy.getStand(0).ability1(player.getStand(0));
            System.out.print("Enemy used ability 1 \n");
            if (!player.isAlive())
                gameStatus = 4;
            else {
                nextRound();
            }
        } else {
            gameStatus = 3;
        }
    }

    public void nextRound(){
        player.changeResolve(5);
        enemy.changeResolve(5);
    }

    public void moveSelected(){
        sStand.setPosition(1);
        System.out.println("Moved stand to 1");
        nextRound();
        gameStatus = 0;
    }

    public int getGameStatus(){
        return gameStatus;
    }

    public Stand getSStand(){
        return sStand;
    }
    @Override
    public Stand getPlayerStand(int i) {
        return player.getStand(i);
    }
    public Stand getEnemyStand(int i) {
        return enemy.getStand(i);
    }
    public ArrayList<Stand> getTargets(){
        return targets;
    }
    public Player getPlayer(){
        return player;
    }

    public static void printMap(Stand a, Stand b){
        for (int i = 1; i<6; i++){
            if (a.getPosition() == i || b.getPosition() == i)
                System.out.print("X ");
            else
                System.out.print("- ");
        }
        System.out.println();
        for (int i = 6; i<11; i++){
            if (a.getPosition() == i || b.getPosition() == i)
                System.out.print("X ");
            else
                System.out.print("- ");
        }
        System.out.println();
        for (int i = 11; i<16; i++){
            if (a.getPosition() == i || b.getPosition() == i)
                System.out.print("X ");
            else
                System.out.print("- ");
        }
        System.out.println();
        for (int i = 16; i<21; i++){
            if (a.getPosition() == i || b.getPosition() == i)
                System.out.print("X ");
            else
                System.out.print("- ");
        }
        System.out.println();
        for (int i = 21; i<26; i++){
            if (a.getPosition() == i || b.getPosition() == i)
                System.out.print("X ");
            else
                System.out.print("- ");
        }
        System.out.println();
    }
}
