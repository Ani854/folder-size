import java.io.File;
import java.util.LinkedHashSet;

public class FileService {
    public static LinkedHashSet<Long> lengths = new LinkedHashSet<>();
    volatile boolean isFinished = false;
    volatile boolean isActiveCalculator = false;
    volatile boolean isActivePrinter = false;

    public synchronized void folderSizeCalculator(File directory) {
        if (!isActiveCalculator) {
            isActiveCalculator = true;
            folderSize(directory);
            isFinished = true;
        }
        if (!isActivePrinter) {
            isActivePrinter = true;
            print();
        }
    }

    public synchronized long folderSize(File directory) {
        long len = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                len += file.length();
                lengths.add(len);
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                len += folderSize(file);
            }
        }
        notify();
        return len;

    }

    public synchronized void print() {
        while (!isFinished) {
            if (!lengths.isEmpty()) {
                for (long l : lengths) {
                    System.out.println(l);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lengths.clear();
                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}