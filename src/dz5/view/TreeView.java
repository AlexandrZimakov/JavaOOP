package dz5.view;

import dz5.presenter.TreePresenter;
import model.Person;

import java.util.List;

public interface TreeView {
    void displayMessage(String message);
    void displayPersons(List<Person> persons);
    String getUserInput();
    void setPresenter(TreePresenter presenrer);
}
