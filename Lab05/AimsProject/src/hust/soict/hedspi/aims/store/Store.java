package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private int totalMedia = 0;
    ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Media " + media.getTitle() + " has been added");
        }
        else
        {
            itemsInStore.add(media);
            totalMedia++;
            media.setId(totalMedia);
            System.out.println("Media " + media.getTitle() + " is added successfully");
        }
    }
    public void removeMedia(Media media) {
        int index = itemsInStore.indexOf(media);
        if (index != -1) {
            itemsInStore.remove(index);
            System.out.println("Media" + media.getTitle() + " has been deleted");
        }
        else System.out.println("Media " + media.getTitle() + " not found");
    }

    public Media searchTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }
    public static void showMenu() {
        System.out.println("AIMS");
        System.out.println("---------------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
        System.out.println("Options");
        System.out.println("------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("---------------------------------");
        System.out.println("Please choose a number : 0-1-2-3-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options");
        System.out.println("----------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("---------------------------------");
        System.out.println("Please choose a number : 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options");
        System.out.println("---------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("-------------------------");
        System.out.println("Please choose a number 0-1-2-3-4-5");
    }

}
