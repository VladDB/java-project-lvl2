package hexlet.code;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class AppTest {

    @Test
    public void matchingFilesTest1() throws IOException {
        String expect = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        String result = Match.matchingFiles("./example/file1.json", "./example/file2.json");
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void matchingFilesTest2() throws IOException {
        String expect = "{\n"
                + "    follow: false\n"
                + "    host: hexlet.io\n"
                + "    proxy: 123.234.53.22\n"
                + "    timeout: 50\n"
                + "}";
        String result = Match.matchingFiles("./example/file1.json", "./example/file1.json");
        Assertions.assertEquals(expect, result);
    }
}
