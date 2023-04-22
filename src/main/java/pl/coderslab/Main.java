package pl.coderslab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
        //tasks = getTasks("/Users/piotr/Desktop/CodersLab/Blok1/Workshoop_1/TaskManager/src/main/resources/tasks.csv");
        options();
    }

    static String[][] tasks;



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

    public static String[][] getTasks (String fileName){
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            System.out.println("File not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(path);
            tab = new String[strings.size()][strings.get(0).split(",").length];

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }





    public static void options() {
        Path path = Paths.get("/Users/piotr/Desktop/CodersLab/Blok1/Workshoop_1/TaskManager/src/main/resources/tasks.csv");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();


        switch (option) {
            case "1":
                System.out.println("add");

                System.out.println("Pleas add task description");
                String addDescription = scanner.nextLine();
                try {
                    Files.writeString(path, addDescription);
                    //String[][] array = Arrays.
                } catch (IOException e) {
                    System.out.println("Description cannot be saved");
                }


                System.out.println("Please add task date");
                String addDate = scanner.nextLine();
                try {
                    Files.writeString(path, addDate);
                } catch (IOException e) {
                    System.out.println("Date cannot be saved");
                }


                System.out.println("Is you task is important");
                String addImportant = scanner.nextLine();
                try {
                    Files.writeString(path, addImportant);
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
                System.out.println("list");
                getTasks("/Users/piotr/Desktop/CodersLab/Blok1/Workshoop_1/TaskManager/src/main/resources/tasks.csv");
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