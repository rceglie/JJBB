package JJBB.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);



        // Make the stands

        StarPlatinum tester = new StarPlatinum(14);
        EnemyStand enemyStand = new EnemyStand(8);

        // Make the player + enemy

        Player player = new Player(tester);
        Enemy enemy = new Enemy(enemyStand);

        player.changeResolve(5);

        int c1; // Stand choice
        int c2; // Action choice
        int c3 = 0; // Ability choice

        while(player.isAlive() && enemy.isAlive()) {

            printMap(player.getStand(0), enemy.getStand(0)); // prints the map

            System.out.print("Select a stand: ");
            c1 = scan.nextInt() - 1;
            System.out.print("What do you want to do with " + player.getStand(c1).getName() + "?\n(1) Use Ability\n(2) Move\n(3) Back\n(1/2/3): ");
            c2 = scan.nextInt();

            if (c2 == 1) {   // If they choose to attack

                System.out.printf("Select an ability:\n(1) %s\n(2) %s\n(3) %s\n(4) Back\n(1/2/3/4): ", player.getStand(c1).getA1Name(), player.getStand(c1).getA2Name(), player.getStand(c1).getA3Name()); // gets user to select a move
                c3 = scan.nextInt();

                ArrayList<Stand> standsInRange = new ArrayList<Stand>(); // Variable to store stands in range in
                switch (c3) { // Choice of ability
                    case 1:
                        System.out.println("What enemy? Enemies in range: ");
                        standsInRange = player.getStand(c1).inRangeA1(enemy); // gets all stands in range
                        for (int j = 0; j < standsInRange.size(); j++) {
                            System.out.println(j + 1 + ". " + standsInRange.get(j).getName()); // prints name of every stand in range
                        }
                        break;
                }

                if (c3 != 4) {  // Implements back functionality
                    Stand target = standsInRange.get(scan.nextInt() - 1);
                    System.out.print("Your " + player.getStand(c1).ability1(target) + "\n"); // Does ability and prints feedback

                    if (!target.isAlive()) {
                        System.out.println(target.getName() + " has died");
                        enemy.standsAlive--;
                    }
                }

            } else if (c2 == 2) { // If they choose to move

                System.out.print("Move to what square? (Costs 1 R): ");
                int c6 = scan.nextInt();
                player.getStand(c1).setPosition(c6);
                player.changeResolve(-1);

            }


            if (c2 != 3 && c3 != 4){   // Implements back functionality
                enemyMove(player, enemy);

                nextRound(player, enemy); // calls for next round
                System.out.println("NEXT ROUND");
            }

        }

    }

    public static void nextRound(Player p, Enemy e){
        p.changeResolve(5);
        e.changeResolve(5);
    }

    public static void enemyMove(Player p, Enemy e){
        if (e.isAlive()) {
            printStands(p, e);
            e.getStand(0).ability1(p.getStand(0));
            System.out.print("Enemy used ability 1 \n");
            if (!p.isAlive())
                System.out.println("You have died");
            else {
                printStands(p, e);
            }
        }
    }

    public static void printStands(Player p, Enemy e){
        System.out.println("\nPlayer: " + p.getResolve() + " Resolve");
        System.out.println("\t" + p.getStand(0).getName() + ": (" + p.getStand(0).getHealth() + " HP)");
        System.out.println("Enemy");
        System.out.println("\t" + e.getStand(0).getName() + ": (" + e.getStand(0).getHealth() + " HP)\n");
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
