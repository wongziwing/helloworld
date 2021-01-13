package dataStructure.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {

    private static SinglyLinkedList<String> list;

    static {
        list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }

    @Test
    public void size() {
        SinglyLinkedList<Object> list2 = new SinglyLinkedList<>();
        Assert.assertEquals(0, list2.size());
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void isEmpty() {
        SinglyLinkedList<Object> list2 = new SinglyLinkedList<>();
        Assert.assertTrue(list2.isEmpty());
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void contains() {
        String a = "a";
        String f = "f";
        String n = null;
        Assert.assertTrue(list.contains(a));
        Assert.assertFalse(list.contains(f));
        Assert.assertThrows(IllegalArgumentException.class, () -> list.contains(n));
    }

    @Test
    public void add() {
        String e = "e";
        list.add(e);
        Assert.assertEquals(5, list.size());
        Assert.assertTrue(list.contains(e));
    }

    @Test
    public void remove() {
        String b = "b";
        list.remove(b);
        Assert.assertFalse(list.contains(b));
        Assert.assertEquals(3, list.size());
        Assert.assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    @Test
    public void clear() {
        list.clear();
        Assert.assertEquals(0, list.size());
        Assert.assertFalse(list.contains("a"));
    }

    @Test
    public void get() {
        String a = "a";
        Assert.assertEquals(a, list.get(0));
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(list.size()));
    }

    @Test
    public void set() {
        String f = "f";
        int index = 3;
        list.set(index, f);
        Assert.assertEquals(f, list.get(3));
        Assert.assertTrue(list.contains(f));
    }

    @Test
    public void addByIndex() {
        int size = list.size();
        String f = "f";
        int index = 3;
        list.add(3, f);
        Assert.assertEquals(size+1, list.size());
        Assert.assertEquals(f, list.get(index));
        Assert.assertTrue(list.contains(f));
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add(-1, f));
        Assert.assertThrows(IllegalArgumentException.class, () -> list.add(index, null));
    }

    @Test
    public void removeByIndex() {
        int size = list.size();
        String e = list.remove(0);
        Assert.assertEquals(size-1, list.size());
        list.remove(list.size()-1);
        Assert.assertEquals(size-2, list.size());
    }

    @Test
    public void indexOf() {
        String a = "a";
        String f = "f";
        Assert.assertEquals(0, list.indexOf(a));
        Assert.assertEquals(-1, list.indexOf(f));
    }

    @Test
    public void subList() {
        List<String> subList = list.subList(1, 3);
        for (int i = 0; i < subList.size(); i++){
            Assert.assertEquals(subList.get(i), list.get(i+1));
        }
    }

    @Test
    public void toArray(){
        Object[] s = list.toArray();
        Assert.assertEquals(3, s.length);
        for (int i = 0; i < s.length; i++){
            Assert.assertEquals(list.get(i), s[i]);
        }
    }

    @Test
    public void containsAll(){
        ArrayList<String> arrayList = new ArrayList<>();
        String a = "a";
        String b = "b";
        String f = "f";
        arrayList.add(a);
        arrayList.add(b);
        Assert.assertTrue(list.containsAll(arrayList));
        arrayList.add(null);
        Assert.assertThrows(IllegalArgumentException.class, () -> list.containsAll(arrayList));
        arrayList.remove(null);
        arrayList.add(f);
        Assert.assertFalse(list.containsAll(arrayList));
    }

    @Test
    public void addAll(){
        ArrayList<String> arrayList = new ArrayList<>();
        String x = "x";
        String z = "z";
        String y = "y";
        arrayList.add(x);
        arrayList.add(z);
        arrayList.add(y);
        int size = list.size();
        list.addAll(arrayList);
        Assert.assertEquals(size+arrayList.size(), list.size());
    }

    @Test
    public void addAllByIndex(){
        ArrayList<String> arrayList = new ArrayList<>();
        String x = "x";
        String z = "z";
        String y = "y";
        arrayList.add(x);
        arrayList.add(z);
        arrayList.add(y);
        int index = 3;
        list.addAll(index, arrayList);
        for (int i = index; i < index+arrayList.size(); i++){
            Assert.assertEquals(arrayList.get(i-index), list.get(i));
        }
    }


}