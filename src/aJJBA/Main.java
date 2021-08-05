package aJJBA;

import aJJBA.view.*;
import aJJBA.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

    private static Model model;

    public static void main(String[] args) {

        model = new ModelImpl();

        Application.launch(AppLauncher.class);
    }

    public static Model getModel() {
        return model;
    }
}
