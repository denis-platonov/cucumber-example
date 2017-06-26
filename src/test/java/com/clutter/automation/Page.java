package com.clutter.automation;

public abstract class Page {

    String URL;

    public abstract boolean isOpened();
    public abstract void goTo();

}
