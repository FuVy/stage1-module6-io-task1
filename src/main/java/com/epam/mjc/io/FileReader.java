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
                    age = Integer.parseInt(line.replace("Age: ", ""));
                } else if (line.startsWith("Email: ")) {
                    email = line.replace("Email: ", "");
                } else if (line.startsWith("Phone: ")) {
                    phone = Long.parseLong(line.replace("Phone: ", ""));
                }
            }
            return new Profile(name, age, email, phone);
        }
        catch (IOException e) {
            return new Profile();
        }
    }
}
