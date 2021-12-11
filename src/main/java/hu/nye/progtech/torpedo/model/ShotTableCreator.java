package hu.nye.progtech.torpedo.model;

/**
 * Model class used to Shot Table.
 */
public class ShotTableCreator {
    private int numberOfRows;
    private int numberOfColumns;

    public ShotTableCreator(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public BaseTable createTable() {
        char[][] map = new char[numberOfRows][numberOfColumns];
        return new BaseTable(numberOfRows, numberOfColumns, map);
    }


}
