package hust.soict.hedspi.aims;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static Cart cart = new Cart();
    private static Store myStore = new Store();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws LimitExceededException, PlayerException {
        while (true) {
            myStore.showMenu();
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    ViewStore();
                    break;
                case 2:
                    System.out.println("Now you can add or remove a media in store");
                    break;
                case 3:
                    CartMenu();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void ViewStore() throws LimitExceededException, PlayerException {
        myStore.storeMenu();
        String title;
        int choose1 = scanner.nextInt();
        switch (choose1) {
            case 1:
                title = scanner.nextLine();
                System.out.println("Media : " + myStore.searchTitle(title).toString());

                break;
            case 2:
                title = scanner.nextLine();
                cart.addMedia(myStore.searchTitle(title));
                System.out.println("Add media to cart successfully");
                break;
            case 3:
                title = scanner.nextLine();
                Media media = myStore.searchTitle(title);
                PlayMedia(media);
                break;
            case 4:
                CartMenu();
                break;
            case 0:
                return;
        }
    }

    public static void MediaDetailMenu(Media media) throws LimitExceededException, PlayerException {
        myStore.mediaDetailsMenu();
        int choose2 = scanner.nextInt();
        switch (choose2) {
            case 1:
                cart.addMedia(media);
                System.out.println("Add media to cart successfully");
                break;
            case 2:
                PlayMedia(media);
                break;
            case 0:
                return;
        }

    }

    public static void PlayMedia(Media media) throws PlayerException {
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            dvd.play();
        } else if (media instanceof CompactDisc) {
            ((CompactDisc) media).play();
        } else
            System.out.println("Media cann't play");
    }

    public static void UpdateStore() {
        System.out.println("You can choose 1 to add media to store and 2 to remove media from store");
        int choose3 = scanner.nextInt();
        if (choose3 == 1) {
            InputMedia();
        } else if (choose3 == 2) {
            System.out.println("Please input title to remove");
            String title = scanner.nextLine();
            myStore.removeMedia(myStore.searchTitle(title));
        }
    }

    public static void InputMedia() {
        System.out.println("Input title, category, cost you want to add");
        String title = scanner.nextLine();
        String category = scanner.nextLine();
        float cost = scanner.nextFloat();
        System.out.println("1. Add dvd \n2.Add cd \n3.Add book");
        int choose4 = scanner.nextInt();
        if (choose4 == 1) {
            System.out.println("Add 2 field length and director");
            int length = scanner.nextInt();
            String director = scanner.nextLine();
            myStore.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        } else if (choose4 == 2) {
            System.out.println("Add 2 field length and director and artist");
            int length = scanner.nextInt();
            String director = scanner.nextLine();
            String artist = scanner.nextLine();
            myStore.addMedia(new CompactDisc(title, category, cost, length, director, artist));
        } else {
            myStore.addMedia(new Book(title, category, cost));
        }
    }

    public static void CartMenu() throws PlayerException {
        myStore.cartMenu();
        int choose5 = scanner.nextInt();
        switch (choose5) {
            case 1:
                System.out.println("Press 1 to filter by id and press 2 to filter by title");
                int filter = scanner.nextInt();
                if (filter == 1) {
                    int id = scanner.nextInt();
                    System.out.println(cart.searchId(id));
                } else if (filter == 2) {
                    String title = scanner.nextLine();
                    System.out.println(cart.searchTitle(title));
                } else
                    System.out.println("Invalid number, cann't action");
                break;
            case 2:
                System.out.println("Press 1 to sort by title and press 2 to sort by cost");
                int sort = scanner.nextInt();
                if (sort == 1) {
                    cart.sortByTitle();
                } else if (sort == 2)
                    cart.sortByCost();
                else
                    System.out.println("Invalid number");
                break;
            case 3:
                String titleToRemove = scanner.nextLine();
                cart.removeMedia(cart.searchTitle(titleToRemove));
                break;
            case 4:
                String titleMedia = scanner.nextLine();
                PlayMedia(cart.searchTitle(titleMedia));
                break;
            case 5:
                cart.removeAllMedia();
                System.out.println("Place order successfully");
                break;
            case 0:
                return;
        }
    }
}
