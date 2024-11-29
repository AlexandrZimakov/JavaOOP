package Lesson1;

import java.util.List;

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
        List<Person> johnsChildren = familyTree.getChildren(john);
        for (Person child : johnsChildren) {
            System.out.println("John's child: " + child.getName());
        }
    }

}
