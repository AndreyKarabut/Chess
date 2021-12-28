public class Horse extends ChessPiece {
    public Horse(String color){
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if(line != toLine && column != toColumn) {
            if (checkIndex(line) && checkIndex(toLine) && checkIndex(column) && checkIndex(toColumn)&&chessBoard.board[line][column] != null) {
                if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1 || Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2) {
                    return checkPosColor(chessBoard, toLine, toColumn);
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
