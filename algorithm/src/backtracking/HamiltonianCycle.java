package backtracking;

public class HamiltonianCycle {


    private int numOfVertexes;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.numOfVertexes = adjacencyMatrix[0].length;
        this.hamiltonianPath = new int[numOfVertexes];
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void solve(){
        //we start with first vertex
        hamiltonianPath[0] = 0;

        if (findSolution(1)){
            showResult();
        }else {
            System.out.println("There is no solution...");
        }

    }

    private boolean findSolution(int position){

        // we have considered all the vertexes so end of the algorithm
        if (position == this.numOfVertexes) {
            //there is a connection back to the first node (index 0) so the cycle exists
            if (adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1){
                return true;
            }else {
                return false;
            }
        }
        // try all the possible vertexes in the graph
        for (int vertexIndex = 1; vertexIndex < numOfVertexes; ++vertexIndex){
            //if the node is feasible then this is the next node in the hamitonia cycle
            if (isValid(vertexIndex,position)){
                //we include the vertex in the hamiltonia path
                hamiltonianPath[position] = vertexIndex;

                if (findSolution(position + 1)){
                    return true;
                }

                //BACKTACKING

            }
        }
        //tried all the vertexes without a success
        return false;
    }

    private boolean isValid(int vertex, int actualPosition){
        //first criteria: whether the two nodes are connected?
        if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertex] == 0){
            return false;
        }

        //second criteria: whether we have already visited this given node?
        for (int i = 0; i < actualPosition; i++){
            if (hamiltonianPath[i] == vertex){
                return false;
            }
        }
            return true;
    }

    private void showResult() {
        System.out.println("Hamiltonia cycle exists: ");

        for (int i = 0; i < hamiltonianPath.length; i++){
            System.out.println(hamiltonianPath[i] + " - ");
        }

        System.out.println(hamiltonianPath[0]);
    }

}




















