package dataStructure.list;

import java.util.*;

public class SinglyLinkedList<E> extends AbstractList<E> implements List<E> {

    private final Point head;

    private int size;

    public SinglyLinkedList(){
        this.head = new Point();
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null){
            throw new NullPointerException();
        }
        Point temp = this.head;
        while (temp.next != null){
            if (o.equals(temp.next.data)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] objects = new Object[this.size];
        Point temp = this.head;
        while (temp.next != null){
            objects[index] = temp.next.data;
            temp = temp.next;
            index++;
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        if (o == null) {
            throw new NullPointerException("it is null");
        }
        Point object = new Point();
        object.data = o.toString();
        Point temp = this.head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = object;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Point temp = this.head;
        while (temp.next != null){
            if (temp.next.data.equals(o.toString())){
                temp.next = temp.next.next;
                this.size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        Iterator iterator = c.iterator();
        Point temp = this.head;
        // 指针移动最后
        while (temp.next != null){
            temp = temp.next;
        }
        while (iterator.hasNext()){
            if (iterator.next() == null){
                throw new NullPointerException();
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Point temp = this.head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        return (E) temp.next.data;
    }

    @Override
    public E set(int index, Object element) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Point temp = this.head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        temp.next.data = element;
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        if (element == null){
            throw new NullPointerException();
        }
        Point temp = this.head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        Point point = new Point();
        point.data = element.toString();
        point.next = temp.next.next;
        temp.next = point;
        this.size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException();
        }
        Point temp = this.head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        Point point = temp.next;
        temp.next = point.next;
        this.size--;
        return (E) point.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Point temp = this.head;
        while (temp.next != null){
            if (o.equals(temp.next.data)){
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private static class Point<E>{
        private Point next;
        private E data;
    }

}
