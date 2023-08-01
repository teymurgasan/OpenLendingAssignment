package pages.com.OpenLending;

import org.openqa.selenium.By;
import ui.BasePage;
import ui.Element;

public class ResourcesPage extends BasePage {

    public Element loadMoreButton = new Element(By.xpath("//button [@class='facetwp-load-more']"), "Load More Button");
    public Element blogHeader = new Element(By.xpath("//div [@class='lenders-featured-text-box'] /div[@class='paragraph-p2'] /p"), "Blog Header");
}
