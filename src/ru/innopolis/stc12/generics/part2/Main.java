package ru.innopolis.stc12.generics.part2;

public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox();

        mathBox.addObject(13);
        mathBox.addObject(34);
        mathBox.addObject(53);
        mathBox.addObject(12);
        mathBox.addObject(56);
        mathBox.addObject(51.2);
        mathBox.addObject(41.6);
        //mathBox.addObject("value");

        System.out.println(mathBox.dump());

        System.out.println(mathBox.summator());

        System.out.println(mathBox.splitter(3));


        System.out.println(mathBox.deleteObject(53));
        System.out.println(mathBox.dump());

    }
}
