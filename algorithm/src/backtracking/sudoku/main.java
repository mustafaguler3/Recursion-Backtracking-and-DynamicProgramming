package backtracking.sudoku;

public class main {
    public static void main(String[] args) {

        int[][] sudokuTable = {
                {3,0,6,5,0,8,4,0,0},
                {3,0,6,5,0,8,4,0,0},
                {7,0,6,5,0,8,4,0,0},
                {3,0,8,8,0,8,4,0,0},
                {3,0,6,5,6,8,2,0,0},
                {3,2,6,6,0,8,4,1,0}
        };

        Sudoku sudoku = new Sudoku(sudokuTable);
        sudoku.showSolution();

    }
}
