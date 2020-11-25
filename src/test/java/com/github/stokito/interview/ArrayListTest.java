package com.github.stokito.interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ArrayListTest {

    private AList list = new AList();

    @Test
    public void testListInit() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCapacity() {
        list = new AList(-1);
    }

    @Test
    public void testAppend() {
        list.add("Karol");
        list.add("Vanessa");
        list.add("Amanda");

        assertEquals("Karol", list.get(0));
        assertEquals("Vanessa", list.get(1));
        assertEquals("Amanda", list.get(2));
    }

    @Test
    public void testAddByIndex() {
        list.add(0, "Karol");
        list.add(1, "Vanessa");
        list.add(2, "Amanda");

        assertEquals("Karol", list.get(0));
        assertEquals("Vanessa", list.get(1));
        assertEquals("Amanda", list.get(2));

        list.add(1, "Mariana");

        assertEquals("Karol", list.get(0));
        assertEquals("Mariana", list.get(1));
        assertEquals("Vanessa", list.get(2));
        assertEquals("Amanda", list.get(3));

        assertEquals(4, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAddElementNull() {
        list.add(0, null);
    }

    @Test(expected = NullPointerException.class)
    public void testSetElementNull() {
        list.add(0, "Kheyla");
        list.set(0, null);
    }

    @Test
    public void testSetElement() {
        list.add(0, "Karol");
        list.add(1, "Vanessa");
        list.add(2, "Amanda");

        list.set(1, "Livia");

        assertEquals("Karol", list.get(0));
        assertEquals("Livia", list.get(1));
        assertEquals("Amanda", list.get(2));
    }

    @Test
    public void testRemoveElement() {
        list.add(0, "Karol");
        list.add(1, "Vanessa");
        list.add(2, "Amanda");

        assertEquals("Amanda", list.remove(2));
        assertEquals(2, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmptyList() {
        list.remove(0);
    }
}