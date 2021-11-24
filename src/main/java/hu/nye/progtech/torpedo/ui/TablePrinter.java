package hu.nye.progtech.torpedo.ui;

import hu.nye.progtech.torpedo.model.BaseTable;

public class TablePrinter {

    private BaseTable baseTable;
    private BaseTable shotTable;

    public TablePrinter(BaseTable baseTable, BaseTable shotTable) {
        this.baseTable = baseTable;
        this.shotTable = shotTable;
    }

    public void printTable(BaseTable baseTable){
        System.out.println(headerString());
        System.out.println(tableString());
    }

    private String headerString(){
        StringBuilder str = new StringBuilder();

        for(int k=0;k<2;k++){
            str.append("\t");
            for (int i=65;i<baseTable.getNumberOfColumns()+65;i++){
                str.append((char)i);
                str.append("  ");
            }
            str.append("\t");
        }
        return str.toString();
    }

    private String tableString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < baseTable.getMap().length; i++) {
            if(i>0){str.append("\n");}
            str.append(i+1);
            str.append("\t");
            for (int j = 0; j < baseTable.getMap().length; j++) {
                str.append(baseTable.getMap()[i][j]);
                str.append("  ");
            }
            str.append("\t");
            str.append(i+1);
            str.append("\t");
            for (int j = 0; j < shotTable.getMap().length; j++) {
                str.append(shotTable.getMap()[i][j]);
                str.append("  ");
            }
        }
        return str.toString();
    }

}
