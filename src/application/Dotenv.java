package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dotenv {
    private static final Map<String, String> MAP = new HashMap<>();

    static {
        load();
    }

    public static void load() {
        MAP.clear();
        Path p = Paths.get(System.getProperty("user.dir"), ".env");
        if (!Files.exists(p)) {
            return;
        }

        try {
            List<String> lines = Files.readAllLines(p);
            for (String raw : lines) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;
                int idx = line.indexOf('=');
                if (idx <= 0)
                    continue;
                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();
                if ((value.startsWith("\"") && value.endsWith("\"")) ||
                        (value.startsWith("'") && value.endsWith("'"))) {
                    value = value.substring(1, value.length() - 1);
                }
                MAP.put(key, value);
            }
        } catch (IOException e) {
        }
    }

    public static String get(String key, String defaultValue) {
        String v = MAP.get(key);
        if (v != null)
            return v;
        String env = System.getenv(key);
        return env != null ? env : defaultValue;
    }
}
