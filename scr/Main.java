import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Gavin on 3/29/17.
 */
public class Main {
    public static ArrayList<Animal> animals = new ArrayList<>();
    public static Scanner scanner;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("[\n]");
        MenuService menu = new MenuService(scan);
        animals.add(new Animal("steve","cat","calico","one leg"));
        animals.add(new Animal("Bobby","dog","Bulldog","really dumb"));
        animals.add(new Animal("billie","bird","eagle","is scary"));
        animals.add(new Animal("smelly","dog","mutt","smells bad"));
        //load();

        while (true) {
            int action = menu.promptForMainMenuSelection();

            if (action == menu.LIST_ANIMALS) {
                System.out.println("--Animal List--");
                menu.ShowAnimalList(animals);
            }
            if (action == menu.CREATE_ANIMAL){
                System.out.println("\n-- Create Animal --\n");
                System.out.println("Fill out animal Requirements");
                menu.createAnimal();
            }
            if (action == menu.VIEW_ANIMAL_DETAIL){
                int i = menu.waitForInt("What is the numeric ID of the animal you want to view?");
                if (i > animals.size()){
                    System.out.println("Error: No animal with this number exist");
                }
                else{
                    menu.showAnimalDetails(animals, i);
                }
            }
            if (action == menu.EDIT_ANIMAL){
                System.out.println("-- Edit an Animal --");
                int i = menu.waitForInt("What is the numeric ID of the animal you want to edit?: ");
                Animal animal = animals.get(i - 1);
                menu.animalUpdate(animal);
                System.out.println("Animal has been updated");

            }
            if (action == menu.DELETE_ANIMAL){
                menu.deleteAnimal();

            }
            if (action == menu.QUIT){
                menu.sayQuitting();
                break;

            }
            if (action > 6 || action < 1){
               menu.sayInvalidReenter();
            }
        }
    }
}

