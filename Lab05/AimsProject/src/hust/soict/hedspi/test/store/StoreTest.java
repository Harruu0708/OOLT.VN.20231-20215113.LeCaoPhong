package hust.soict.hedspi.test.store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
public class StoreTest {
    public static void main(String[] args) {
        Store HUST = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Will Smith",87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction","Geogre Hamth", 102, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Taylor", 100, 18.99f);
        HUST.addMedia(dvd1);
        HUST.addMedia(dvd2);
        System.out.println(HUST.getItemsInStore().toString());
        HUST.removeMedia(dvd3);
        HUST.removeMedia(dvd2);
    }
}
