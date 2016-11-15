import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MapTypeTest - Tests all functionality of MapType
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
public class MapTypeTest {
    /**
     * Test the toChar functionality
     * @throws Exception
     */
    @Test
    public void toChar() throws Exception {
        MapType wall = MapType.Wall,
                blank = MapType.Blank,
                end = MapType.End,
                visited = MapType.Visited,
                path = MapType.Path;

        assertEquals(wall.toChar(), 'W');
        assertEquals(blank.toChar(), ' ');
        assertEquals(end.toChar(), 'E');
        assertEquals(visited.toChar(), 'V');
        assertEquals(path.toChar(), '.');
    }

    /**
     * tests the fromChar functionality
     * @throws Exception
     */
    @Test
    public void fromChar() throws Exception {
        MapType wall = MapType.fromChar('W'),
                blank = MapType.fromChar(' '),
                end = MapType.fromChar('E'),
                visited = MapType.fromChar('V'),
                path = MapType.fromChar('.');

        assertEquals(wall, MapType.Wall);
        assertEquals(blank, MapType.Blank);
        assertEquals(end, MapType.End);
        assertEquals(visited, MapType.Visited);
        assertEquals(path, MapType.Path);

        try {
            MapType illegal = MapType.fromChar('T');
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
        }
    }

}