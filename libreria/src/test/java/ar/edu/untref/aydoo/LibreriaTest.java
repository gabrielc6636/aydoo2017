package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 02/04/17.
 */
public class LibreriaTest {
    @Test
    public void doFooShouldReturnFoo()
    {
        Foo foo = new Foo();
        String result = foo.doFoo();
        Assert.assertEquals("foo", result);
    }
}
