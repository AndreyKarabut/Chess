public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkIndex(line) && checkIndex(column) && checkIndex(toLine) && checkIndex(toColumn) && chessBoard.board[line][column] != null) {
            if (line != toLine && column == toColumn || line == toLine && column != toColumn) { //Rook
                int delta = Math.abs(toColumn - column + toLine - line);
                int b;
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
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) { //Bishop
                int a;
                int b;
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (toLine > line) {
                        a = line + i;
                    } else {
                        a = line - i;
                    }
                    if (toColumn > column) {
                        b = column + i;
                    } else {
                        b = column - i;
                    }
                    if (chessBoard.board[a][b] != null) {
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
        return "Q";
    }

}
