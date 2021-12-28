public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (checkIndex(line) && checkIndex(column) && checkIndex(toLine) && checkIndex(toColumn) && chessBoard.board[line][column] != null) {
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
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
        return "B";
    }
}
