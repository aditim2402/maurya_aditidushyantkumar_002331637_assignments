package model;

import java.util.ArrayList;


public class PersonDirectory {
    
    private ArrayList<Person> persons;
    
    public PersonDirectory(){
        this.persons = new ArrayList<Person>();
    }
    
    public ArrayList<Person> getPersons() {
        return persons;
    }
    
    public void setAccounts(ArrayList<Person> persons){
        this.persons = persons;
    }
    
    public Person addPerson() {
        Person p = new Person();
        persons.add(p);
        return p;
    }
    
    public void deletePerson(Person person){
        persons.remove(person);
    }
    
    public Person searchPerson(String searchTxt) {
        for (Person p : persons){
            if (p.getfName().contains(searchTxt) || p.getlName().contains(searchTxt) || p.getHomeAddress().getStreetAddress().contains(searchTxt) 
                    || p.getWorkAddress().getStreetAddress().contains(searchTxt)){
                return p;
            }
        }
        return null;
    }
}
