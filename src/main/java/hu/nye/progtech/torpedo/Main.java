package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.BaseTable;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.service.TableCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hogy hívnak?");
        Scanner scanner = new Scanner(System.in);
        String player1 = scanner.nextLine();

        Player player = new Player(player1,0,0);

        System.out.println(player.toString());


        TableCreator tableCreator = new TableCreator(10,10);
        System.out.println(tableCreator.createTable());
    }
}
