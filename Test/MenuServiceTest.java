import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

    public class MenuServiceTest {
        ByteArrayOutputStream outputStream;
        private ArrayList animals;

        @Before
        public void before() {
            // setup output capturing
            this.outputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(this.outputStream);
            System.setOut(printStream);
            animals = new ArrayList<>();
            animals.add(new Animal("steve", "cat", "calico", "one leg"));
            animals.add(new Animal("Bobby", "dog", "Bulldog", "really dumb"));
            animals.add(new Animal("billie", "bird", "eagle", "is scary"));
            animals.add(new Animal("smelly", "dog", "mutt", "smells bad"));

        }

        @Test
        /**
         * given the main menu
         * then user enters 1
         * then 1 is return
         */
        public void When1OnMenuThen1() {
            //arrange
            Scanner scanner = new Scanner("1");
            MenuService menu = new MenuService(scanner);
            //act
            int selection = menu.promptForMainMenu();
            //assert
            assertThat(selection, equalTo(1));
        }

        @Test
        /**
         * Given the main menu
         * When the user enters 2
         * Then 2 is returned
         */
        public void when2onMainMenuThen2() {
            // Arrange
            Scanner scanner = new Scanner("2");
            MenuService menu = new MenuService(scanner);

            // Act
            int selection = menu.promptForMainMenu();

            // Assert
            assertThat(selection, equalTo(2));
        }

        @Test
        public void When6OnMenuThen6() {
            // Arrange
            Scanner scanner = new Scanner("6");
            MenuService menu = new MenuService(scanner);
            // Act
            int selection = menu.promptForMainMenu();

            // Assert
            assertThat(selection, equalTo(6));
        }

        @Test
        public void WhenMoreThen6OnMenuThenFail() {
            // Arrange
            Scanner scanner = new Scanner("7");
            MenuService menu = new MenuService(scanner);
            // Act
            int selection = menu.promptForMainMenu();

            // Assert
            assertThat(selection, equalTo(0));
        }

        @Test
        /**
         * When main menu prompt
         * Then the menu is displayed
         */
        public void whenMainMenuThenMenuPrinted() {
            // Arrange
            Scanner scanner = new Scanner("");
            MenuService menu = new MenuService(scanner);

            // Act
            menu.promptForMainMenu();

            // Assert
            assertThat(this.outputStream.toString(), containsString(
                    "-- Main Menu --\n" +
                            "1) List Animals\n" +
                            "2) Create an Animal\n" +
                            "3) View an Animal\n" +
                            "4) Edit an Animal\n" +
                            "5) Delete an Animal\n" +
                            "6) Quit\n\n" +
                            "Select an option: "));
        }

        @Test
        public void whenAnimalListedThenAllAreShown() {
            // Arrange
            Scanner scanner = new Scanner("");
            MenuService menu = new MenuService(scanner);

            // Act
            menu.ShowAnimalList(animals);

            // Assert
            assertThat(outputStream.toString(), containsString("steve\t\tcat"));
            assertThat(outputStream.toString(), containsString(" Bobby\t\tdog"));
            assertThat(outputStream.toString(), containsString("billie\t\tbird"));
        }

        @Test
        public void whenQuitThenQuiting() {
            // Arrange
            Scanner scanner = new Scanner("");
            MenuService menu = new MenuService(scanner);

            // Act
            menu.sayQuitting();

            // Assert
            assertThat(outputStream.toString(), containsString("Quiting Animal Shelter"));
        }

        // @Test

        /**
         * When creating a widget
         * Then correct widget created
         */
        public void whenCreatingAnimalThenAnimalCreated() {
            // Arrange
            Scanner scanner = new Scanner("bill\n" +
                    "dog\n" +
                    "lab\n" +
                    "is dog\n");
            MenuService menu = new MenuService(scanner);

            // Act
            Animal animal = menu.createAnimal();

            // Assert

            assertThat(animal.getName(), equalTo("Name: bill"));
            assertThat(animal.getSpecies(), equalTo("Species: dog"));
            assertThat(animal.getBreed(), equalTo("Breed: lab"));
            assertThat(animal.getDescription(), equalTo("Description: is dog"));

        }

        @Test
        public void whenInvalidNumberThenReenter() {
            // Arrange
            Scanner scanner = new Scanner("");
            MenuService menu = new MenuService(scanner);

            // Act
            menu.sayInvalidReenter();

            // Assert
            assertThat(outputStream.toString(), containsString("invalid input"));
        }
        @Test
        /**
         * Given a prompt for an integer
         * When 321 is input
         * Then 321 is returned
         */
        public void whenWaitForIntThen321IsReturned(){
            // Arrange
            Scanner scanner = new Scanner("321\n");
            MenuService menu = new MenuService(scanner);

            // Act
            int input = menu.waitForInt("Enter an int: ");

            // Assert
            assertThat(outputStream.toString(), containsString("Enter an int: "));
            assertThat(input, equalTo(321));
        }

    }

