package JJBB;

import JJBB.view.*;
import JJBB.model.*;
import javafx.application.Application;

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
