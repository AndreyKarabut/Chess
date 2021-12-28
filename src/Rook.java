public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkIndex(line) && checkIndex(column) && checkIndex(toLine) && checkIndex(toColumn) && chessBoard.board[line][column] != null) {
            int delta = Math.abs(toColumn - column + toLine - line);
            int b = 0;
            if (line == toLine && column != toColumn) {
                for (int i = 1; i < delta; i++) {
                    if (toColumn > column) {
                        b = column + i;
                    } else {
                        b = column - i;
                    }
                    if (chessBoard.board[line][b] != null) {
                        return false;
                    }
                }
                return checkPosColor(chessBoard, toLine, toColumn);
            } else if (line != toLine && column == toColumn) {
                for (int i = 1; i < delta; i++) {
                    if (toLine > line) {
                        b = line + i;
                    } else {
                        b = line - i;
                    }
                    if (chessBoard.board[b][column] != null) {
                        return false;
                    }
                }
                return checkPosColor(chessBoard, toLine, toColumn);
            }

        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
