import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Gavin on 3/31/17.
 */
public class AnimalTest {

        @Test
        public void canCreateNewAnimal() {
            // Arrange
            Animal animal = new Animal(
                    "Gavin",
                    "dog",
                    "bulldog",
                    "ugly");
            // Assert
            assertThat(animal.getName(), equalTo("Gavin"));
            assertThat(animal.getDescription(), equalTo("ugly"));
            assertThat(animal.getBreed(), equalTo("bulldog"));
            assertThat(animal.getSpecies(), equalTo("dog"));
        }
    }
