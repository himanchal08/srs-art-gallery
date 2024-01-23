package src.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class EnvReader {
    private Map<String, String> env;

    public EnvReader() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(".env"));
            for (String line : lines) {
                String[] parts = line.split("=", 1);
                this.env.put(parts[0], parts[1]);
            }
        } catch (Exception e) {
            
        }

        for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
            this.env.put(entry.getKey(), entry.getValue());
        }
    }

    public String get(String key) {
        return this.env.get(key);
    }
}
