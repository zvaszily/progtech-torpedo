package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Player;

import java.util.Scanner;

public class GameController {

    private Player player;

    public GameController(Player player) {
        this.player = player;
    }

    Scanner scanner = new Scanner(System.in);


}
