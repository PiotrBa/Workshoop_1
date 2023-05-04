package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
        options();
    }

    public static void menu() {
        final String BLUE = "\033[0;34m";
        System.out.println(BLUE.concat("Please select an option"));
        final String RESET = "\033[0m";
        System.out.println(RESET.concat("1 add"));
        System.out.println("2 remove");
        System.out.println("3 list");
        System.out.println("4 exit");
        System.out.println();
        options();
    }


    public static void options() {
        Path path = Paths.get("/Users/piotr/Desktop/CodersLab/Blok1/Workshoop_1/TaskManager/src/main/resources/tasks.csv");
        List<String> addList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();


        switch (option) {
            case "1":

                System.out.println("Pleas add task description");
                addList.add(scanner.nextLine());
                try {
                    Files.write(path, addList, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("Description cannot be saved");
                }


                System.out.println("Please add task date (yyyy-mm-dd):");
                addList.add(scanner.nextLine());
                try {
                    Files.write(path, addList, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("Date cannot be saved");
                }


                System.out.println("Is you task is important");
                addList.add(scanner.nextLine());
                try {
                    Files.write(path, addList, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("Important status cannot be saved");
                }


                while (true) {
                    menu();
                    options();
                }
            case "2":
                System.out.println("remove");
                while (true) {
                    menu();
                    options();
                }
            case "3":
                try {
                    for (String line : Files.readAllLines(path)) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


                while (true) {
                    menu();
                    options();
                }
            case "4":
                System.out.println("exit");
                break;
            default:
                System.out.println("Please select correct option.");
        }
    }
}