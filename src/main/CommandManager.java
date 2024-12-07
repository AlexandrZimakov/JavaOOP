package main;
import model.FamilyTree;
import model.Person;
import service.FileOperations;
import service.FileOperationsImpl;

import java.io.IOException;
import java.util.Scanner;


public class CommandManager {
    private FamilyTree<Person> familyTree;
    private Scanner scanner;
    public CommandManager(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        FileOperations<Person> fileOps = new FileOperationsImpl<>();
        while (true) {
            System.out.println("Введите команду (add, list, sortByName, sortByBirthYear, save, load, exit):");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    addPerson();
                    break;
                case "list":
                    listPeople();
                    break;
                case "sortByName":
                    familyTree.sortByName();
                    listPeople();
                    break;
                case "sortByBirthYear":
                    familyTree.sortByBirthYear();
                    listPeople();
                    break;
                case "save":
                    try {
                        fileOps.saveToFile(familyTree, "familyTree.dat");
                        System.out.println("\nFamily tree saved to file.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
// implement save logic
                case "load":
                    try {
                        familyTree = fileOps.loadFromFile("familyTree.dat");
                        System.out.println("Family tree loaded from file.");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
// implement load logic
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }
    private void addPerson() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения:");
        int birthYear = Integer.parseInt(scanner.nextLine());
        Person person = new Person(name, birthYear);
        familyTree.addMember(person);
        System.out.println("Человек добавлен в дерево.");
    }
    private void listPeople() {
        for (Person person : familyTree) {
            System.out.println(person.getName() + ", родился в " + person.getBirthYear());
        }
    }
}
