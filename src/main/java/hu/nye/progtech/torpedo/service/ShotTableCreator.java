package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.BaseTable;

public class ShotTableCreator {
    private final int numberOfRows;
    private final int numberOfColumns;

    public ShotTableCreator(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public BaseTable createTable(){
        char[][] map = new char[numberOfRows][numberOfColumns];
        return new BaseTable(numberOfRows,numberOfColumns,map);
    }


}