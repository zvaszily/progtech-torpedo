package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.BaseTable;
import hu.nye.progtech.torpedo.service.TableCreator;

public class Main {
    public static void main(String[] args) {

        char[][] map = {
                {' ', '¤'},
                {'X', ' '}
        };

        BaseTable baseTable = new BaseTable(2,2,map);

        System.out.println(baseTable);

        TableCreator tableCreator = new TableCreator(10,10);
        System.out.println(tableCreator.createTable());
    }
}
