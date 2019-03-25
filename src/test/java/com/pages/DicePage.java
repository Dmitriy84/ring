package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import lombok.var;

public class DicePage extends Page {
  @FindBy(how = How.CSS, using = "input[value='Roll Again']")
  @CacheLookup
  public WebElement rollAgain;

  @FindBy(how = How.XPATH, using = "//select[@name='num']")
  @CacheLookup
  public WebElement getRollDiceDropBox;

  @FindBy(how = How.XPATH, using = "//input[@type='submit' and contains(@value, 'Roll')]")
  public WebElement submit;

  @FindBy(how = How.XPATH, using = "//h2[text()='Dice Roller']/following::p/img")
  public List<WebElement> dices;

  public DicePage(WebDriver driver) {
    super(driver);
  }

  public void selectRollNumber(int option) {
    var select = new Select(getRollDiceDropBox);
    select.selectByVisibleText(option + "");
  }
}
