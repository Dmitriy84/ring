package com.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.JUnitTestBase;
import com.pages.DicePage;
import com.pages.HomePage;
import com.pages.data.GamesMenu;
import com.utils.MathUtil;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DicesTest extends JUnitTestBase {
  private HomePage homepage;

  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  // TODO test timeout
  @Test
  public void testHomePageHasAHeader() throws InterruptedException {
    driver.get(baseUrl);

    var dicePage = homepage.chooseMenu(GamesMenu.Dice, DicePage.class);
    dicePage.selectRollNumber(1);

    var attempts = 20;
    var dices = new Integer[attempts];
    WebElement element;
    String attribute;
    Integer value;

    for (int a = 0; a < attempts; a++) {
      dicePage.submit.click();

      var values = 0;
      for (int i = 0; i < dicePage.dices.size(); i++) {
        element = dicePage.dices.get(i);
        attribute = element.getAttribute("alt");
        value = Integer.parseInt(attribute);

        assertThat(value, is(not(0)));
        values += value;
      }
      dices[a] = values;
    }

    log.info("DICES: " + dices);

    assertThat(dices.length, is(attempts));
    var range = both(greaterThan(0)).and(lessThan(7));
    assertThat(Arrays.asList(dices), everyItem(range));

    var average = MathUtil.average(dices);
    log.info("AVERAGE: " + average);

    var deviationSquares = MathUtil.deviationSquares(dices, average);
    log.info("DEVIATION SQUARES: " + deviationSquares);
  }
}
