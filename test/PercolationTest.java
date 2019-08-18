import static org.junit.Assert.*;

import org.junit.Test;

public class PercolationTest {

    private static final int GRID_SIZE = 5;
    private Percolation percolation;
   




    @Test
    public void shouldOpenAGrid() {
        // given
    	percolation = new Percolation(GRID_SIZE);
        assertFalse(percolation.isOpen(1, 1));

        // when
        percolation.open(1, 1);

        // then
        assertTrue(percolation.isOpen(1, 1));
    }

    @Test
    public void shouldPercolate() {
        // when
    	percolation = new Percolation(GRID_SIZE);
        percolation.open(1, 2);
        percolation.open(2, 2);
        percolation.open(3, 2);
        percolation.open(4, 2);
        percolation.open(5, 2);

        // then
        assertTrue(percolation.percolates());
    }

    @Test
    public void shouldNotPercolate() {
        // when
    	percolation = new Percolation(GRID_SIZE);
        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 4);
        percolation.open(1, 5);

        // then
        assertFalse(percolation.percolates());
    }

    @Test
    public void shouldBeFull() {
        // when
    	percolation = new Percolation(GRID_SIZE);
        percolation.open(1, 1);
        percolation.open(1, 2);

        // then
        assertTrue(percolation.isFull(1, 2));
    }

    @Test
    public void shouldNotBeFull() {
        // when
    	percolation = new Percolation(GRID_SIZE);
        percolation.open(3, 2);

        // then
        assertFalse(percolation.isFull(3, 2));
    }

    @Test
    public void shouldNotBeFilled() {
        // when
    	percolation = new Percolation(GRID_SIZE);
        percolation.open(1, 3);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);
        percolation.open(5, 3);
        percolation.open(5, 5);

        // then
        assertTrue(percolation.isFull(1, 3));
        assertTrue(percolation.isFull(2, 3));
        assertTrue(percolation.isFull(3, 3));
        assertTrue(percolation.isFull(4, 3));
        assertTrue(percolation.isFull(5, 3));
        assertFalse(percolation.isFull(5, 5));
    }

    @Test
    public void shouldNotPercolateInCornerCase() {
        percolation = new Percolation(1);
        assertFalse(percolation.percolates());
        percolation.open(1, 1);
        assertTrue(percolation.percolates());
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void shouldThrowIllegalArgumentExceptionIfGridSizeIsZero() {
//        new Percolation(0);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void shouldThrowIllegalArgumentExceptionIfGridSizeIsNegative() {
//        new Percolation(-5);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void shouldThrowIndexOutOfBoundsExceptionIfOpenIsCalledWithZero() {
//        percolation.open(0, 0);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void shouldThrowIndexOutOfBoundsExceptionIfOpenIsCalledWithFieldOutsideTheGrid() {
//        percolation.open(GRID_SIZE+1, GRID_SIZE+1);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void shouldThrowIndexOutOfBoundsExceptionIfIsOpenIsCalledWithZero() {
//        percolation.isOpen(0, 0);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void shouldThrowIndexOutOfBoundsExceptionIfIsOpenIsCalledWithFieldOutsideTheGrid() {
//        percolation.isOpen(GRID_SIZE + 1, GRID_SIZE + 1);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void shouldThrowIndexOutOfBoundsExceptionIfIsFullIsCalledWithZero() {
//        percolation.isFull(0, 0);
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void shouldThrowIndexOutOfBoundsExceptionIfIsFullIsCalledWithFieldOutsideTheGrid() {
//        percolation.isFull(GRID_SIZE + 1, GRID_SIZE + 1);
//    }

}