public abstract class ChessPiece {
    String color;
    boolean check;


    public ChessPiece(String color) {
        this.color = color;
        this.check = true;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    boolean checkIndex(int i) {
        if (i < 0 || i > 7) {
            return false;
        }
        return true;
    }

    boolean checkPosColor(ChessBoard chessBoard, int toLine, int toColumn) {
        if (chessBoard.board[toLine][toColumn] != null) {
            return !chessBoard.board[toLine][toColumn].getColor().equals(color);
        } else return true;
    }
}
