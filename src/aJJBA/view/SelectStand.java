package aJJBA.view;
import aJJBA.model.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SelectStand implements FXComponent {

    private Model m;

    public SelectStand(Model model) {
        m = model;
    }

    public Parent render() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        pane.getChildren().add(vbox);



        HBox hbox = new HBox();
        vbox.getChildren().add(hbox);

        int i = 0;

        Button btn1 = new Button();
        btn1.setText(m.getPlayerStand(0).getName());
        hbox.getChildren().add(btn1);
        btn1.setStyle("-fx-font: 24 arial;");

        btn1.setOnAction(
                (event) -> {
                    m.standSelected(i);
                    AppLauncher.refresh();
                });

        Label filler = new Label(" ");
        filler.setStyle("-fx-font: 100 arial;");
        vbox.getChildren().add(filler);

        return pane;
    }
}