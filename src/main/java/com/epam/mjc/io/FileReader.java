package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String name = null;
            Integer age = null;
            String email = null;
            Long phone = null;
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    name = line.replace("Name: ", "");
                } else if (line.startsWith("Age: ")) {
                    try {
                        age = Integer.parseInt(line.replace("Age: ", ""));
                    } catch (NumberFormatException e) {
                    }
                } else if (line.startsWith("Email: ")) {
                    email = line = line.replace("Email: ", "");
                } else if (line.startsWith("Phone: ")) {
                    try {
                        phone = Long.parseLong(line.replace("Phone: ", ""));
                    } catch (NumberFormatException e) {

                    }
                }
            }
            return new Profile(name, age, email, phone);
        }
        catch (IOException e) {
            return new Profile();
        }
    }
}
