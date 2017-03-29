import java.util.Scanner;

/**
 * Created by Gavin on 3/28/17.
 */
public class MenuService {
    Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
    }

    public int promptForMainMenu() {
        System.out.println(
                "-- Main Menu --\n" +
                        "1) List Animals\n" +
                        "2) Create an Animal\n" +
                        "3) View an Animal\n" +
                        "4) Edit an Animal\n" +
                        "5) Delete an Animal\n" +
                        "6) Quit\n\n" +
                        "Select an option: ");
        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            if (input >= 1 && input <= 6) {
                return input;
            }
        }
        return 0;
    }
}
