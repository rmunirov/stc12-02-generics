package ru.innopolis.stc12.generics.part2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MathBox<T extends Number> extends ObjectBox<T> {
    public MathBox(Collection values) {
        super(values);
        sort();
    }

    public MathBox() {
        super();
    }

    private void sort() {
        if (list.isEmpty()) return;

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < list.size(); i++) {

                T temp = list.get(i);

                if ((list.get(i - 1)).doubleValue() > (list.get(i)).doubleValue()) {
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                    swapped = true;
                }
            }
        } while (swapped != false);
    }

    // пришлось перееопределить, чтобы ругался во время компиляции, если передать не наследника Number, верно?
    public void addObject(T value) {
        list.add(value);
        sort();
    }

    public double summator() {
        if (list.isEmpty()) return 0.0;

        double result = 0.0;

        for (Object item : list) {
            result += ((Number) item).doubleValue();
        }

        return result;
    }

    public Set splitter(Integer div) {
        if (list.isEmpty()) return new HashSet();

        if (div == 0) return new HashSet();

        Set result = new HashSet();
        for (Object item : list) {
            Double divResult = ((Number) item).doubleValue() / div;
            result.add(divResult);
        }

        return result;
    }
}
