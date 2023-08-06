package models;

public class Cell {
    private int row;
    private int cols;
    private CellState cellState;
    //Each cell is played by which
    private Player player;

    public Cell(int row,int col){
    this.row = row;
    this.cols = col;
    this.cellState = CellState.EMPTY;
    }

    public Cell(int row, int cols, Player player) {
        this.row = row;
        this.cols = cols;
        this.cellState = CellState.FILLED;
        this.player = player;
    }

    public void display(){
        if(player == null)
            System.out.print("|"+"-"+"|");
        else
            System.out.print("|"+player.getSymbol().getSymbolChar()+"|");
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
