package JJBB.view;
import JJBB.model.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class GameOver implements FXComponent{
    private Model m;

    public GameOver(Model m) {
        this.m = m;
    }

    public Parent render(){

        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);

        Label l1 = new Label("");
        if(m.getGameStatus() == 3){
            l1.setText("You won");
        } else if (m.getGameStatus() == 4){
            l1.setText("You lost");
        }
        pane.getChildren().add(l1);

        return pane;
    }

}
