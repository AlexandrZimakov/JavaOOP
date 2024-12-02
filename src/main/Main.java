package main;

import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
// Создаем людей
        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);
// Устанавливаем родительские связи
        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);
// Добавляем людей в древо
        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);
// Пример получения всех детей Джона
        System.out.println("Сортировака по имени:");
        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthday());
        }
        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthday();
        for (Person person : familyTree) {
            System.out.println(person.getName() + " - " + person.getBirthday());
        }

        FileOperations fileOps = new FileOperationsImpl();
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("\nFamily tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree = fileOps.loadFromFile("familyTree.dat");
            System.out.println("family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (loadedFamilyTree != null) {
            System.out.println("\nLoaded person:");
            for (Person person : loadedFamilyTree) {
                System.out.println(person.getName() + ", born in " + person.getBirthday());
            }
        }
    }

}
