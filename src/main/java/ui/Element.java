package ui;

import org.openqa.selenium.By;

public class Element {

    public final By locator;
    public final String name;

    public Element(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }
}
