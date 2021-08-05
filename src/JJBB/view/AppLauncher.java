package JJBB.view;

import JJBB.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppLauncher extends Application {

    private static BorderPane pane;
    private static TopView tv = new TopView(Main.getModel());
    private static BottomView bv = new BottomView(Main.getModel());

    public void start(Stage stage) {
        stage.setTitle("JJBA");

        pane = new BorderPane();
        pane.setStyle("-fx-border-color: black; -fx-border-width: 3px;");

        pane.setTop(tv.render());
        pane.setBottom(bv.render());

        // Scene setting

        Scene scene = new Scene(pane, 1000, 900); // width, height
        //scene.getStylesheets().add("style/main.css");
        stage.setScene(scene);

        stage.show();
    }

    public static void refresh() {
        pane.setTop(tv.render());
        pane.setBottom(bv.render());
    }
}