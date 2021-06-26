import java.io.File;

public class Count extends Thread {
    private String filePath;
    private boolean isCalculate;
    private boolean isPrint;
    private FileService fileService = new FileService();

    public Count(String filePath, FileService fileService, boolean isCalculate, boolean isPrint) {
        this.filePath = filePath;
        this.fileService = fileService;
        this.isCalculate = isCalculate;
        this.isPrint = isPrint;
    }

    @Override
    public void run() {
        fileService.folderSizeCalculator(new File(filePath), this.isCalculate, this.isPrint);

    }
}
