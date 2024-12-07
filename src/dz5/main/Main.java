package dz5.main;

import dz5.presenter.TreePresenter;
import dz5.view.ConsoleTreeView;
import model.FamilyTree;
import model.Person;
import service.FileOperationsImpl;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        ConsoleTreeView view = new ConsoleTreeView();
        FileOperationsImpl<Person> fileOperations = new
                FileOperationsImpl<>();
        TreePresenter presenter = new TreePresenter(familyTree,
                view, fileOperations);
        presenter.handleUserInput();
    }

}
