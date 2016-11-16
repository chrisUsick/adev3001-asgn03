import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * MapDataTest - Tests all functionality of MapData
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: November 14, 2016
 *
 * Revision Log
 * Who          When    Reason
 * --------- ---------- ----------------------------------
 *
 * </pre>
 *
 * @author Chris Usick
 * @version 1.0
 *
 */
public class MazeDataTest {

    private MazeData maze01;

    /**
     * Initialize the state before the test
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        maze01 = new MazeData("unittest01.maze");
    }

    /**
     * test the constructor of the MazeData class
     * @throws Exception
     */
    @Test
    public void constructor() throws Exception {
        try {
            MazeData badFile = new MazeData("foo");
        } catch (IOException e) {
            assertNotNull("Didn't throw file IO exception", e);
        }

        try {
            MazeData badFormat = new MazeData("unittest02.maze");
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }

    /**
     * test the getMaze method
     * @throws Exception
     */
    @Test
    public void getMaze() throws Exception {
        char[][] maze = maze01.getMaze();
        assertEquals(maze.length, 3);
        assertEquals(maze[0].length, 3);
        assertEquals(maze[0][0], 'W');

    }

    @Test
    public void getStartingPoint() throws Exception {
        Point startingPoint = maze01.getStartingPoint();
        assertEquals(startingPoint.getRow(), 1);
        assertEquals(startingPoint.getColumn(), 1);
    }

}