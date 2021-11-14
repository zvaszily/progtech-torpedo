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
        int shipPlace;
        if(shipHorizont()){
            max = numberOfColumns-shipSize;
            shipPlace = shipPlace(max);
            System.out.println(shipPlace);
            for(int j=0;j<shipSize;j++){
                map[shipPlace][j]='¤';
            }
        }else{
            max = numberOfRows-shipSize;
            shipPlace = shipPlace(max);
            System.out.println(shipPlace);
            for(int j=0;j<shipSize;j++){
                map[j][shipPlace]='X';
            }
        }
    }

    private boolean shipHorizont(){
        return Math.random() > 0.5;
    }

    private int shipPlace(int max){
        return (int)(Math.random()*max);
    }

    private boolean validShipPlace(char[][] map,int shipSize,int shipPlace,boolean shshipHorizont){
        boolean shipPlaceValid;

        return false;
    }
}
