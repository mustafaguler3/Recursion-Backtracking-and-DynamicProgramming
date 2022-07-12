package backtracking;

public class KnightTour {

    private int[][] chessTable;
    private int boardSize;
    private int[] xMoves = {2,1,-1,-2,-2,-1,1,2};
    private int[] yMoves = {1,2,2,1,-1,-2,-2,-1};

    // xMoves[0] ,yMoves[0] = (2,1)


    public KnightTour(int boardSize) {
        this.boardSize = boardSize;
        this.chessTable = new int[boardSize][boardSize];
        initializeChessTable();
    }

    private void initializeChessTable() {
        for (int i = 0; i <boardSize;i++){
            for (int j = 0; j < boardSize; j++){
                chessTable[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void solve() {
        //initial value (0,0)
        chessTable[0][0] = 0;

        if (solveProblem(1,0,0)){
            showSolution();
        }else {
            System.out.println("There is no solution...");
        }
    }

    private boolean solveProblem(int stepCount, int x, int y){

        //base-case
        //this when we have considered all the cells of the chess board
        if (stepCount == boardSize * boardSize){
            return true;
        }

        //consider all possible moves
        for (int moveIndex = 0; moveIndex< yMoves.length;moveIndex++){

            int nextX = x + xMoves[moveIndex];
            int nextY = y + yMoves[moveIndex];

            // if the move is valid
            if (isValid(nextX, nextY)){
                chessTable[nextX][nextY] = stepCount;

                //solve the problem for the next index (next step)
                if (solveProblem(stepCount+1,nextX,nextY)){
                    return true;
                }

                //can not solve the rproblem
            }
        }

        return false;
    }

    private boolean isValid(int x, int y){

        //can not leave the board horizontally
        if (x < 0 || x >= boardSize) return false;
        if (y < 0 || y >= boardSize) return false;

        //we can not visit the same cell multiple times
        if (chessTable[x][y] != Integer.MIN_VALUE){
            return false;
        }
        return true;
    }

    private void showSolution() {
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; ++j){
                System.out.println(this.chessTable[i][j] + " ");
            }
        }
    }
}
















