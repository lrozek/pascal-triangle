package pl.samples.triangle;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PascalTriangleGeneratorTest {

    @Test
    public void itShouldGenerate3DimTriangle() {
        //given
        PascalTriangleGenerator generator = new PascalTriangleGenerator( 3 );

        //when
        generator.generate();

        //then
        Integer[][] triangle = generator.getResult();
        assertThat( triangle, is( notNullValue() ) );
        assertThat( triangle[2][1], is( 2 ) );
    }

    @Test
    public void itShouldGenerate5DimTriangle() {
        //given
        PascalTriangleGenerator generator = new PascalTriangleGenerator( 5 );

        //when
        generator.generate();

        //then
        Integer[][] triangle = generator.getResult();
        assertThat( triangle, is( notNullValue() ) );
        assertThat( triangle[4][2], is( 6 ) );
    }

    @Test
    public void itShouldGenerate1DimTriangle() {
        //given
        PascalTriangleGenerator generator = new PascalTriangleGenerator( 1 );

        //when
        generator.generate();

        //then
        Integer[][] triangle = generator.getResult();
        assertThat( triangle, is( notNullValue() ) );
        assertThat( triangle[0][0], is( 1 ) );
    }

    @Test
    public void itShouldGenerate2DimTriangle() {
        //given
        PascalTriangleGenerator generator = new PascalTriangleGenerator( 2 );

        //when
        generator.generate();

        //then
        Integer[][] triangle = generator.getResult();
        assertThat( triangle, is( notNullValue() ) );
        assertThat( triangle[1][1], is( 1 ) );
    }

    @Test
    public void itShouldCreateAdaptiveDimensions() {
        //given
        int arraySize = 5;
        PascalTriangleGenerator generator = new PascalTriangleGenerator( arraySize );

        //when
        generator.generate();

        //then
        Integer[][] triangle = generator.getResult();
        assertThat( triangle, is( notNullValue() ) );
        assertAdaptiveArraySize( triangle, arraySize );
    }

    @Test
    public void itShouldThrowExceptionWhenCreatingGeneratorWith0() {
        //given

        try {
            //when
            new PascalTriangleGenerator( 0 );
            fail();
        }
        catch ( IllegalArgumentException e ) {
            //then
            assertThat( e.getMessage(), is( notNullValue() ) );
            assertThat( e.getMessage(), is( "only positive numbers are allowed" ) );
        }
    }

    @Test
    public void itShouldThrowExceptionWhenCreatingGeneratorWithNegativeSie() {
        //given

        try {
            //when
            new PascalTriangleGenerator( -5 );
            fail();
        }
        catch ( IllegalArgumentException e ) {
            //then
            assertThat( e.getMessage(), is( notNullValue() ) );
            assertThat( e.getMessage(), is( "only positive numbers are allowed" ) );
        }
    }

    private void assertAdaptiveArraySize( Integer[][] array, int arraySize ) {
        assertThat( array.length, is( arraySize ) );
        for ( int row = 0; row < array.length; row++ ) {
            Integer[] rowArray = array[row];
            assertThat( rowArray.length, is( row + 1 ) );
        }
    }
}