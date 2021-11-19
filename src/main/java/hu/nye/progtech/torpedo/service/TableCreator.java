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
        for(int shipSize=5;shipSize>0;shipSize--){
          createShip(map,shipSize);
        }
       return map;
    }

    private void createShip(char[][] map,int shipSize){
        int max;
        int shipPlaceX;
        int shipPlaceY;
        boolean shipOverlap = true;
        while(shipOverlap) {
            if (shipHorizont()) {
                max = numberOfColumns - (shipSize + 1);
                shipPlaceX = shipPlace(max);
                max = numberOfRows - 1;
                shipPlaceY = shipPlace(max);
                for (int j = 0; j < shipSize; j++) {
                    if (map[shipPlaceY][shipPlaceX + j] == '¤') {
                        shipOverlap = true;
                        break;
                    }
                    map[shipPlaceY][shipPlaceX + j] = '¤';
                    shipOverlap = false;
                }
            } else {
                max = numberOfRows - (shipSize + 1);
                shipPlaceY = shipPlace(max);
                max = numberOfColumns - 1;
                shipPlaceX = shipPlace(max);
                for (int j = 0; j < shipSize; j++) {
                    if (map[shipPlaceY + j][shipPlaceX] == '¤') {
                        shipOverlap = true;
                        break;
                    }
                    map[shipPlaceY + j][shipPlaceX] = '¤';
                    shipOverlap = false;
                }
            }
        }
    }

    private boolean shipHorizont(){
        return Math.random() > 0.5;
    }

    private int shipPlace(int max){
        return (int)(Math.random()*max);
    }

}
