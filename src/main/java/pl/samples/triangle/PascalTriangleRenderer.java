package pl.samples.triangle;

public class PascalTriangleRenderer {

    Integer[][] triangle;

    public PascalTriangleRenderer( Integer[][] triangle ) {
        this.triangle = triangle;
    }

    public void render() {
        int size = triangle.length;
        int width = triangle[size - 1][ ( size - 1 ) / 2].toString().length() + 1;
        String pattern = "%" + width + "d";
        for ( int row = 0; row < size; row++ ) {
            for ( int col = 0; col <= row; col++ ) {
                String cell = String.format( pattern, triangle[row][col] );
                System.out.print( cell );
            }
            System.out.println();
        }
    }
}
