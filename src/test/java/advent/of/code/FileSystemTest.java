package advent.of.code;

import advent.of.code.filesystem.File;
import advent.of.code.filesystem.FileOrganizer;
import advent.of.code.filesystem.Directory;
import advent.of.code.filesystem.FileStructureCsvReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileSystemTest {
    public static final String FILE_INFORMATION_FILE_PATH = "C:\\dev\\AdventOfCode2022\\src\\test\\resources\\FileInformation.csv";
    @Test
    public void doInput(){
        Directory rootDirectory = new Directory( "/", null);
        FileOrganizer fileOrganizer = new FileOrganizer();
        fileOrganizer.getAllDirectories().add(rootDirectory);
        Directory directory = fileOrganizer.executeCommand(rootDirectory, "$ ls" );
        directory = fileOrganizer.executeCommand(directory, "dir a" );
        directory = fileOrganizer.executeCommand(directory, "14848514 b.txt" );
        directory = fileOrganizer.executeCommand(directory, "8504156 c.dat" );
        directory = fileOrganizer.executeCommand(directory, "dir d" );
        directory = fileOrganizer.executeCommand(directory, "$ cd a" );
        directory = fileOrganizer.executeCommand(directory, "$ ls" );
        directory = fileOrganizer.executeCommand(directory, "dir e" );
        directory = fileOrganizer.executeCommand(directory, "29116 f" );
        directory = fileOrganizer.executeCommand(directory, "2557 g" );
        directory = fileOrganizer.executeCommand(directory, "62596 h.lst" );
        directory = fileOrganizer.executeCommand(directory, "$ cd e" );
        directory = fileOrganizer.executeCommand(directory, "$ ls" );
        directory = fileOrganizer.executeCommand(directory, "584 i" );
        directory = fileOrganizer.executeCommand(directory, "$ cd .." );
        directory = fileOrganizer.executeCommand(directory, "$ cd .." );
        directory = fileOrganizer.executeCommand(directory, "$ cd d" );
        directory = fileOrganizer.executeCommand(directory, "$ ls" );
        directory = fileOrganizer.executeCommand(directory, "4060174 j" );
        directory = fileOrganizer.executeCommand(directory, "8033020 d.log" );
        directory = fileOrganizer.executeCommand(directory, "5626152 d.ext" );
        fileOrganizer.executeCommand(directory, "7214296 k" );
        FileStructureCsvReader fileStructureCsvReader = new FileStructureCsvReader();
        List<Directory> directories = fileStructureCsvReader.calculateLists(fileOrganizer);
        List<Directory> smallDirectories = fileStructureCsvReader.getFilesUnder100000(directories);

        assertThat(smallDirectories).hasSize(2);
        Directory directoryA = smallDirectories.stream().filter(e -> e.getDirectoryName().equals("a")).findFirst().orElseThrow();
        Directory directoryE = smallDirectories.stream().filter(e -> e.getDirectoryName().equals("e")).findFirst().orElseThrow();

        assertThat(directoryA.getDirectorySize()).isEqualTo(94853);
        assertThat(directoryE.getDirectorySize()).isEqualTo(584);

    }

    @Test
    public void readFileInput(){
        FileStructureCsvReader fileStructureCsvReader = new FileStructureCsvReader();
        List<Directory> directories = fileStructureCsvReader.readFileStructureCommand(FILE_INFORMATION_FILE_PATH);
        List<Directory> smallDirectories = fileStructureCsvReader.getFilesUnder100000(directories);
        System.out.println(smallDirectories.size());
        System.out.println(smallDirectories
                .stream()
                .mapToInt(Directory::getDirectorySize)
                .sum());
        assertThat(smallDirectories).isNotEmpty();
    }

    @Test
    public void getFileCloseToNumber(){
        FileStructureCsvReader fileStructureCsvReader = new FileStructureCsvReader();
        List<Directory> directories = fileStructureCsvReader.readFileStructureCommand(FILE_INFORMATION_FILE_PATH);
        int diretoryClostestTo = fileStructureCsvReader.getDiretoryClostestTo(directories, 8748071);
        assertThat(diretoryClostestTo + 8748071).isEqualTo(9847279);
    }
}
