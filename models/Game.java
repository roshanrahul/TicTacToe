package models;

import exception.DuplicateSymbolException;
import exception.InvalidBotCountException;
import exception.InvalidDImensionException;
import exception.InvalidNumberOfPlayersException;
import strategy.winningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameState;

    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;


    // we want to use Builder design patter so making constructor private
    private Game(List<Player> players, Board board,List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = board;
        this.moves = new ArrayList<Move>();
        // Gmae state will always be in Inprogress
        this.gameState = GameState.INPROGRESS;
        //starting this will be 1st player
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        // one static method to return the builder Object.
        public static Builder builder(){
            return new Builder();
        }
        private Builder() {
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }
        // we can add one player as BOT later
        public void addPlayer(Player player){
            players.add(player);
        }
        public void addWinningStrategy(WinningStrategy winningStrategy){
            winningStrategies.add(winningStrategy);
        }

        private void validateBOTCounts(){
            int botCount = 0;
            for(Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCount++;
            }
            if(botCount > 1){
                throw new InvalidBotCountException("Bot count has exceeded 1");
            }
        }
        private void validateDimension(){
            if(dimension < 3 || dimension >10)
                throw new InvalidDImensionException("Please enter dimension >3 or  < 10");
        }

        private void validateNumberOfPlayers(){
            if(players.size() != dimension-1){
                throw new InvalidNumberOfPlayersException("Players should be less then dimension");
            }
        }

        private void validateUniqueSymbolForAllPlayers(){
            HashSet<Character> set = new HashSet<>();

            for(Player player : players){
                set.add(player.getSymbol().getSymbolChar());
            }
            if(set.size() != players.size())
                throw new DuplicateSymbolException("Players have same symbol");
        }

        private void validate(){
            validateDimension();
            validateBOTCounts();
            validateNumberOfPlayers();
            validateUniqueSymbolForAllPlayers();
        }

        private Game build(){
            validate();
            return new Game(players,new Board(dimension),winningStrategies);
        }
    }

}
