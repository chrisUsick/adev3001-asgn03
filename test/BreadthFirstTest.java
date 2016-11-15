import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

/**
 * Created by chris.usick on 11/15/16.
 */
public class BreadthFirstTest {

    @Test
    public void testBreadthFirstSearchStartIsEnd() throws Exception {
        char[] row1 = {MapType.End.toChar()};
        char[][] maze = {row1};
        BreadthFirst search = new BreadthFirst(maze);
        Stack<Point> result = search.breadthFirstSearch(0,0);
        assertEquals(1, result.size());
        assertEquals(result.top().getRow(), 0);
        assertEquals(result.top().getColumn(), 0);
    }

    @Test
    public void testBreadthFirstSearchSimpleMaze() throws Exception {
        char blank = MapType.Blank.toChar();
        char[][] maze = {
                {blank},
                {blank},
                {blank},
                {MapType.End.toChar()}
        };

        BreadthFirst search = new BreadthFirst(bufferMaze(maze));
        Stack<Point> result = search.breadthFirstSearch(1,1);
        assertEquals(result.size(), 4);
        int i = 0;
        while (!result.isEmpty()) {
            i++;
            assertEquals(result.pop().getRow(), i);
        }
    }

    @Test
    public void testBreadthFirstSearchNoEnd() throws Exception {
        char blank = MapType.Blank.toChar();
        char[][] maze = {
                {blank},
                {blank},
                {blank}
        };
        BreadthFirst search = new BreadthFirst(bufferMaze(maze));
        Stack<Point> result = search.breadthFirstSearch(1, 1);
        assertEquals(result.size(), 0);
    }

    @Test
    public void testBreadthFirstShortestRoute() throws Exception {
        char blank = MapType.Blank.toChar();
        char wall = MapType.Wall.toChar();
        char end = MapType.End.toChar();
        char[][] maze = {
                {blank, blank, blank},
                {blank, wall, end},
                {blank, blank, blank},
        };
        BreadthFirst search = new BreadthFirst(bufferMaze(maze));
        Stack<Point> result = search.breadthFirstSearch(1, 1);
        assertEquals(result.size(), 4);
        int i = 0;
        Point point = null;
        while (!result.isEmpty()) {
            point = result.pop();
            if (i < 3) {
                i++;
            }
            assertEquals(i, point.getColumn());
        }

        assertEquals("Didn't find the end", 2, point.getRow());
    }

    /**
     * Helper method to buffer a maze with 'W' elements
     * @param maze  A maze to buffer
     * @return      A new maze, with a wall buffer
     */
    public char[][] bufferMaze(char[][] maze) {
        char[][] newMaze = new char[maze.length + 2][];
        newMaze[0] = new char[maze[0].length + 2];
        Arrays.fill(newMaze[0], MapType.Wall.toChar());
        for (int i = 0; i < maze.length; i++) {
            char[] newRow = new char[maze[i].length + 2];
            newRow[0] = MapType.Wall.toChar();
            System.arraycopy(maze[i], 0, newRow, 1, maze[i].length);
            newRow[newRow.length - 1] = MapType.Wall.toChar();
            newMaze[i + 1] = newRow;
        }
        newMaze[newMaze.length - 1] = new char[maze[0].length + 2];
        Arrays.fill(newMaze[newMaze.length - 1], MapType.Wall.toChar());

        return newMaze;
    }
}