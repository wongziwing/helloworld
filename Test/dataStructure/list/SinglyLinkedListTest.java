package dataStructure.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SinglyLinkedListTest {

    @Test
    void singlyLinkedListTest(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    }

    @Test
    void addTest(){
        SinglyLinkedList sll = new SinglyLinkedList();
        System.out.println("abc = " + sll.add("abc"));
        System.out.println("size = " + sll.size());
        System.out.println("isEmpty = " + sll.isEmpty());
    }

    @Test
    void containsTest(){
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        System.out.println(list.contains("c"));
    }

    @Test
    void removeTest(){
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list.size = " + list.size());
        list.remove("a");
        list.add(1, "d");
        System.out.println("list.size() = " + list.size());
    }

    @Test
    void clearTest(){
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list.size() = " + list.size());
        list.clear();
        System.out.println("list.size() = " + list.size());
    }

    @Test
    void toArrayTest(){
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++){
            System.out.println(i + " = " + objects[i]);
        }
    }

    @Test
    void getTest(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add(1, "c");
        System.out.println(list.size());
        System.out.println(list.get(1));
    }

    @Test
    void removeByIndexTest(){
        SinglyLinkedList<Object> list = new SinglyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println("list.remove(2) = " + list.remove(2));
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }

    @Test
    void indexOfTest(){
        List<Object> list = new SinglyLinkedList<>();
        addData(list);
        System.out.println("list.size() = " + list.size());
        System.out.println(list.indexOf("\\"));
    }

    void addData(List list){
        for (int i = 0; i < 26; i++){
            String s = String.valueOf((char)(i + 97));
            list.add(s);
        }
    }

    @Test
    void listTest(){
        ArrayList<String> list = new ArrayList<>();
        addData(list);
        System.out.println("list.set(0, \"A\") = " + list.set(0, "A"));
    }

}
