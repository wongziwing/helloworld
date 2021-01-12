package dataStructure.list;

import java.util.*;

/**
 * 模拟实现单向链表
 * @param <E>
 */
public class SinglyLinkedList<E> implements List<E> {

    // 头指针
    private Node<E> head;

    // 数组大小
    private int size;

    public SinglyLinkedList(){
        this.size = 0;
        head = new Node<>();
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
        Node node = head;
        while (node.next != null){
            if (node.next.data == o){
                return true;
            }
            // 指针后移一位
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {

        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        Node node = head;
        // 将指针移向最后一位
        while (node.next != null){
            node = node.next;
        }
        Node<E> temp = new Node<>();
        temp.data = e;
        node.next = temp;
        this.size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node node = head;
        while (node.next != null){
            if (node.next.data == o){
                Node temp = node.next.next;
                node.next = temp;
                this.size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
        head = new Node<>();
    }

    @Override
    public E get(int index) {
        checkArrIndex(index);
        Node<E> node = head;
        for (int i = 0; i <= index; i++){
            node = node.next;
        }
        return (E)node.data;
    }

    @Override
    public E set(int index, E element) {
        checkArrIndex(index);
        Node<E> node = head;
        for (int i = 0; i <= index; i++){
            node = node.next;
        }
        node.data = element;
        return element;
    }

    /** 检测索引是否越界 */
    private void checkArrIndex(int index) {
        if (index < 0 || index >= this.size){
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
    }

    @Override
    public void add(int index, E element) {
        checkArrIndex(index);
        Node<E> node = head;
        for (int i = 1; i <= index; i++){
            node = node.next;
        }
        Node<E> temp = new Node<>();
        temp.data = element;
        temp.next = node.next;
        node.next = temp;
        this.size++;
    }

    @Override
    public E remove(int index) {
        checkArrIndex(index);
        Node<E> node = head;
        for (int i = 1; i <= index; i++){
            node = node.next;
        }
        E e = (E)node.next.data;
        Node<E> temp = node.next.next;
        node.next = temp;
        this.size--;
        return e;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = head;
        for (int i = 0; i < size; i++){
            if (node.next.data == o){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        //TODO 使用双链表解决
        return -1;
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
        checkArrIndex(fromIndex);
        if (toIndex > this.size || toIndex < fromIndex){
            throw new IllegalArgumentException();
        }
        SinglyLinkedList<E> list = new SinglyLinkedList<>();
        Node<E> node = head.next;
        for (int i = 0; i < fromIndex; i++){
            node = node.next;
        }
        for (int i = fromIndex; i < toIndex; i++){
            list.add(node.data);
            node = node.next;
        }
        return list;
    }

    /** 每一个节点 */
    private static class Node<E>{
        Node next;
        E data;
    }

}
