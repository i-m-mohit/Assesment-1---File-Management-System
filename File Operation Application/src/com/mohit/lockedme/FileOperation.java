package com.mohit.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileOperation {

    public static  String path = "";


    public static void getFileFromPath() {
        try {
            File file = new File(path);
            List<String> fileList = new ArrayList<>();
            for (File fileEntry : file.listFiles()) {
                fileList.add(fileEntry.getName());
            }
            List<String> collect = fileList.stream().sorted().collect(Collectors.toList());
            collect.stream().forEach(System.out::println);
        }

        catch (Exception exception) {
            System.out.println("error while fetching file details!!");
        }
    }

    public static void addFile(String filename) throws IOException {
        try {
            File myWriter = new File(path + filename);

            if (myWriter.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File not created");
            }
        }
        catch (Exception exception) {
            System.out.println("error while adding the file "+filename+" please try again!!!");
        }

    }

    public static void deleteFile(String fileName) {
        File file = new File(path + fileName);
        if (fileExist(file)) {
            if (file.delete()) {
                System.out.println("file deleted successfully");
            }
        } else {
            System.out.println("file not present");
        }
    }

    public static void searchFile(String fileName) {

        File file = new File(path + fileName.toLowerCase());
        if (fileExist(file)) {
            System.out.println("file found " + fileName);
        } else {
            System.out.println("file not found" + fileName);
        }
    }

    public static boolean fileExist(File file) {
        return file.exists() ? true : false;
    }
    public static void setPath(String p) {
        path=p+"/";
    }


}
