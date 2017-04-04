/**
 * Created by Gavin on 3/29/17.
 */
public class Animal {
    String Name;
    String Species;
    String Breed;
    String Description;

    public Animal(String Name, String Species, String Breed, String Description) {
        this.Name = Name;
        this.Species = Species;
        this.Breed = Breed;
        this.Description = Description;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecies() {
        return Species;
    }

    public void setSpecies(String species) {
        Species = species;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
