package com.mohit.lockedme;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //printing application and developer name
        System.out.println("<<<<<<<File Management System>>>>>>>");
        System.out.println("\t Implemented by Mohit Kumar");
        System.out.println("Please enter your directory location for operation");
        String path=scanner.next();
        path=path.replace("\\","/" );

        FileOperation.setPath(path);

        while (true) {
            System.out.println("1: Get File detail in ascending order");
            System.out.println("2: Add file \t Delete file \t Search \t Exit ");
            System.out.println("3: Close the application ");

            System.out.println("Please enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: FileOperation.getFileFromPath();
                    break;
                //get file in ascending order
                //path
                case 2:
                    boolean flag = false;
                    System.out.println("enter your choice");
                    while (!flag) {
                        System.out.println("1. Add file \t 2. delete file \t 3. search file \t 4. exit ");
                        int select = scanner.nextInt();
                        if (select == 1) {
                            //add file
                            System.out.println("enter find name to be created");
                            String filename = scanner.next();
                            FileOperation.addFile(filename.toLowerCase());

                        } else if (select == 2) {
                            //delete file
                            System.out.println("enter file name to be deleted");
                            String filename = scanner.next();
                            FileOperation.deleteFile(filename.toLowerCase());
                        } else if (select == 3) {
                            //search file
                            System.out.println("enter file name to be searched");
                            String filename = scanner.next();
                            FileOperation.searchFile(filename);
                        } else {
                            flag = true;
                        }
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid operation choice");

            }
        }
    }

}
