package hust.soict.hedspi.aims;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
    //	Add Book to Cart(Method in AddToStore)
    public static void addBookToStore(Scanner sc, Store anStore) {
        Media book = new Book();
        System.out.println("Book title: " );
        String title = sc.nextLine();
//		Check Book to Store.
        if(anStore.search(title)) {
            System.err.println("The Media already exists");
        }
        else {
            book.setTitle(title);
            System.out.println("Book category: " );
            book.setCategory(sc.nextLine());
            System.out.println("Book cost: " );
            book.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("Book id: ");
            book.setId(sc.nextInt());
            System.out.println("Book added");
            anStore.addMedia(book);
        }
    }
    //	Add CD to Cart(Method in AddToStore)
    public static void addCDToStore(Scanner sc, Store anStore) {
        Media cd = new CompactDisc();
        System.out.println("CD title: " );
        String title = sc.nextLine();
//		Check CD to Store
        if(anStore.search(title)) {
            System.err.println("The Media already exists");
        }
        else {
            cd.setTitle(title);
            System.out.println("CD artist: ");
            cd.setArtist(sc.nextLine());
            System.out.println("CD category: " );
            cd.setCategory(sc.nextLine());
            System.out.println("CD cost: " );
            cd.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("CD id: ");
            cd.setId(sc.nextInt());
            anStore.addMedia(cd);
            System.out.println("CD added");
        }
    }
    //	Add DVD to Cart(Method in AddToStore)
    public static void addDVDToStore(Scanner sc, Store anStore) {
        Media dvd = new DigitalVideoDisc();
        System.out.println("DVD title: " );
        String title = sc.nextLine();
//		Check DVD to Store
        if(anStore.search(title)) {
            System.err.println("The Media already exists");
        }
        else {
            dvd.setTitle(title);
            System.out.println("DVD category: " );
            dvd.setCategory(sc.nextLine());
            System.out.println("DVD cost: " );
            dvd.setCost(sc.nextFloat());
            sc.nextLine();
            System.out.println("DVD id: ");
            dvd.setId(sc.nextInt());
            System.out.println("DVD length: ");
            dvd.setLength(sc.nextInt());
            System.out.println("DVD added");
            anStore.addMedia(dvd);
            System.out.println("DVD added");
        }
    }

    public static void addToStore(Scanner sc, Store anStore) {
        System.out.println("Add Media To Store");
        System.out.println("What is the item type ?\n1. Book\n2. CD\n3. DVD");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                addBookToStore(sc, anStore);
                break;
            case 2:
                addCDToStore(sc, anStore);
                break;
            case 3:
                addDVDToStore(sc, anStore);
                break;
            default:
                System.out.println("Not Corrected");
        }
    }
    //	Remove Media To Store
    public static void removeToStore(Scanner sc, Store anStore) {
        System.out.println("Remove Media To Store");
        System.out.print("Media title remove is: ");
        String title = sc.nextLine();
        if(!anStore.search(title)) {
            System.out.println("The media doesn't exist");
        }
        else {
//			Remove Media title is "title"
//			Call Method search by title and return media. "But not created yet"
//			anStore.removeMedia();
        }
    }

    public static void UpdateStore(Scanner sc, Store anStore) {
        System.out.println("Update Store");
        System.out.println("Add or Remove\n 1.Add\n 2.Remove");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                addToStore(sc, anStore);
                break;
            case 2:
                removeToStore(sc, anStore);
                break;
            default:
                System.out.println("Not Corrected");
        }
    }
    //	Add Book to Cart(Method in AddToCart)
    public static void addBookToCart(Scanner sc, Cart anOrder, Store anStore) {
        Media book = new Book();
        System.out.println("Book title: " );
        String title = sc.nextLine();
//		Check Book to Store and Add to Cart. But Store is null
//		if(anStore.search(title)) {
//			True: Method implementation
//			False: Exit Method
//		}
        book.setTitle(title);
        System.out.println("Book category: " );
        book.setCategory(sc.nextLine());
        System.out.println("Book cost: " );
        book.setCost(sc.nextFloat());
        sc.nextLine();
        System.out.println("Book id: ");
        book.setId(sc.nextInt());
        System.out.println("Book added");
        anOrder.addMedia(book);
    }
    //	Add CD to Cart(Method in AddToCart)
    public static void addCDToCart(Scanner sc, Cart anOrder, Store anStore) {
        Media cd = new CompactDisc();
        System.out.println("CD title: " );
        String n = sc.nextLine();
//		Check CD to Store and Add to Cart. But Store is null
//		if(anStore.search(title)) {
//			True: Method implementation
//			False: Exit Method
//		}
        cd.setTitle(n);
        System.out.println("CD artist: ");
        cd.setArtist(sc.nextLine());
        System.out.println("CD category: " );
        cd.setCategory(sc.nextLine());
        System.out.println("CD cost: " );
        cd.setCost(sc.nextFloat());
        sc.nextLine();
        System.out.println("CD id: ");
        cd.setId(sc.nextInt());
        anOrder.addMedia(cd);
        System.out.println("CD added");
    }
    //	Add DVD to Cart(Method in AddToCart)
    public static void addDVDToCart(Scanner sc, Cart anOrder, Store anStore) {
        Media dvd = new DigitalVideoDisc();
        System.out.println("DVD title: " );
        String m=sc.nextLine();
//		Check DVD to Store and Add to Cart. But Store is null
//		if(anStore.search(title)) {
//			True: Method implementation
//			False: Exit Method
//		}
        dvd.setTitle(m);
        System.out.println("DVD category: " );
        dvd.setCategory(sc.nextLine());
        System.out.println("DVD cost: " );
        dvd.setCost(sc.nextFloat());
        sc.nextLine();
        System.out.println("DVD id: ");
        dvd.setId(sc.nextInt());
        System.out.println("DVD length: ");
        dvd.setLength(sc.nextInt());
        System.out.println("DVD added");
        anOrder.addMedia(dvd);
        System.out.println("DVD added");
    }

    public static void addToCart(Scanner sc, Cart anOrder, Store anStore) {
        System.out.println("Add item to the order");
        System.out.println("What is the item type ?\n1. Book\n2. CD\n3. DVD");
        int input = sc.nextInt();
        switch (input) {
            case 1:
                addBookToCart(sc, anOrder, anStore);
                break;
            case 2:
                addCDToCart(sc, anOrder, anStore);
                break;
            case 3:
                addDVDToCart(sc, anOrder, anStore);
                break;
            default:
                System.out.println("Not Corrected");
        }
    }

    public static void seeAMediaDetails(Scanner sc, Cart anOrder, Store anStore) {
        System.out.println("See A Media Details");
        System.out.print("Media Title is: ");
        String title = sc.nextLine();
        System.out.println("");
//		Check Media in Store and Print. But Store is null.
//		if(anStore.search(title)) {
//			True: Print Media in Store
//			False: Exit	Method
//		}
    }

    public static void playMedia(Scanner sc, Cart anOrder, Store anStore) {
        System.out.println("Play");
        System.out.print("Media Title is: ");
        String title = sc.nextLine();
        System.out.println("");
//		Check Media in Store and Play. But Store is null.
//		if(anStore.search(title)) {
//			True: Play Media in Store
//			False: Exit	Method
//		}
    }

    public static void filterMediaInCart(Scanner sc, Cart anOrder) {
        System.out.println("Filter Medias in Cart");
        System.out.println("Filter type: \n1. Title\n2. Id");
        int k = sc.nextInt();
        switch (k){
            case 1:
                break;
            case 2:
                break;
            default:
                k = 0;
                break;
        }
    }

    public static void sortMediaInCart(Scanner sc, Cart anOrder) {
        System.out.println("Sort Medias in Cart");
        System.out.println("Sort type: \n1. Title\n2. Cost");
        int k = sc.nextInt();
        switch (k){
            case 1:
                break;
            case 2:
                break;
            default:
                k = 0;
                break;
        }
    }

    public static void removeMediaFromCart(Scanner sc, Cart anOrder) {
        System.out.println("Remove Media To Cart");
        System.out.print("Media title remove is: ");
        String title = sc.nextLine();
        if(!anOrder.search(title)) {
            System.out.println("The media doesn't exist");
        }
        else {
//			Remove Media title is "title"
//			Call Method search by title and return media. "But not created yet"
//			anCart.removeMedia();
        }
    }

    public static void placeOrder(Scanner sc, Cart anOrder) {
        System.out.print("Order Success");
//		Call Method removeMdiaAll. But not created yet
//		anOrder.removeMediaAll();
    }

    public static void menu_3(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                k = 0;
                break;
            case 1:
                filterMediaInCart(sc, anOrder);
                break;
            case 2:
                sortMediaInCart(sc, anOrder);
                break;
            case 3:
                removeMediaFromCart(sc, anOrder);
                break;
            case 4:
                playMedia(sc, anOrder, anStore);
                break;
            case 5:
                placeOrder(sc, anOrder);
                break;
            default:
                k = 0;
                break;
        }
    }

    public static void menu_2(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                k = 0;
                break;
            case 1:
                addToCart(sc, anOrder, anStore);
                anOrder.printLength();
                break;
            case 2:
                playMedia(sc, anOrder, anStore);
                break;
            default:
                k = 0;
                break;
        }
    }

    public static void menu_1(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                k = 0;
                break;
            case 1:
                seeAMediaDetails(sc, anOrder, anStore);
                mediaDetailsMenu();
                break;
            case 2:
                addToCart(sc, anOrder, anStore);
                anOrder.printLength();
                break;
            case 3:
                playMedia(sc, anOrder, anStore);
                break;
            case 4:
                anOrder.printCart();
                cartMenu();
                menu_3(sc, anOrder, anStore);
                break;
            default:
                k = 0;
                break;
        }
    }

    public static void menu(Scanner sc, Cart anOrder, Store anStore) {
        int k = sc.nextInt();
        switch (k){
            case 0:
                k = 0;
                System.out.println("Exit");
                break;
            case 1:
                anStore.printStore();
                storeMenu();
                menu_1(sc, anOrder, anStore);
                break;
            case 2:
                UpdateStore(sc, anStore);
                break;
            case 3:
                anOrder.printCart();
                cartMenu();
                menu_3(sc, anOrder, anStore);
                break;
            default:
                k = 0;
                break;
        }
    }

    public static void main(String[] args) {
        showMenu();
        Scanner sc = new Scanner(System.in);
        Cart anOrder = new Cart();
        Store anStore = new Store();
        menu(sc, anOrder, anStore);
        sc.close();
    }
}
