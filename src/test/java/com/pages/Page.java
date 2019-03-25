package com.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

/** Abstract class representation of a Page in the UI. Page object pattern */
public abstract class Page {

  protected WebDriver driver;
  protected final FluentWait<WebDriver> waiter;

  /*
   * Constructor injecting the WebDriver interface
   *
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
    // TO DO move to the properties file timeouts
    waiter =
        new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
  }

  public String getTitle() {
    return driver.getTitle();
  }
}
