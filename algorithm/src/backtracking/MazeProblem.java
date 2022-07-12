package backtracking;

public class MazeProblem {

    private int[][] maze;
    // 0 values and 1 values - 1 represents the path
    private int[][] solution;
    private int mazeSize;

    public MazeProblem(int[][] maze) {
        this.maze = maze;
        this.mazeSize = maze.length;
        this.solution = new int[mazeSize][mazeSize];
    }

    public void solve(){
        if (solveProblem(0,0)){
            showSolution();
        }else {
            System.out.println("There is no solution ...");
        }
    }

    private boolean solveProblem(int rowIndex, int colIndex){

        if (isFinished(rowIndex,colIndex)){
            return true;
        }

        if (isValid(rowIndex,colIndex)){
            // it is valid so it is part of the solution
            solution[rowIndex][colIndex] = 1;

            //go forward in the horizontal direction
            // note: we have to increment the colIndex to move horizontally
            if (solveProblem(rowIndex,colIndex + 1)){
                return true;
            }

            if (solveProblem(rowIndex + 1,colIndex)){
                return true;
            }

            //BACKTRACKING
            solution[rowIndex][colIndex] = 0;
        }

        return false;
    }

    private boolean isFinished(int rowIndex,int colIndex){
        if (rowIndex == mazeSize - 1 && colIndex == mazeSize - 1){
            solution[rowIndex][colIndex] = 1;
            return true;
        }

        return false;
    }

    private boolean isValid(int rowIndex, int colIndex){

        //can not leave the maze horiontally and vertically
        if (rowIndex < 0 || rowIndex >= mazeSize) return false;
        if (colIndex < 0 || colIndex >= mazeSize) return false;

        //have to consider obstacles
        if (maze[rowIndex][colIndex] != 1) return false;

        return true;
    }

    private void showSolution() {
        for (int i = 0; i < mazeSize; ++i){
            for (int j = 0; j < mazeSize; ++j){
                if (maze[i][j] == 1) {
                    System.out.println(" S ");
                }else {
                    System.out.println(" - ");
                }
            }
            System.out.println();
        }
    }

}




















