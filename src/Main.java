import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        FileService fileService = new FileService();
        Count count1 = new Count(string, fileService);
        count1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Count count2 = new Count(string, fileService);

        count2.start();
    }
}
