import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gavin on 3/24/17.
 */
public class Main {
    private static ArrayList<Animal> animals = new ArrayList<>();



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("[\n]");
        MenuService menu = new MenuService(scan);
        load();




        while (true) {
            int action = menu.promptForMainMenuSelection();

            if (action == MenuService.LIST_ANIMALS) {
                menu.showListOfAnimals(animals);
            }
            else if (action == MenuService.CREATE_ANIMAL){
                System.out.println("\n-- Create Animal --\n");
                System.out.println("Fill out animal Requirements");
                String name = menu.waitForString("Animal Name: ", true);
                String species = menu.waitForString("Species: ", true);
                String breed = menu.waitForString("Breed(Optional): ", false);
                String description = menu.waitForString("Add Description", true);
                animals.add(new Animal(name,species,breed,description));
                System.out.println("\n" + "New Animal Added");
            }
            else if (action == MenuService.VIEW_ANIMAL_DETAIL){
                //System.out.println("What is the numeric ID of the animal you want to view?");
                 int i = menu.waitForInt("What is the numeric ID of the animal you want to view?");
                 if (i > animals.size()){
                    System.out.println("Error: No animal with this number exist");
                 }
                else{
                     menu.showAnimalDetails(animals, i);
                 }

                //menu.showAnimalDetails(animals, i);
            }
            else if (action == MenuService.EDIT_ANIMAL){
                System.out.println("-- Edit an Animal --");
                int i = menu.waitForInt("What is the numeric ID of the animal you want to edit?: ");
                Animal animal = animals.get(i);
                menu.animalUpdate(animal);
                System.out.println("Animal has been updated");
            }
            else if (action == MenuService.DELETE_ANIMAL) {
                while (true) {
                    int i = menu.waitForInt("What is the numeric ID of the animal you want to delete?");
                    menu.showAnimalDetails(animals, i - 1);
                    //System.out.println("Are you sure you want to delete this animal?:");
                    String answer = menu.waitForString("Are you sure you want to delete this animal?:", true);
                    if (answer.equals("yes")) {
                        animals.remove(i - 1);
                        System.out.println("Success: The animal has been deleted!");
                        break;
                    } else if (answer.equals("no")) {}
                    else {
                        System.out.println("Please enter a valid response");
                    }
                }
            }
            else if (action == MenuService.QUIT){
                System.out.println("application Stopped ");
                break;
            }
            else if (action > 6){
                System.out.println("please enter valid input");
            }
        }


    }
    private static void load(){
        animals.add(new Animal("steve","cat","calico","one leg"));
        animals.add(new Animal("Bobby","dog","Bulldog","really dumb"));
        animals.add(new Animal("billie","bird","eagle","is scary"));
        animals.add(new Animal("nugget","cat","mixed","is a nugget"));
        animals.add(new Animal("smelly","dog","mutt","smells bad"));
        animals.add(new Animal("ugly","dog","mutt","is ugly"));

    }
}
