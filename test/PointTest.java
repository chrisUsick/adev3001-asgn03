import org.junit.Test;

import static org.junit.Assert.*;

/**
 * PointTest - Tests all functionality of Point
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
public class PointTest {

    private Point point;

    /**
     * Tests the functionality of the constructor,
     * and the getters of row and column
     */
    @Test
    public void constructorAndRowAndColumn() {
        point = new Point(1, 0);
        assertNotNull(point);
        assertEquals("Failed to set row", point.getRow(), 1);
        assertEquals("Failed to set column", point.getColumn(), 0);
    }
}