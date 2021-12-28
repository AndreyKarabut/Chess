public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkIndex(line) && checkIndex(toLine) && checkIndex(column) && checkIndex(toColumn)&& chessBoard.board[line][column] != null) {
            if (line != toLine) {
                if (column == toColumn) {
                    if (chessBoard.board[toLine][toColumn] == null) {
                        if (color.equals("White")) {
                            if (toLine - line == 1) {
                                return true;
                            }
                            if (line == 1 && toLine == 3) { //for first move
                                if (chessBoard.board[2][toColumn] == null) {
                                    return true;
                                }
                            }
                        } else if (color.equals("Black")) {
                            if (toLine - line == -1) {
                                return true;
                            }
                            if (line == 6 && toLine == 4) { //for first move
                                if (chessBoard.board[5][toColumn] == null) {
                                    return true;
                                }
                            }
                        }
                    }
                } else
                if (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1 && chessBoard.board[toColumn][toLine] != null) { //attack
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}
