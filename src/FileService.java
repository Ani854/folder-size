import java.io.File;

public class FileService {
    public static long size = 0;

    public void folderSizeCalculator(File directory, boolean isCalculate, boolean isPrint) {
        if (isCalculate) {
            folderSize(directory);
        }
        if (isPrint) {
            print();
        }
    }

    public void folderSize(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                size += file.length();
            } else {
                folderSize(file);
            }
        }
    }

    public void print() {
        long oldValue = 0;
        try {
            Thread.sleep(100);
            while (oldValue != size) {
                System.out.println(size);
                oldValue = size;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
