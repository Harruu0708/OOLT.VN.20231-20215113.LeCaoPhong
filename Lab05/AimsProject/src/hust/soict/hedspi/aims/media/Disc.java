package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
public class Disc extends Media {
    private int length;
    private String director;

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        // TODO Auto-generated method stub
        this.director = director;
    }
    public String play() throws PlayerException {
        return "";
    }
    public String tostring() {
        return super.toString() + " - " + this.length + " - " + this.director;
    }


}
