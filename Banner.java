

import java.util.ArrayList;

import chapter8.Faculty;
import chapter8.Person;
import chapter8.Staff;
import chapter8.Student;

public class Banner {
    public static void main(String[] args) {
        ArrayList<Person> personsList = new ArrayList<>();

        Person persons[] = new Person[15_000];
        persons[0] = new Student("John Smith", "900000000", "123 street, city, state, zip, usa", "jsmith@samford.edu");
        persons[1] = new Faculty("Jane Doe", "800000000", "456 avenue, city, state, zip, usa", "jdoe@samford.edu");
        persons[2] = new Student("Alice Johnson", "700000000", "789 boulevard, city, state, zip, usa", "ajohnson@samford.edu");
        persons[3] = new Faculty("Bob Brown", "600000000", "101 road, city, state, zip, usa", "bbrown@samford.edu");
        persons[4] = new Staff("Carol White", "500000000", "202 lane, city, state, zip, usa", "cwhite@samford.edu");

        for (Person person : persons) {
            if (person != null) {
                System.out.println("Name: " + person.getName());
                System.out.println("Type: " + person.getType());

            }
        }
    }
}