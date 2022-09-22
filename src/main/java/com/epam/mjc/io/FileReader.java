package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {

        Profile profile = new Profile();

        try (FileInputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[is.available()];
            while (is.read(buffer) > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (byte chr : buffer) {
                    stringBuilder.append((char)chr);
                }
                String result = stringBuilder.toString();
                String[] data = result.split("\n");

                profile.setName(data[0].split(":")[1].trim());
                profile.setAge(Integer.parseInt(data[1].split(":")[1].trim()));
                profile.setEmail(data[2].split(":")[1].trim());
                profile.setPhone(Long.parseLong(data[3].split(":")[1].trim()));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
