package models;

import java.util.List;

public class Board {
    private List<List<Cell>> cells;
    private int size;

    public Board(List<List<Cell>> cells, int size) {
        this.cells = cells;
        this.size = size;
    }

    public Board( int size) {
        this.size = size;
    }
}
