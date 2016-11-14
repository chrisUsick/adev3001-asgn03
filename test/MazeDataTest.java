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

    /**
     * test the getMaze method
     * @throws Exception
     */
    @Test
    public void getMaze() throws Exception {
        try {
            MazeData badFile = new MazeData("foo");
        } catch (IOException e) {
            assertNotNull("Didn't throw file IO exception", e);
        }

        MazeData file = new MazeData("")

    }

    @Test
    public void getStartingPoint() throws Exception {

    }

}