package JJBB.view;
import JJBB.model.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SelectTarget implements FXComponent {

    private Model m;

    public SelectTarget(Model model) {
        m = model;
    }

    public Parent render() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        pane.getChildren().add(vbox);



        HBox hbox = new HBox();
        vbox.getChildren().add(hbox);

        for (Stand target : m.getTargets()){
            Button btn1 = new Button();
            btn1.setText(target.getName());
            hbox.getChildren().add(btn1);
            btn1.setStyle("-fx-font: 24 arial;");

            btn1.setOnAction(
                    (event) -> {
                        m.targetSelected(target);
                        AppLauncher.refresh();
                    });
        }

        Label filler = new Label(" ");
        filler.setStyle("-fx-font: 100 arial;");
        vbox.getChildren().add(filler);

        return pane;
    }
}