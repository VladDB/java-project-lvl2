package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

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
        String result = Match.matchingFiles("json", "./src/test/resources/file1.json",
                "./src/test/resources/file2.json");
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
        String result = Match.matchingFiles("json", "./src/test/resources/file1.json",
                "./src/test/resources/file1.json");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesTestYml() throws IOException {
        String expect = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String result = Match.matchingFiles("yaml", "./src/test/resources/file1.yaml",
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
        String result = Match.matchingFiles("yaml", "./src/test/resources/file1.yaml",
                "./src/test/resources/file1.yaml");
        Assertions.assertEquals(expect, result);
    }
}
