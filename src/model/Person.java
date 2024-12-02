package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int birthday;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, int birthday) {
        this.name = name;
        this.birthday = birthday;
        this.children = new ArrayList<>();
    }

    public String getName() {//получить
        return name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setMother(Person mother) {//присвоить
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void addChild(Person child){
        this.children.add(child);
    }

    public List<Person> getChildren(){
        return children;
    }

    public Person getMother(){
        return mother;
    }

    public Person getFather(){
        return father;
    }
}