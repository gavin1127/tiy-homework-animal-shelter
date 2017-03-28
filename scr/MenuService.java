import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gavin on 3/22/17.
 */
public class MenuService {
    public static final int LIST_ANIMALS = 1;
    public static final int CREATE_ANIMAL = 2;
    public static final int VIEW_ANIMAL_DETAIL = 3;
    public static final int EDIT_ANIMAL = 4;
    public static final int DELETE_ANIMAL = 5;
    public static final int QUIT = 6;


    private Scanner scanner;

    public MenuService(Scanner scanner) {
        this.scanner = scanner;
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

    public void showListOfAnimals(ArrayList<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            System.out.printf("%s) %s\t\t%s%n", (i + 1), animal.getName(), animal.getSpecies());
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

    public void animalUpdate(Animal animal) {
        String input = "";
        input = waitForString(String.format("Name[%s]: ", animal.getName()), false);
        if (!input.isEmpty()){
            animal.setName(input);
        }
        input = waitForString(String.format("Species[%s]: ", animal.getSpecies()), false);
        if (!input.isEmpty()){
            animal.setSpecies(input);
        }
        input = waitForString(String.format("Breed[%s]: ", animal.getBreed()), false);
        if (!input.isEmpty()){
            animal.setBreed(input);
        }
        input = waitForString(String.format("Description[%s]: ", animal.getDescription()), false);
        if (!input.isEmpty()){
            animal.setDescription(input);
        }

    }

}

