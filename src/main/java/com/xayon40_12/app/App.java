package com.xayon40_12.app;

sealed interface Color permits Red, Black {
  String info();
}

record Red() implements Color {
  public String info() {
    return "Red";
  }
}

record Black() implements Color {
  public String info() {
    return "Black";
  }
}

/** Hello world! */
public class App {
  public static void main(String[] args) {
    Color c = new Red();
    System.out.println("%s".formatted(c.info()));
  }
}
