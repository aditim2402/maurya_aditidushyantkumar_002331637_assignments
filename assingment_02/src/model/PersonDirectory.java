/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author aditi
 */
public class PersonDirectory {
    private ArrayList<Person> persons;

    public PersonDirectory() {
        this.persons = new ArrayList<>();
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    // Method to add a new Person to the directory
    public Person addPerson() {
        Person p = new Person();
        persons.add(p);
        return p;
    }

    // Method to delete a Person from the directory
    public void deletePerson(Person person) {
        persons.remove(person);
    }

    // Method to search for a Person by their name (or any unique attribute like ID)
    public Person searchPerson(String personName) {
        for (Person p : persons) {
            if (p.getFirstName().contains(personName) || p.getLastName().contains(personName)) {
                return p;
            }
        }
        return null; 
    }
}
