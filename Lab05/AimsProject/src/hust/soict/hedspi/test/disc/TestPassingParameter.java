package hust.soict.hedspi.test.disc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
public class TestingPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle","Animation", "Hawk", 100, 20.5f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "Roman", "Halo",200, 10.5f);
        swap2(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
    }
    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
    }

    // viết hàm hoán đổi 2 đối tượng

    public static void SetValue(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        dvd1.setTitle(dvd2.getTitle());
        dvd1.setCategory(dvd2.getCategory());
        dvd1.setDirector(dvd2.getDirector());
        dvd1.setCost(dvd2.getCost());
        dvd1.setLength(dvd2.getLength());
    }
    public static void swap2(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        DigitalVideoDisc tmp = new DigitalVideoDisc();
        SetValue(tmp, dvd1);
        SetValue(dvd1, dvd2);
        SetValue(dvd2, tmp);
    }
}
