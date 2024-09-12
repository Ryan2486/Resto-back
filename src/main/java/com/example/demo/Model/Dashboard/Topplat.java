package com.example.demo.Model.Dashboard;

import com.example.demo.Model.MenuModel;

public class Topplat {
  private MenuModel menu;
  private long total;

  public Topplat(MenuModel menu, long total) {
    this.menu = menu;
    this.total = total;
  }

  public MenuModel getmenu() {
    return menu;
  }

  public void setmenu(MenuModel menu) {
    this.menu = menu;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }
}
