package aJJBA;

import aJJBA.model.*;


public class ControllerImpl implements Controller {

    private Model model;
    private String message;

    public ControllerImpl(Model model) {
        this.model = model;
        message = "";
    }

    @Override
    public Stand getPlayerStand(int i) {
        return model.getPlayerStand(i);
    }
    public Stand getEnemyStand(int i) {
        return model.getEnemyStand(i);
    }
}