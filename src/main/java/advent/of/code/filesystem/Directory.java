package advent.of.code.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private final String directoryName;
    private String fullDirectoryName;
    private int directorySize = 0;

    public List<Directory> childrenDirectories = new ArrayList<>();
    private final List<File> filesInFolder = new ArrayList<>();
    private final Directory parentDirectory;

    public Directory(String directoryName, Directory parentDirectory) {
        if (directoryName.isEmpty()) {
            throw new IllegalArgumentException("Directory must have a name!");
        }
        this.parentDirectory = parentDirectory;
        this.directoryName = directoryName;
        getFullDirectoryName("/" + directoryName, this);
    }

    public void addToDirectorySize(int additionalSize) {
        System.out.println("Filesize of directory '" + getFullName() + "' is:" + additionalSize + " added to exisiting filesize of: " + directorySize);
        directorySize += additionalSize;
        System.out.println("New Filesize is:" + directorySize);
    }

    private void getFullDirectoryName(String fileName, Directory directory) {
        if (directory.parentDirectory == null){
            setFullName(fileName);
        }
        else{
            setFullName("/" + directory.getParentFolder().getDirectoryName() + fileName);
            getFullDirectoryName(getFullName(), directory.getParentFolder());
        }
    }

    private void setFullName(String fileName) {
        fullDirectoryName = fileName;
    }

    public String getFullName() {
        return fullDirectoryName;
    }

    public int getDirectorySize() {
        return directorySize;
    }

    public Directory getParentFolder() {
        return parentDirectory;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public List<Directory> getChildrenFolders() {
        return childrenDirectories;
    }

    public List<File> getFilesInFolder() {
        return filesInFolder;
    }
}
