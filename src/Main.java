import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        FileService fileService = new FileService();
        Count count1 = new Count(string, fileService, true, false);
        count1.start();
        Count count2 = new Count(string, fileService, false, true);
        count2.start();
    }
}
