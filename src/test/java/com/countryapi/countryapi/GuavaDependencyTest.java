package com.countryapi.countryapi;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GuavaDependencyTest {

    @Test
    void testDependency() {
        List<Integer> list = List.of(1, 2, 3);

        List<Integer> reversed = Lists.reverse(list);

        assertEquals(reversed.size(), 3);
        assertEquals(reversed.get(0), 3);
        assertEquals(reversed.get(1), 2);
        assertEquals(reversed.get(2), 1);
    }
}
