package aJJBA.view;
import aJJBA.model.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TopView implements FXComponent{

    private Model m;

    public TopView(Model model) {
        m = model;
    }

    public Parent render() {

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);

        // Vbox

        VBox vbox = new VBox();
        pane.getChildren().add(vbox);

        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(new Label(""));

        // Victory message
        Label playerStand = new Label(m.getPlayerStand(0).getName() + ": " + Math.round(m.getPlayerStand(0).getHealth()) + " HP");
        playerStand.setStyle("-fx-font: 24 arial;");
        //HBox hbox = new HBox(name);
        //hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(playerStand);
        playerStand.setVisible(true);

        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(new Label(""));

        Label enemyStand = new Label(m.getEnemyStand(0).getName() + ": " + Math.round(m.getEnemyStand(0).getHealth()) + " HP");
        enemyStand.setStyle("-fx-font: 24 arial;");
        //HBox hbox = new HBox(name);
        //hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(enemyStand);
        enemyStand.setVisible(true);

        vbox.setAlignment(Pos.CENTER);

        return pane;
    }

}
