package Examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PersonList {
    public static final String JSON_FILE = "persons.json";
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static void addNewPerson(Scanner scanner, List<Person> persons) throws IOException {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        persons.add(new Person(name, age));
        savePersonToFile(JSON_FILE, persons);
        System.out.println("Человек добавлен");
    }

    public static void savePersonToFile(String filename, List<Person> persons) throws IOException {
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.writeValue(new File(filename), persons);
    }

    public static List<Person> loadPersonsFromFile(String filename){
        List<Person> persons = new ArrayList<>();
        File file = new File(filename);
        if (file.exists()){
            try {
                persons = objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class,Person.class));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return persons;
    }
    public static void displayPersonList(List<Person> persons){
        for (Person person:persons){
            System.out.println(person.toString());
        }
    }
    public static void deletePerson(Scanner scanner,List<Person>persons) throws IOException {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        for (int i = 0; i < persons.size(); i++) {
            if (Objects.equals(persons.get(i).getName(), name)){
                persons.remove(persons.get(i));
            }
        }
        savePersonToFile(JSON_FILE,persons);
        displayPersonList(persons);
    }
    public static void updatePerson(Scanner scanner,List<Person>persons) throws IOException {
        System.out.println("Введите имя человека которого вы хотите изменить");
        String name = scanner.nextLine();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().equals(name)){
                System.out.println("Введите новое имя: ");
                String newName = scanner.nextLine();
                persons.get(i).setName(newName);
                System.out.println("Введите новый возраст");
                int newAge = Integer.parseInt(scanner.nextLine());
                persons.get(i).setAge(newAge);
                savePersonToFile(JSON_FILE,persons);
            } else System.out.println("Человек не найден");
        }

    }
}
