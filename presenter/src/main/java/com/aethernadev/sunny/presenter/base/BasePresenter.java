package com.aethernadev.sunny.presenter.base;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BasePresenter<UI> {
   protected UI ui;
   protected Queue<UIAction<UI>> uiActions = new LinkedList<>();

    public void attachUI(UI ui) {
        this.ui = ui;
        executeWaitingActions();
    }

    public void detachUI() {
        this.ui = null;
    }

    public void execute(UIAction<UI> uiAction) {
        uiActions.add(uiAction);
        executeWaitingActions();
    }

    private void executeWaitingActions() {
        if (ui == null) {
            return;
        }

        UIAction action;
        while ((action = uiActions.poll()) != null) {
            action.execute(ui);
        }
    }

}
