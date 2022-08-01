package backtracking.sudoku;

public class Sudoku {

    private int[][] sudokuTable;

    public Sudoku(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem(){
        if (solve(0,0)){
            showSolution();
        }else {
            System.out.println("There is no solution");
        }
    }

    private boolean solve(int rowIndex,int colIndex){
        //check the base-cases
        if (rowIndex == Constants.BOARD_SIZE){
            colIndex++;
            //we have considered all the cells- end of algorith
            if (colIndex == Constants.BOARD_SIZE){
                return true;
            }else {
                //hop to the next column so re-initialize rowIndex=0
                rowIndex++;
            }
        }
        //skip filled cells
        if (sudokuTable[rowIndex][colIndex] != 0){
            return solve(rowIndex+1,colIndex);
        }

        for (int num =Constants.MIN_NUMBER;num<Constants.MAX_NUMBER;++num){
            if (isValid(rowIndex,colIndex,num)){
                //we assign the number to that location
                sudokuTable[rowIndex][colIndex] = num;

                if (solve(rowIndex+1,colIndex)){
                    return true;
                }

                //BACKTRACK
                //0 means that it is an empty cell
                sudokuTable[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int rowIndex,int colIndex,int num){
        //if the given number is already in the column: the number
        //cannot be part of the solution
        for (int i=0;i<Constants.BOARD_SIZE;++i){
            if (sudokuTable[i][colIndex] == num){
                return false;
            }
        }
        //if the given number is already in the row: the number
        //cannot be part of the solution
        for (int j = 0;j<Constants.BOARD_SIZE;++j){
            if (sudokuTable[rowIndex][j] == num){
                return false;
            }
        }
        //if the given number is already in the box: the number
        //cannot be part of the solution
        int boxRowOffset = (rowIndex / 3) * Constants.BOX_SIZE;
        int boxColumnOffset = (colIndex / 3) * Constants.BOX_SIZE;

        //all the 9 items of the given box
        for (int i = 0;i<Constants.BOX_SIZE;i++){
            for (int j = 0;j <Constants.BOX_SIZE; j++){
                if (sudokuTable[boxRowOffset + i][boxColumnOffset + j]==num){
                    return false;
                }
            }
        }

        return true;
    }

    public void showSolution(){
        for (int i =0;i<Constants.BOARD_SIZE;i++){

            if (i % 3 == 0){
                System.out.println();
            }

            for (int j = 0;j<Constants.BOARD_SIZE;++j){
                if (j % 3 == 0){
                    System.out.println(sudokuTable[i][j] + "");
                }
            }

            System.out.println();

        }
    }
}
