package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.BaseTable;

public class Main {
    public static void main(String[] args) {

        char[][] map = {
                {' ', 'X'},
                {'X', ' '}
        };

        BaseTable baseTable = new BaseTable(2,2,map);

        System.out.println(baseTable);
    }
}
