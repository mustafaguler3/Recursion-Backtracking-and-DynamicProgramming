package backtracking;

public class GraphColoring {

    private int numOfVertices;
    private int numOfColors;
    private int[] colors;
    private int[][] graph;


    public GraphColoring(int[][] graph,int numOfColors) {
        this.numOfVertices = graph[0].length;
        this.numOfColors = numOfColors;
        this.colors = new int[numOfVertices];
        this.graph = graph;
    }

    public void solve(){

        if (solveProblem(0)){
            showSolution();
        }else {
            System.out.println("There is no solution with these parameters...");
        }

    }

    private boolean solveProblem(int nodeIndex){

        // if we find a color to the last node : the problem is solved
        // this is the base case for recursion
        if (nodeIndex == numOfVertices){
            return true;
        }
        // try all colors (color indexes starts with 1)
        for (int colorIndex = 1; colorIndex <= numOfColors; ++colorIndex){
            if (isColorValid(nodeIndex,colorIndex)){
                //assign and proceesd with next vertex (node)
                colors[nodeIndex] = colorIndex;

                if (solveProblem(nodeIndex + 1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex){

        for (int i =0; i< numOfVertices;++i){
            if (graph[nodeIndex][i] == 1 && colorIndex == colors[i]){
                return false;
            }
        }
        return true;
    }

    private void showSolution() {
        for (int i = 0; i < colors.length; i++){
            System.out.println("Node: "+(i + 1)+ " has color index: "+colors[i]);
        }
    }
}



















