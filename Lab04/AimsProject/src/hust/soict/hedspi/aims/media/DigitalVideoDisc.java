package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc{
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public String play() {
        // TODO Auto-generated method stub
        return this.getTitle() + " - " + this.getLength();
    }
}
