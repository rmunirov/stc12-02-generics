package ru.innopolis.stc12.generics.part1;

public class Main {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();

        objectBox.addObject(13);
        objectBox.addObject(34);
        objectBox.addObject(53);
        objectBox.addObject(12);
        objectBox.addObject(56);
        objectBox.addObject(51.2);
        objectBox.addObject(41.6);
        //objectBox.addObject("value");

        System.out.println(objectBox.dump());

        try {
            System.out.println(objectBox.summator());
        } catch (MyNotNumberException e) {
            System.out.println(e);
        }

        try {
            System.out.println(objectBox.splitter(0));
        } catch (MyNotNumberException e) {
            System.out.println(e);
        }

        System.out.println(objectBox.remove(53));
        System.out.println(objectBox.dump());

        System.out.println(objectBox.deleteObject(12));

    }
}
