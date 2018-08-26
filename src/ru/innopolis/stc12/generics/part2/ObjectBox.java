package ru.innopolis.stc12.generics.part2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ObjectBox<T> {
    protected List<T> list = new ArrayList();

    public ObjectBox(Collection values) {
        list.addAll(values);
    }

    public ObjectBox() {
    }

    public void addObject(T value) {
        list.add(value);
    }

    public boolean deleteObject(T value) {
        return list.remove(value);
    }

    public String dump() {
        return list.toString();
    }

    public int count() {
        return list.size();
    }

    public T getObject(int index) {
        return list.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(list, objectBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "ObjectBox{" +
                "list=" + list +
                '}';
    }
}
