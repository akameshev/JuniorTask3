package Examples;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        startProgram();
    }
    private static void startProgram() throws IOException {
        List <Person> personList = PersonList.loadPersonsFromFile(PersonList.JSON_FILE);
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Добро пожаловать в картотеку Persons");
            System.out.println("1.Добавить человека");
            System.out.println("2.Изменить данные человека");
            System.out.println("3.Удалить человека");
            System.out.println("4.Отобразить текущий список людей");
            System.out.println("5.Выйти из картотеки");
            System.out.println();
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    PersonList.addNewPerson(scanner,personList);
                    break;
                case "2":
                    PersonList.updatePerson(scanner,personList);
                    break;
                case "3":
                    PersonList.deletePerson(scanner,personList);
                    break;
                case "4":
                    PersonList.displayPersonList(personList);
                    break;
                case "5":
                    System.exit(0);
                    break;
            }

        }
    }
}
