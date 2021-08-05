package aJJBA.view;

import aJJBA.Main;
import aJJBA.model.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class BottomView implements FXComponent {

    private Model m;

    public BottomView(Model model) {
        m = model;
    }

    public Parent render() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().removeAll();

        VBox v1 = new VBox();
        pane.getChildren().add(v1);
        Label resolve = new Label(m.getPlayer().getResolve() + "");
        v1.getChildren().add(resolve);

        if (m.getGameStatus() == 0){
            SelectStand ss = new SelectStand(Main.getModel());
            v1.getChildren().add(ss.render());
        } else if (m.getGameStatus() == 1){
            SelectAction sa = new SelectAction(Main.getModel());
            v1.getChildren().add(sa.render());
        } else if (m.getGameStatus() == 2){
            SelectTarget st = new SelectTarget(Main.getModel());
            v1.getChildren().add(st.render());
        } else if (m.getGameStatus() > 2){
            GameOver go = new GameOver(Main.getModel());
            v1.getChildren().add(go.render());
        }

        return pane;
    }
}