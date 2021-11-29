package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

class VersionedCommand {

  @Parameters(paramLabel = "filepath1", description = "path to first file")
    File file1;

  @Parameters(paramLabel = "filepath2", description = "path to second file")
    File file2;

  @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format;

  @Option(names = { "-V", "--version" }, versionHelp = true, description = "print version information and exit")
    boolean versionRequested;

  @Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
  boolean usageHelpRequested;
 }


public class App {
  public static void main(String[] args) {

    CommandLine commandLine = new CommandLine(new VersionedCommand());
    commandLine.parseArgs(args);

    if (commandLine.isUsageHelpRequested()) {
      commandLine.usage(System.out);
      return;
    } else if (commandLine.isVersionHelpRequested()) {
      commandLine.printVersionHelp(System.out);
      return;
    }

    System.out.println("Hello, World!");
  }
}

