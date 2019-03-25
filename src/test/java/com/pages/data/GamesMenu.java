package com.pages.data;

public enum GamesMenu implements IMenuLeaf {
  Dice("Dice Roller");

  GamesMenu(String text) {
    this.text = text;
  }

  private String text;

  @Override
  public String getLeafText() {
    return text;
  }
}
