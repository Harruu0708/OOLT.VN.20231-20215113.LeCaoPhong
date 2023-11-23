package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
public class Aims {
    public static void main(String[] args) {
        // create a new cart
        Cart anOrder = new Cart();

        // create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);


//        anOrder.removeDigitalVideoDisc(dvd3);

        // simple data
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Movie 1",
                "Category 1", "Director 1", 120, 9.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Movie 2",
                "Category 2", "Director 2", 110, 8.99f);
        anOrder.addDigitalVideoDisc(dvd4, dvd5); // Adding two DVDs individually

        DigitalVideoDisc[] dvdList = new DigitalVideoDisc[]{
                new DigitalVideoDisc("Movie 3",
                        "Category 3", "Director 3", 130, 7.99f),
                new DigitalVideoDisc("Movie 4",
                        "Category 4", "Director 4", 115, 10.99f)

        };
        anOrder.addDigitalVideoDisc(dvdList);    // Adding list DVDs at once

        // print total cost of the items in the cart
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // print all cart
        anOrder.listCart();

        // new method to print all carts
        anOrder.printCart();
    }
}
