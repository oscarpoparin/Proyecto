package com.mycompany.sistema_de_gestion_y_control_escolar.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    public static ImageConfig readConfig() {
        ImageConfig config = new ImageConfig();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rpoo\\Downloads\\Tesis\\Codigo\\Sistema_de_Gestion_y_Control_Escolar\\src\\main\\webapp\\WEB-INF\\resource\\config.properties"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the file structure is key=value
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    if (key.equals("imagePath")) {
                        config.setImagePath(value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return config;
    }
}
