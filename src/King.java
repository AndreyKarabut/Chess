public class King extends ChessPiece{
    public King(String color){
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkIndex(line) && checkIndex(column) && checkIndex(toLine) && checkIndex(toColumn) && chessBoard.board[line][column] != null) {
            if (line == 0 && column == 4 && (toColumn == 2 || toColumn == 6)) {
                if (chessBoard.nowPlayer.equals("White")) {
                    if (chessBoard.board[0][4] != null) {
                        if (chessBoard.board[0][4].getSymbol().equals("K")) {
                            if (chessBoard.board[0][4].check) {
                                if (toColumn == 2) {
                                    if (chessBoard.board[0][0] != null && chessBoard.board[0][1] == null && chessBoard.board[0][2] == null && chessBoard.board[0][3] == null) {
                                        if (chessBoard.board[0][0].getSymbol().equals("R") && chessBoard.board[0][0].check) {
                                            if (!isUnderAttack(chessBoard, 0, 2) && !isUnderAttack(chessBoard, 0, 3)) {
                                                return true;
                                            }
                                        }
                                    }
                                } else {
                                    if (chessBoard.board[0][7] != null && chessBoard.board[0][6] == null && chessBoard.board[0][5] == null) {
                                        if (chessBoard.board[0][7].getSymbol().equals("R") && chessBoard.board[0][7].check) {
                                            if (!isUnderAttack(chessBoard, 0, 5) && !isUnderAttack(chessBoard, 0, 6)) {
                                                return true;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }

            }else if(line == 7 && column == 4 && (toColumn == 2 || toColumn == 6)){
                if (chessBoard.nowPlayer.equals("Black")) {
                    if (chessBoard.board[7][4] != null) {
                        if (chessBoard.board[7][4].getSymbol().equals("K")) {
                            if (chessBoard.board[7][4].check) {
                                if (toColumn == 2) {
                                    if (chessBoard.board[7][0] != null && chessBoard.board[7][1] == null && chessBoard.board[7][2] == null && chessBoard.board[7][3] == null) {
                                        if (chessBoard.board[7][0].getSymbol().equals("R") && chessBoard.board[7][0].check) {
                                            if (!isUnderAttack(chessBoard, 7, 2) && !isUnderAttack(chessBoard, 7, 3)) {
                                                return true;
                                            }
                                        }
                                    }
                                } else {
                                    if (chessBoard.board[7][7] != null && chessBoard.board[7][6] == null && chessBoard.board[7][5] == null) {
                                        if (chessBoard.board[7][7].getSymbol().equals("R") && chessBoard.board[7][7].check) {
                                            if (!isUnderAttack(chessBoard, 7, 5) && !isUnderAttack(chessBoard, 7, 6)) {
                                                return true;
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
            if (Math.abs(toLine - line) > 1 || Math.abs(toColumn - column) > 1) {
                return false;
            }
            if(toLine != line || toColumn != column){
                if(!isUnderAttack(chessBoard, toLine, toColumn)){
                    return checkPosColor(chessBoard, toLine, toColumn);
                }
            }

        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    boolean isUnderAttack(ChessBoard board, int line, int column){
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++) {
            if(isUnderAttack){
                break;
            }
            for (int j = 0; j < 8; j++) {
                if(board.board[i][j]!=null){
                    ChessPiece chessPiesse = board.board[i][j];
                    if (!chessPiesse.getColor().equals(color)) {
                        if (chessPiesse.getSymbol().equals("P")) { //for pawn
                            if (Math.abs(column - j) == 1) {
                                if (chessPiesse.getColor().equals("White")) {
                                    if(i-line == 1){
                                        isUnderAttack = true;
                                        break;
                                    }
                                } else {
                                    if(i-line == -1){
                                        isUnderAttack = true;
                                        break;
                                    }
                                }
                            }
                        }
                        else if(chessPiesse.canMoveToPosition(board, i, j, line, column)){ //for others
                            isUnderAttack = true;
                            break;
                        }
                    }
                }
            }
        }
        return isUnderAttack;
    }
}
