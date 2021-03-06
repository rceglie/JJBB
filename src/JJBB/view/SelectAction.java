package JJBB.view;
import JJBB.model.*;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class SelectAction implements FXComponent {

    private Model m;

    public SelectAction(Model model) {
        m = model;
    }

    public Parent render() {
        FlowPane pane = new FlowPane();
        pane.setAlignment(Pos.CENTER);

        VBox vboxbuttons = new VBox();

        Label label = new Label(m.getSStand().getName() + " Actions");
        label.setStyle("-fx-font: 24 arial;");
        vboxbuttons.getChildren().add(label);

        Label f1 = new Label("");
        f1.setStyle("-fx-font: 24 arial;");
        vboxbuttons.getChildren().add(f1);

        HBox hbox = new HBox();
        vboxbuttons.getChildren().add(hbox);

        int i = 0;

        Button btn1 = new Button();
        btn1.setText(m.getSStand().getA1Cost() + "\n" + m.getSStand().getA1Name());
        btn1.textAlignmentProperty().set(TextAlignment.CENTER);
        btn1.setStyle("-fx-font: 24 arial;");
        hbox.getChildren().add(btn1);

        btn1.setOnAction(
                (event) -> {
                    m.a1Selected();
                    AppLauncher.refresh();
                });

        btn1.setDisable(m.getSStand().getA1Cost() > m.getPlayer().getResolve());

        Label f3 = new Label(" ");
        f3.setMinWidth(125);
        hbox.getChildren().add(f3);

        Button btn2 = new Button();
        btn2.setText(m.getSStand().getA2Cost() + "\n" + m.getSStand().getA2Name());
        btn2.textAlignmentProperty().set(TextAlignment.CENTER);
        hbox.getChildren().add(btn2);
        btn2.setStyle("-fx-font: 24 arial;");

        btn2.setOnAction(
                (event) -> {
                    m.a2Selected();
                    AppLauncher.refresh();
                });

        Label f4 = new Label(" ");
        f4.setStyle("-fx-font: 50 arial;");
        vboxbuttons.getChildren().add(f4);

        HBox secondRow = new HBox();
        vboxbuttons.getChildren().add(secondRow);

        Button btn3 = new Button();
        btn3.setText(m.getSStand().getA3Cost() + "\n" + m.getSStand().getA3Name());
        btn3.textAlignmentProperty().set(TextAlignment.CENTER);
        secondRow.getChildren().add(btn3);
        btn3.setStyle("-fx-font: 24 arial;");

        btn3.setOnAction(
                (event) -> {
                    m.a3Selected();
                    AppLauncher.refresh();
                });

        Label f2 = new Label(" ");
        f2.setMinWidth(125);
        secondRow.getChildren().add(f2);

        Button btn4 = new Button();
        btn4.setText("1\nMove");
        btn4.textAlignmentProperty().set(TextAlignment.CENTER);
        secondRow.getChildren().add(btn4);
        btn4.setStyle("-fx-font: 24 arial;");

        btn4.setOnAction(
                (event) -> {
                    m.moveSelected();
                    AppLauncher.refresh();
                });

        Label f5 = new Label(" ");  // Bottom filler
        f5.setStyle("-fx-font: 50 arial;");
        vboxbuttons.getChildren().add(f5);

        vboxbuttons.setAlignment(Pos.CENTER);

        HBox sections = new HBox();

        // Picture of stand

        Label standPic = new Label("stand pic");
        VBox storePic = new VBox(standPic);
        storePic.setAlignment(Pos.CENTER);
        HBox temp1 = new HBox(storePic);
        temp1.setMinWidth(250);
        temp1.setMaxWidth(250);
        temp1.setAlignment(Pos.CENTER);
        sections.getChildren().add(temp1);

        sections.getChildren().add(vboxbuttons);

        // Resolve Amount

        Label resolveLabel = new Label("CURRENT\nRESOLVE");
        resolveLabel.setStyle("-fx-font: 26 arial;");
        Label resolveAmount = new Label(m.getPlayer().getResolve() +"\n ");
        resolveAmount.setStyle("-fx-font: 30 arial;");
        VBox storeResolve = new VBox(resolveAmount, resolveLabel);
        storeResolve.setAlignment(Pos.CENTER);
        HBox temp2 = new HBox(storeResolve);
        temp2.setMinWidth(250);
        temp2.setMaxWidth(250);
        temp2.setAlignment(Pos.CENTER);
        sections.getChildren().add(temp2);

        pane.getChildren().add(sections);
        return pane;
    }
}