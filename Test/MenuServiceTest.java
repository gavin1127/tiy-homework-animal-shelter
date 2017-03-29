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
            animals.add(new Animal("steve","cat","calico","one leg"));
            animals.add(new Animal("Bobby","dog","Bulldog","really dumb"));
            animals.add(new Animal("billie","bird","eagle","is scary"));
            animals.add(new Animal("smelly","dog","mutt","smells bad"));

        }

        @Test
        /**
         * given the main menu
         * then user enters 1
         * then 1 is return
         */
        public void When1OnMenuThen1() {
            Scanner scanner = new Scanner("1");
            MenuService menu = new MenuService(scanner);
            int selection = menu.promptForMainMenu();
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
        public void When3OnMenuThen3() {
            // Arrange
            Scanner scanner = new Scanner("3");
            MenuService menu = new MenuService(scanner);
            // Act
            int selection = menu.promptForMainMenu();

            // Assert
            assertThat(selection, equalTo(3));
        }

        @Test
        public void When4OnMenuThen4() {
            // Arrange
            Scanner scanner = new Scanner("4");
            MenuService menu = new MenuService(scanner);
            // Act
            int selection = menu.promptForMainMenu();

            // Assert
            assertThat(selection, equalTo(4));
        }

        @Test
        public void When5OnMenuThen5() {
            // Arrange
            Scanner scanner = new Scanner("5");
            MenuService menu = new MenuService(scanner);
            // Act
            int selection = menu.promptForMainMenu();

            // Assert
            assertThat(selection, equalTo(5));
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
        /**
         * When main menu displayed
         * Then menu includes "1) List Widgets"
         */
        public void whenMainMenuThenListAnimalsPrinted(){
            // Arrange
            Scanner scanner = new Scanner("1");
            MenuService menu = new MenuService(scanner);

            // Act
            menu.promptForMainMenu();

            // Assert
            assertThat(this.outputStream.toString(), containsString("1) List Animals"));
        }

    }

