package chapter9;

import java.util.NoSuchElementException;

import my.util.DLinkedList;
import my.util.DNode;

public class DLinkedListQueue<T> implements Queue<T> {

    private final DLinkedList<T> list;

    public DLinkedListQueue() {
        list = new DLinkedList<>();
    }

    @Override
    public void enqueue(T item) {
        list.add(item);
    }

    @Override
    public T dequeue() throws Exception {
        // TODO (dequeue from head using removeFirst())
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.removeFirst().getData();
    }

    @Override
    public T front() throws Exception {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list.get(0).getData();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
