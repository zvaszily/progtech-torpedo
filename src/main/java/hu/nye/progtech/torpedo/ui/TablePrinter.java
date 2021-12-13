package hu.nye.progtech.torpedo.ui;

import hu.nye.progtech.torpedo.model.GameState;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Print actual player tables.
 */

public class TablePrinter {

    private final GameState baseTableList;

    public TablePrinter(GameState baseTableList) {
        this.baseTableList = baseTableList;
    }

    public void printTable(GameState baseTableList) {
        System.out.println(headerString());
        System.out.println(tableString());
    }

    private String headerString() {
        StringBuilder str = new StringBuilder();

        for (int k = 0; k < 2; k++) {
            str.append("\t");
            for (int i = 65; i < baseTableList.getBaseTableList().get(0).getNumberOfColumns() + 65; i++) {
                str.append((char) i);
                str.append("  ");
            }
            str.append("\t");
        }
        return str.toString();
    }

    private String tableString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < baseTableList.getBaseTableList().get(0).getMap().length; i++) {
            if (i > 0) {
                str.append("\n");
            }
            str.append(i + 1);
            str.append("\t");
            for (int j = 0; j < baseTableList.getBaseTableList().get(0).getMap().length; j++) {
                str.append(baseTableList.getBaseTableList().get(0).getMap()[i][j]);
                str.append("  ");
            }
            str.append("\t");
            str.append(i + 1);
            str.append("\t");
            for (int j = 0; j < baseTableList.getBaseTableList().get(1).getMap().length; j++) {
                str.append(baseTableList.getBaseTableList().get(1).getMap()[i][j]);
                str.append("  ");
            }
        }
        return str.toString();
    }

}
