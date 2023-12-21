package hust.soict.hedspi.aims.cart;
import java.util.Collections;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 100;
    private int totalMedia = 0;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

//	public void addMedia(Media media) {
//		if (itemsOrdered.contains(media)) {
//			System.out.println("Media " + media.getTitle() + " has been added");
//		} else {
//			itemsOrdered.add(media);
//			totalMedia++;
//			media.setId(totalMedia);
//			System.out.println("Media " + media.getTitle() + " is added successfully");
//		}
//	}

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (itemsOrdered.contains(media)) {
                System.out.println("Media " + media.getTitle() + " has been added");
            } else {
                itemsOrdered.add(media);
                totalMedia++;
                media.setId(totalMedia);
                System.out.println("Media " + media.getTitle() + " is added successfully");
            }
        } else {
            throw new LimitExceededException("ERROR : The number of " + "media has reached its limit");
        }
    }

    public void removeMedia(Media media) {
        int index = itemsOrdered.indexOf(media);
        if (index != -1) {
            itemsOrdered.remove(index);
            System.out.println("Media" + media.getTitle() + " has been deleted");
            totalMedia--;
        } else
            System.out.println("Media " + media.getTitle() + " not found");
    }

    public void totalCost() {
        float sumCost = 0;
        for (Media media : itemsOrdered) {
            sumCost += media.getCost();
        }
        System.out.println("Total cost : " + sumCost);
    }

    public float getCost() {
        float sumCost = 0;
        for (Media media : itemsOrdered) {
            sumCost += media.getCost();
        }
        return sumCost;
    }

    public Media searchTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public Media searchId(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;

    }

    public int getQuantity() {
        return itemsOrdered.size();
    }

    public void removeAllMedia() {
        itemsOrdered.clear();
    }

    public void printCart() {
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        printCart();
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        printCart();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
