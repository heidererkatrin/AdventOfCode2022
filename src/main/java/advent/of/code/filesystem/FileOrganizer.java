package advent.of.code.filesystem;

import java.util.ArrayList;
import java.util.List;

public class FileOrganizer {
    private final List<Directory> allDirectories = new ArrayList<>();

    public Directory executeCommand(Directory currentDirectory, String input) {
        if (input.startsWith("dir")) {
            createDirectoryWithName(currentDirectory, input.split("dir ")[1]);
        } else if (input.equals("$ cd ..")) {
            return currentDirectory.getParentFolder();
        } else if (input.startsWith("$ cd")) {
            String[] folderName = input.split("cd ");
            return currentDirectory.getChildrenFolders()
                    .stream()
                    .filter(e -> e.getDirectoryName().equals(folderName[1]))
                    .findFirst()
                    .orElseThrow();
        } else if (!input.startsWith("$ ls")) {
            String[] fileNameAndSize = input.split(" ");
            currentDirectory.getFilesInFolder().add(new File(fileNameAndSize[0], fileNameAndSize[1]));
        }
        return currentDirectory;
    }

    private void createDirectoryWithName(Directory currentDirectory, String dirName) {
        Directory directory = new Directory(dirName, currentDirectory);
        currentDirectory.getChildrenFolders().add(directory);
        allDirectories.add(directory);
    }

    public List<Directory> getAllDirectories() {
        return allDirectories;
    }

    public void calculateFileSize(Directory directory) {
        int internalFileSize = getInternalFileSize(directory);
        directory.addToDirectorySize(internalFileSize);
        addFilesizeToParentDirectory(directory, internalFileSize);
    }

    private int getInternalFileSize(Directory initDirectory) {
        System.out.println("Filesize of Folder: " + initDirectory.getDirectoryName());
        return initDirectory.getFilesInFolder().stream()
                .mapToInt(File::getFilesize)
                .sum();
    }

    private void addFilesizeToParentDirectory(Directory initDirectory, int internalFileSize) {
        if (initDirectory.getParentFolder() != null) {
            initDirectory.getParentFolder().addToDirectorySize(internalFileSize);
            if (initDirectory.getParentFolder().getParentFolder() != null) {
                addFilesizeToParentDirectory(initDirectory.getParentFolder(), internalFileSize);
            }
        }
    }
}
