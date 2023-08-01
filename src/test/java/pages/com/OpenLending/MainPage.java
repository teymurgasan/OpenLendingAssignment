package pages.com.OpenLending;

import org.openqa.selenium.By;
import ui.BasePage;
import ui.Element;

public class MainPage extends BasePage {

    public Element resourcesButton = new Element(By.xpath("//ul[@class='navbar-nav'] //a[contains(text(), 'Resources')]"), "Resources Button");
}
