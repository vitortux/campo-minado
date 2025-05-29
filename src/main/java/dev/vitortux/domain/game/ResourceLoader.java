package dev.vitortux.domain.game;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ResourceLoader {

    public String load(String path) {
        try (InputStream is = ResourceLoader.class.getResourceAsStream(path);
                Scanner scanner = new Scanner(is, StandardCharsets.UTF_8)) {
            scanner.useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao carregar arquivo " + path;
        }
    }
}
