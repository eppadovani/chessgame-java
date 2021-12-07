package com.example.chessgame.models;

public class Match {

    private Player playerOne, playerTwo;

    public Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }





    public Player getPlayerOne() {
        return playerOne;
    }
    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }
    public Player getPlayerTwo() {
        return playerTwo;
    }
    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }
}
