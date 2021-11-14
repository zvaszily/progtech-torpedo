package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.BaseTable;

public class TableCreator {

    private final int numberOfRows;
    private final int numberOfColumns;

    public TableCreator(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public BaseTable createTable(){

        char[][] map=getMap();
        return new BaseTable(numberOfRows,numberOfColumns,map);
    }

    private char[][] getMap(){
        char[][] map = new char[numberOfRows][numberOfColumns];

       return map;
    }
}
