package hust.soict.hedspi.aims.disc;

public class DigitalVideoDisc {
    // Attributes
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Class variables to manage IDs and count of DVDs
    private static int nbDigitalVideoDiscs = 0;

    // Instance variable for ID
    private int id;

    // accessors and mutators for the class hust.soict.dsai.aims.disc.DigitalVideoDisc
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Constructor

    // Default constructor
    public DigitalVideoDisc() {
        // Increment the count of DVDs and assign the ID
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    // Create a DVD object by title
    public DigitalVideoDisc(String title) {
        this(); // Call the default constructor to set ID
        this.title = title;
    }

    // Create a DVD object by category, title, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this(); // Call the default constructor to set ID
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Create a DVD object by director, category, title, and cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(); // Call the default constructor to set ID
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    // Create a DVD object by all attributes: title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(); // Call the default constructor to set ID
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    public void setId() {
        id = getNbDigitalVideoDiscs();
        nbDigitalVideoDiscs++;
    }
}
