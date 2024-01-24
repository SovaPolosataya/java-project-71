package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and show a difference.")

class App implements Callable<Integer> {

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
            description = "output format [default: stylish]")
    String format;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    static boolean help;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean version;

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        var diff = Differ.generate(filepath1, filepath2, format);
        System.out.println(diff);
        return null;
    }
}
