package advent.of.code.filesystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileStructureCsvReader {

    public List<Directory> readFileStructureCommand(String filePath) {
        String line = "";
        FileOrganizer fileOrganizer = new FileOrganizer();

        Directory rootDirectory = new Directory("/", null);
        fileOrganizer.getAllDirectories().add(rootDirectory);
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                if (!line.equals("$ cd /")) {
                    rootDirectory = fileOrganizer.executeCommand(rootDirectory, line);
                }
            }
            List<Directory> allDirectories = fileOrganizer.getAllDirectories();
            allDirectories
                    .forEach(fileOrganizer::calculateFileSize);
            return allDirectories
                    .stream()
                    .filter(e -> e.getDirectorySize() <= 100000)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO remove, for tests
    public List<Directory> calculateLists(FileOrganizer fileOrganizer) {
        List<Directory> dirUnder100 = new ArrayList<>();
        try {
            List<Directory> allDirectories = fileOrganizer.getAllDirectories();
            for (Directory directory : allDirectories) {
                fileOrganizer.calculateFileSize(directory);
            }
            for (Directory directory : allDirectories) {
                if (directory.getDirectorySize() <= 100000) {
                    dirUnder100.add(directory);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dirUnder100;
    }
}
