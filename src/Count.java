import java.io.File;

public class Count extends Thread {
    private String filePath;
    private FileService fileService = new FileService();

    public Count(String filePath, FileService fileService) {
        this.filePath = filePath;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        fileService.folderSizeCalculator(new File(filePath));
    }
}
