package dataStructure.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    @Test
    public void size() {
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void isEmpty() {
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void contains() {
        String a = "a";
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add(a);
        Assert.assertTrue(list.contains(a));
        String a2 = "a";
        Assert.assertTrue(list.contains(a2));
        Assert.assertFalse(list.contains("b"));
    }

    @Test
    public void add() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String a = "abc";
        list.add(a);
        Assert.assertEquals(1, list.size());
        Assert.assertTrue(list.contains(a));
        Assert.assertEquals(list.size()-1, list.indexOf(a));
    }

    @Test
    public void remove() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String a = "abc";
        list.add(a);
        list.remove(a);
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains(a));
    }

    @Test
    public void clear() {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        String a = "abc";
        list.add("abc");
        list.clear();
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains(a));
    }

    @Test
    public void get() {
        SinglyLinkedList<String > list = new SinglyLinkedList<>();
        String a = "a";
        String b = "b";
        list.add(a);
        list.add(b);
        Assert.assertEquals(a, list.get(0));
        Assert.assertEquals(b, list.get(list.size()-1));
    }

    @Test
    public void set() {
        SinglyLinkedList<String > list = new SinglyLinkedList<>();
        String a = "a";
        String b = "b";
        String c = "c";
        list.add(a);
        list.add(b);
        list.set(1, c);
        Assert.assertEquals(c, list.get(1));
        Assert.assertTrue(list.contains(c));
    }

    @Test
    public void testAdd() {
        SinglyLinkedList<String > list = new SinglyLinkedList<>();
        String a = "a";
        String b = "b";
        list.add(a);
        list.add(0, b);
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(b, list.get(0));
        Assert.assertTrue(list.contains(b));
    }

    @Test
    public void testRemove() {
        SinglyLinkedList<String > list = new SinglyLinkedList<>();
        String a = "a";
        String b = "b";
        list.add(a);
        list.add(b);
        String e = list.remove(0);
        Assert.assertEquals(a, e);
        Assert.assertFalse(list.contains(a));
    }

    @Test
    public void indexOf() {
        SinglyLinkedList<String > list = new SinglyLinkedList<>();
        String a = "a";
        String b = "b";
        list.add(a);
        list.add(b);
        int index = list.indexOf(a);
        Assert.assertEquals(0, index);
    }

    @Test
    public void subList() {
        SinglyLinkedList<String > list = new SinglyLinkedList<>();
        String a = "a";
        String b = "b";
        String c = "c";
        list.add(a);
        list.add(b);
        list.add(c);
        List<String> subList = list.subList(1, 3);
        for (int i = 0; i < subList.size(); i++){
            Assert.assertEquals(subList.get(i), list.get(i+1));
        }

    }
}