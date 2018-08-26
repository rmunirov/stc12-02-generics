package ru.innopolis.stc12.generics.part1;

import java.util.*;

public class ObjectBox {
    private List list = new ArrayList<>();

    public ObjectBox(Collection values) {
        list.addAll(values);

        try {
            sort();
        } catch (MyNotNumberException e) {
            System.out.println(e);
        }
    }

    public ObjectBox() {
    }

    private void sort() throws MyNotNumberException {
        if (list.isEmpty()) return;

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < list.size(); i++) {
                if (!(list.get(i) instanceof Number)) {
                    throw new MyNotNumberException("Sort failed, one or more items is not are Number");
                }

                if (!(list.get(i - 1) instanceof Number)) {
                    throw new MyNotNumberException("Sort failed, one or more items is not are Number");
                }

                Number temp = (Number) list.get(i);

                if (((Number) list.get(i - 1)).doubleValue() > ((Number) list.get(i)).doubleValue()) {
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                    swapped = true;
                }
            }
        } while (swapped != false);
    }

    public double summator() throws MyNotNumberException {
        if (list.isEmpty()) return 0.0;

        double result = 0.0;

        for (Object item : list) {
            if (!(item instanceof Number)) {
                throw new MyNotNumberException("Summation failed, one or more items is not are Number");
            }
            result += ((Number) item).doubleValue();
        }

        return result;
    }

    public Set splitter(Integer div) throws MyNotNumberException {
        if (list.isEmpty()) return new HashSet();

        if (div == 0) return new HashSet();

        Set result = new HashSet();
        try {
            for (Object item : list) {
                Double divResult = ((Number) item).doubleValue() / div;
                result.add(divResult);
            }
        } catch (ClassCastException e) {
            throw new MyNotNumberException("Division failed, one or more items is not are Number");
        } catch (Exception e) {
            throw new MyNotNumberException("Division failed, something wrong");
        }
        return result;
    }

    public boolean remove(Object value) {
        return list.remove(value);
    }

    public void addObject(Object value) {
        list.add(value);

        try {
            sort();
        } catch (MyNotNumberException e) {
            System.out.println(e);
        }

    }

    public boolean deleteObject(Object value) {
        return list.contains(value);
    }

    public String dump() {
        return list.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox objectBox = (ObjectBox) o;
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
