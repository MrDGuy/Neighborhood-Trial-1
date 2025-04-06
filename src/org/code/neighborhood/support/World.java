package org.code.neighborhood.support;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.code.neighborhood.support.Grid;
import org.code.neighborhood.support.GridFactory;

public class World{
  private final Grid grid;

  public World(int size) {
    GridFactory gridFactory = new GridFactory();
    this.grid = gridFactory.createEmptyGrid(size);
  }

  public World(String s) {
    GridFactory gridFactory = new GridFactory();
    try {
      this.grid = gridFactory.createGridFromString(s);
    } catch (IOException e) {
      throw new RuntimeException("Could not load grid");
  }

  public World() {
    GridFactory gridFactory = new GridFactory();
    try {
      this.grid = gridFactory.createGridFromJSON("grid.txt");
    } catch (IOException e) {
      throw new RuntimeException("Could not load grid");
    }
  }

  public World(String filePath, boolean isFilePath) {
    GridFactory gridFactory = new GridFactory();
    try {
      String json = Files.readString(Paths.get(filePath));
      this.grid = gridFactory.createGridFromString(json);
    } catch (IOException e) {
      throw new RuntimeException("Could not load grid");
  }

  public Grid getGrid() {
    return this.grid;
  }
}
