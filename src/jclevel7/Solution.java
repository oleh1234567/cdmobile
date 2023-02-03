package jclevel7;

/*
Batch CrUD: multiple Creations, Updates, Deletions.

The program runs with one of the following sets of arguments:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Argument values:
name (String)
sex ("m" or "f")
bd (birth date in the following format: 04 15 1990)
-c (adds all people with the specified arguments to the
end of allPeople; displays their ids in the appropriate order)
-u (updates the corresponding data of people with the specified ids)
-d (performs the logical deletion of the person with the specified id;
replaces all of its data with null)
-i (displays information about all people with the specified ids: name sex bd)

The id corresponds to the index in the list.
The birth date format is Apr 15 1990.
All the people should be stored in allPeople.
The order in which data is displayed corresponds to the order in which is input.
Be sure the program is thread safe (works correctly
with multiple threads without corrupting the data).
Use Locale.ENGLISH as the second argument for SimpleDateFormat.

Example output for the -i argument with two ids:
Washington m Apr 15 1990
Ross f Apr 25 1997

Requirements:
•	The Solution class must contain a public volatile List<Person> field
called allPeople.
•	The Solution class must have a static block where two people
are added to the allPeople list.
•	With the -c argument, the program must add all people with the
specified arguments to the end of the allPeople list,
and display the id of each of them.
•	With the -u argument, the program must update the data of the people
with the specified ids in the allPeople list.
•	With the -d argument, the program must perform the logical
deletion of the people with the specified ids in the allPeople list.
•	With the -i argument, the program should display data
about all the people with the specified ids according to
the format specified in the task.
•	The Solution class's main method must contain a switch statement based on args[0].
/Each case label in the switch statement must have a synchronization block for allPeople.
*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD

*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format =
                new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
        SimpleDateFormat outoutFormat =
                new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    create(args, format);
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    update(args, format);
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    delete(args);
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    idDisplay(args, outoutFormat);
                }
                break;
        }
    }

    private static void idDisplay(String[] args, SimpleDateFormat outoutFormat) {
        Person person;
        for (int i = 1; i < args.length; i++) {
            person = allPeople.get(Integer.parseInt(args[i]));
            System.out.print(person.getName());
            if (person.getSex().equals(Sex.FEMALE)) {
                System.out.print(" f ");
            }
            if (person.getSex().equals(Sex.MALE)) {
                System.out.print(" m ");
            }
            System.out.println(outoutFormat.format(person.getBirthDate()));
        }
    }

    private static void delete(String[] args) {
        Person person;
        for (int i = 1; i < args.length; i++) {
            person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }

    private static void update(String[] args, SimpleDateFormat format)
            throws ParseException {
        Person person;

        for (int i = 1; i < args.length; i+=4) {
            person = allPeople.get(Integer.parseInt(args[i]));

            person.setName(args[i+1]);

            if (args[i+2].equals("m"))
                person.setSex(Sex.MALE);
            if (args[i+2].equals("f"))
                person.setSex(Sex.FEMALE);

            person.setBirthDate(format.parse(args[i+3]));
        }
    }

    private static void create(String[] args, SimpleDateFormat format)
            throws ParseException {
        for (int i = 1; i < args.length; i += 3) {
            if (args[i+1].equals("m"))
                allPeople.add(Person.createMale(args[i], format.parse(args[i+2])));
            if (args[i+1].equals("f"))
                allPeople.add(Person.createFemale(args[i], format.parse(args[i+2])));
            System.out.println(allPeople.size() - 1);
        }
    }
}


