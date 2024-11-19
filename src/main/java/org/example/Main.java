package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.example.hello_world_native.hello_world;

public class Main {

    private static Path getResourceDir() throws URISyntaxException {
        return Path.of(Main.class.getClassLoader().getResource("stub.txt").toURI()).getParent();
    }

    private static void loadDynamicLibrariesWindows() throws URISyntaxException, IOException {
        Path windows = getResourceDir().resolve("native/windows_x86_x64");
        try (Stream<Path> stream = Files.walk(windows)) {
            stream.filter(file -> file.toString().endsWith(".dll")).forEach(file -> System.load(file.toString()));
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        loadDynamicLibrariesWindows();
        hello_world();
    }
}