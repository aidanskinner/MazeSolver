/**
 * Solves the given maze using DFS or BFS
 * @author Ms. Namasivayam
 * @version 03/10/2023
 */

import java.util.ArrayList;
import java.util.Stack;

public class  MazeSolver {
    private Maze maze;

    public MazeSolver() {
        this.maze = null;
    }

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    /**
     * Starting from the end cell, backtracks through
     * the parents to determine the solution
     * @return An arraylist of MazeCells to visit in order
     */
    public ArrayList<MazeCell> getSolution() {
        // Creates the Stack of MazeCells for the reverse
        // Creates the ArrayList for the correct order of MazeCells
        Stack <MazeCell> reverseSolution = new Stack<>();
        ArrayList <MazeCell> mazeSolution= new ArrayList<>();
        MazeCell cell = maze.getEndCell();
        while (maze.getStartCell() != cell) {
            // Goes through the cells and adds to the stack
            reverseSolution.push(cell);
            cell = cell.getParent();
        }
        // Adds first cell
        reverseSolution.push(maze.getStartCell());
        // Reverses the stack into the arraylist
        for (int i = 0; i < reverseSolution.size(); i++) {
            mazeSolution.add(reverseSolution.pop());
        }
        return mazeSolution;
    }

    /**
     * Performs a Depth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeDFS(Stack <MazeCell> cells) {
        // Initializes current MazeCell
        MazeCell currentCell = cells.pop();
        if (currentCell == maze.getEndCell()) {
            return null;
        }
        int row = currentCell.getRow();
        int col = currentCell.getCol();
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        // North check
        if (maze.isValidCell(row - 1, col)) {
            cells.push(currentCell);
        }
        // East check
        else if (maze.isValidCell(row, col - 1)) {
            cells.push(currentCell);
        }
        // South check
        else if (maze.isValidCell(row + 1, col)) {
            cells.push(currentCell);
        }
        // West check
        else if (maze.isValidCell(row, col + 1)) {
            cells.push(currentCell);
        }

    }

    /**
     * Performs a Breadth-First Search to solve the Maze
     * @return An ArrayList of MazeCells in order from the start to end cell
     */
    public ArrayList<MazeCell> solveMazeBFS() {
        // TODO: Use BFS to solve the maze
        // Explore the cells in the order: NORTH, EAST, SOUTH, WEST
        return null;
    }

    public static void main(String[] args) {
        // Create the Maze to be solved
        Maze maze = new Maze("Resources/maze3.txt");

        // Create the MazeSolver object and give it the maze
        MazeSolver ms = new MazeSolver();
        ms.setMaze(maze);

        // Solve the maze using DFS and print the solution
        ArrayList<MazeCell> sol = ms.solveMazeDFS();
        maze.printSolution(sol);

        // Reset the maze
        maze.reset();

        // Solve the maze using BFS and print the solution
        sol = ms.solveMazeBFS();
        maze.printSolution(sol);
    }
}
