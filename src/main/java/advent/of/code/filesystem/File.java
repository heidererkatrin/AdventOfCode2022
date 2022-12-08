package advent.of.code.filesystem;

public class File {
    private final String name;
    private final int filesize;

    public File(String filesize, String name) {
        this.filesize = Integer.parseInt(filesize);
        this.name = name;
    }

    public int getFilesize() {
        return filesize;
    }
}
