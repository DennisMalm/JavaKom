package com.company.controller;

public class OperationObserver extends Observer {

    public OperationObserver(Controller controller){
        this.controller = controller;
        this.controller.attach(this);
    }
    @Override
    public void update() {
        System.out.println("");
    }
}
