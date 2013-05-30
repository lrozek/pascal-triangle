package pl.samples.triangle;

public class PascalTriangleGenerator {

    int size;

    Integer[][] triangle;

    public PascalTriangleGenerator( int size ) {
        if ( size <= 0 ) {
            throw new IllegalArgumentException( "only positive numbers are allowed" );
        }
        this.size = size;
    }

    public void generate() {
        init();
        fillSides();
        calculate();
    }

    private void init() {
        triangle = new Integer[size][];
        for ( int row = 0; row < triangle.length; row++ ) {
            triangle[row] = new Integer[row + 1];
        }
    }

    private void fillSides() {
        int row = 0;
        while ( row < size ) {
            triangle[row][0] = 1;
            triangle[row][row] = 1;
            row++;
        }
    }

    private void calculate() {
        for ( int row = 2; row < size; row++ ) {
            for ( int column = 1; column <= row - 1; column++ ) {
                triangle[row][column] = triangle[row - 1][column - 1] + triangle[row - 1][column];
            }
        }
    }

    public Integer[][] getResult() {
        return triangle;
    }

}
