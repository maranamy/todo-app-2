package org.example;

import java.util.List;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args){
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Простой Todo CLI. Команды: add<task>, remove<index>, list, exit");

        while(true){
            System.out.println("> ");
            if(!scanner.hasNextLine()) break;

            String line = scanner.nextLine().trim();
            if(line.isEmpty()) continue;

            String[] parts = line.split(" ",2);
            String cmd = parts[0].toLowerCase();

            switch(cmd){
                case "add":
                    if(parts.length > 1){
                        list.add(parts[1]);
                        System.out.println("Added!");
                    }
                    else System.out.println("Usage: add <task>");
                    break;
                case "remove":
                    if(parts.length > 1) {
                        try {
                            int index = Integer.parseInt(parts[1]);
                            if (list.remove(index)) System.out.println("Removed successfully!");
                            else System.out.println("Index out of range");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index!");
                        }
                    }
                    else System.out.println("Usage: remove <index>");
                    break;

                case "list":
                    List<String> all = list.getAll();
                    for(int i=0; i<all.size(); i++)
                        System.out.printf("%d: %s%n", i, all.get(i));

                    if(all.isEmpty()) System.out.println("(empty list)");
                    break;
                case "exit":
                    System.out.println("bye-bye");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неизвестная команда! Команды: add, remove, list, exit.");
            }
        }
    }
}
