package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
public class DigitalVideoDisc extends Disc{
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public String play() throws PlayerException {
        if (this.getLength() > 0)
            return this.getTitle() + " - " + this.getLength();
        else {
            throw new PlayerException("ERROR : DVD length is non-positive!");
        }
    }
}
