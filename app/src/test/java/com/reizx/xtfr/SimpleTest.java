package com.reizx.xtfr;

import org.junit.Test;

/**
 * Created by kig on 2017/11/16.
 */

public class SimpleTest {
    @Test
    public void testStringByte(){
        byte[] byteArray = new byte[] {87, 79, 87, 46, 46, 46};
        String value = new String(byteArray);
        System.out.println(value);

    }
}
