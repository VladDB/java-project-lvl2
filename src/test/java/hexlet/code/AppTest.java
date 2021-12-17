package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest {

    @Test
    public void matchingFilesTestJson1() throws IOException {
        String expect = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String result = Differ.generate("./src/test/resources/file1.json",
                "./src/test/resources/file2.json", "stylish");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesTestJson2() throws IOException {
        String expect = "{\n"
                + "    follow: false\n"
                + "    host: hexlet.io\n"
                + "    proxy: 123.234.53.22\n"
                + "    timeout: 50\n"
                + "}";
        String result = Differ.generate("./src/test/resources/file1.json",
                "./src/test/resources/file1.json", "stylish");
        Assertions.assertEquals(expect, result);
    }
    @Test
    public void matchingFilesTestJson3() throws IOException {
        String expect = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String result = Differ.generate("./src/test/resources/file3.json",
                "./src/test/resources/file4.json", "stylish");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesTestYml1() throws IOException {
        String expect = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String result = Differ.generate("./src/test/resources/file1.yaml",
                "./src/test/resources/file2.yaml");
        Assertions.assertEquals(expect, result);
    }
    @Test
    public void matchingFilesTestYaml2() throws IOException {
        String expect = "{\n"
                + "    follow: false\n"
                + "    host: hexlet.io\n"
                + "    proxy: 123.234.53.22\n"
                + "    timeout: 50\n"
                + "}";
        String result = Differ.generate("./src/test/resources/file1.yaml",
                "./src/test/resources/file1.yaml");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesTestYaml3() throws IOException {
        String expect = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String result = Differ.generate("./src/test/resources/file3.yaml",
                "./src/test/resources/file4.yaml");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesPlain() throws IOException {
        String expect = Files.readString(Paths.get("./src/test/resources/result.txt"));
        String result = Differ.generate("./src/test/resources/file3.yaml",
                "./src/test/resources/file4.yaml", "plain");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesPlainJson() throws IOException {
        String expect = Files.readString(Paths.get("./src/test/resources/resultJSON.txt"));
        expect = expect.substring(0, expect.length() - 1);
        String result = Differ.generate("./src/test/resources/file3.yaml",
                "./src/test/resources/file4.yaml", "json");
        Assertions.assertEquals(expect, result);
    }
}
