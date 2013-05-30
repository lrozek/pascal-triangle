package pl.samples.triangle;

public class PascalTriangeMain {

    public static void main( String[] args ) {
        PascalTriangleGenerator gen6 = new PascalTriangleGenerator( 20 );
        PascalTriangleGenerator gen7 = new PascalTriangleGenerator( 7 );
        gen6.generate();
        gen7.generate();
        Integer[][] triangle6 = gen6.getResult();
        Integer[][] triangle7 = gen7.getResult();
        PascalTriangleRenderer rend6 = new PascalTriangleRenderer( triangle6 );
        PascalTriangleRenderer rend7 = new PascalTriangleRenderer( triangle7 );
        rend6.render();
        rend7.render();
    }

}
