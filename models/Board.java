package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

    public Board(List<List<Cell>> cells, int size) {
        this.size = size;

        // Board should contain all the cell meaning matrix

        // Imagine this one as outer boundary of the arrayList
        this.board = new ArrayList<>();

        /*[ [_,_,_],
            [_,_,_],
            [_,_,_ ]]*/
        for(int i = 0; i < size; i++){
            // this.getBoard() will give outer arraylist where inner List should be added
            this.getBoard().add(new ArrayList<>());
            // Now that we have added the inner arrayList to outer ArrayList
            // we should add the row and colum i.e cell
            //this.getBoard().get(i) will give the inner arrayList where we will add the cell
            for(int j = 0; j < size; j++){
                this.getBoard().get(i).add(new Cell(i,j));
            }

        }

    }

    public void printBoard(){
        for(int i = 0; i < size; i++){
            List<Cell> row = board.get(i);
            for(int j = 0; j < size; j++){
                row.get(j).display();
            }
        }
    }

    public Board( int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
