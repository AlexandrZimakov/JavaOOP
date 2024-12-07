package dz5.view;

import dz5.presenter.TreePresenter;
import model.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private TreePresenter presenter;
    private Scanner scanner;

    public ConsoleTreeView(){
        this.scanner = new Scanner(System.in);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayPersons (List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.getName() + ", born in " + person.getBirthYear());
        }
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void setPresenter(TreePresenter presenter) {
        this.presenter = presenter;
    }
}
