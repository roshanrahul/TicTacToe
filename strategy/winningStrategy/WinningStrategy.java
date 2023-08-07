package strategy.winningStrategy;

import models.Board;
import models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board);
}
