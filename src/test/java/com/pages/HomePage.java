package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.pages.data.IMenuLeaf;

import lombok.var;

/** Sample page */
public class HomePage extends Page {
  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  @FindBy(how = How.CSS, using = "a[href='/#games']")
  @CacheLookup
  public WebElement gamesMenu;

  public <T extends Page> T chooseMenu(IMenuLeaf menu, Class<T> page) {
    var xpath = By.xpath("//a[text()='" + menu.getLeafText() + "']");

    var builder = new Actions(driver);
    var actions = builder.moveToElement(gamesMenu).click(driver.findElement(xpath));
    actions.build().perform();

    var initialized = PageFactory.initElements(driver, page);
    return initialized;
  }
}
