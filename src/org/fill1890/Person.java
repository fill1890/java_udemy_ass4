package org.fill1890;

public class Person {
    // first, middle, last names
    protected String first_name;
    protected String middle_names;
    protected String last_name;
    // id (can be SSN, bank assigned, whatever)
    protected int id;

    public Person(String first_name, String middle_names, String last_name, int id) {
        this.first_name = first_name;
        this.middle_names = middle_names;
        this.last_name = last_name;
        this.id = id;
    }

    public Person(String first_name, String last_name, int id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;

        this.middle_names = "";
    }

    // nickname is first name for purposes of this project
    public String get_nickname() {
        return this.first_name;
    }

    // get the full name (First Middle Last)
    public String get_fullname() {
        // i don't feel like implementing logic to remove the double space with no middle name
        return this.first_name + ' ' + this.middle_names + ' ' + this.last_name;
    }

    // privacy - don't leak details readily
    protected int get_id() {
        return this.id;
    }
}
