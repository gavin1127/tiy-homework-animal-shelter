import java.util.ArrayList;
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

    public void ShowAnimalList(ArrayList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.printf("%s) %s\t\t%s%n", (i + 1), animal.getName(), animal.getSpecies());
        }
    }

    public int promptForMainMenuSelection() {
        System.out.println("\n-- Main Menu --\n" +
                "\n" +
                "1) List animals\n" +
                "2) Create an animal\n" +
                "3) View animal details\n" +
                "4) Edit an animal\n" +
                "5) Delete an animal\n" +
                "6) Quit\n");

        return waitForInt("Please choose an option:");
    }

    public int waitForInt(String prompt) {
        System.out.println(prompt);
        if (!scanner.hasNextInt()) {
            String invalidInput = scanner.next();
            System.out.printf("'%s' is not a valid number. Please try again.\n", invalidInput);
            return waitForInt(prompt);
        } else {
            return scanner.nextInt();
        }
    }

    public String waitForString(String prompt, boolean required) {
        System.out.println(prompt);
        String input = scanner.next();
        if (required == true && input.isEmpty()) {
            System.out.println("This must be filled out! \n");
            return waitForString(prompt, required);
        } else {
            return input;
        }
    }

    public void showAnimalDetails(ArrayList<Animal> animals, int i) {
        Animal animal = animals.get(i - 1);
        System.out.printf(
                "Name: " + animal.getName() +
                        "\nSpecies: " + animal.getSpecies() +
                        "\nBreed: " + animal.getBreed() +
                        "\nDescription: " + animal.getDescription());
    }

    public void sayQuitting() {
        System.out.println("Quitting Animal Shelter");
    }

    public Animal createAnimal() {
        String name = waitForString("Animal Name: ", true);
        String species = waitForString("Species: ", true);
        String breed = waitForString("Breed(Optional): ", false);
        String description = waitForString("Add Description", true);
        Main.animals.add(new Animal(name,species,breed,description));
        System.out.println("\n" + "New Animal Added");
        return null;
    }
}

