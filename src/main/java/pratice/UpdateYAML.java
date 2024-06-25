package pratice;

import com.xtime.automation.core.manager.DriverManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateYAML {
    public static void main(String[] args) {
        String scriptDir = Paths.get("").toAbsolutePath().toString();
        String sourceYamlFile = Paths.get(scriptDir, ".", ".github", "workflows", "cm3.yml").toString();

        List<String> options = Arrays.asList("major", "minor", "patch", "prerelease");

        List<String> currentOptionsArray = readOptionsFromYaml(sourceYamlFile);

        if (currentOptionsArray.equals(options)) {
            System.out.println("Values in YAML file are equal to values in array. No update needed.");
        } else {
            System.out.println("Values in YAML file are not equal to values in array. Updating YAML file.");
            updateYamlOptions(sourceYamlFile, options);
        }
    }

    private static List<String> readOptionsFromYaml(String filePath) {
        List<String> options = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("on.workflow_dispatch.inputs.version.options")) {
                    int startIndex = line.indexOf('[');
                    int endIndex = line.lastIndexOf(']');
                    if (startIndex != -1 && endIndex != -1) {
                        String[] optionTokens = line.substring(startIndex + 1, endIndex).split(",");
                        for (String token : optionTokens) {
                            options.add(token.trim().replace("\\", ""));
                        }
                    }
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return options;
    }

    private static void updateYamlOptions(String filePath, List<String> options) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + ".temp"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("on.workflow_dispatch.inputs.version.options")) {
                    writer.write("      options: [");
                    for (int i = 0; i < options.size(); i++) {
                        writer.write("\"" + options.get(i) + "\"");
                        if (i < options.size() - 1) {
                            writer.write(", ");
                        }
                    }
                    writer.write("]\n");
                } else {
                    writer.write(line + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Rename temporary file to original file
        Path tempFile = Paths.get(filePath + ".temp");
        Path originalFile = Paths.get(filePath);
        try {
            java.nio.file.Files.move(tempFile, originalFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
