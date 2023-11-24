package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
    // Max Number of order
    public static final int MAX_NUMBERS_ORDERED = 20;

    // array store orders
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // qtyOrdered: how many DigitalVideoDiscs are in the cart
    private int qtyOrdered = 0;

    // add an item to the list
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        // check the current quantity to assure that the cart is not already full
        if(qtyOrdered < 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    // add a list of DVDs to the current cart
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc); // Call the individual item addition method
        }
    }
    // add two items to the list
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); // Call the individual item addition method for dvd1
        addDigitalVideoDisc(dvd2); // Call the individual item addition method for dvd2
    }



    // remove the item passed by argument from the list
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {

        for(int index = 0; index < qtyOrdered; index++) {
            if(itemsOrdered[index].getTitle() == disc.getTitle()) {

                for(int j = index; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("The disc has been removed");
                break;
            }
        }
    }

    // method which loops through the values of the array and sums the costs of the individual DigitalVideoDiscs
    public float totalCost() {
        float total = 0;
        for(int index = 0; index < qtyOrdered; index++) {
            total += itemsOrdered[index].getCost();
        }
        return total;
    }
    public void listCart(){
        for(int i = 0 ; i < qtyOrdered ; i++) System.out.println("id: "+ itemsOrdered[i].getId() +
                " " + itemsOrdered[i].getTitle());
    }
    // Search by ID
    public boolean search(int id) {
        int n = qtyOrdered;
        for(int i = 0; i < n; i++) {
            if(itemsOrdered[i].getId() == id) {
                return true;
            }
        }
        return false;
    }
    // Search by Title
    public boolean search(String title) {
        int n = qtyOrdered;
        for(int i = 0; i < n; i++) {
            if(itemsOrdered[i].getTitle() == title) {
                return true;
            }
        }
        return false;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.printf("%d. DVD - %s - %s - %s - %d minutes: %.2f $\n", i + 1, dvd.getTitle(),
                    dvd.getCategory(), dvd.getDirector(), dvd.getLength(), dvd.getCost());
        }

        float totalCost = totalCost();
        System.out.printf("Total cost: %.2f $\n", totalCost);
        System.out.println("***************************************************");
    }
}
