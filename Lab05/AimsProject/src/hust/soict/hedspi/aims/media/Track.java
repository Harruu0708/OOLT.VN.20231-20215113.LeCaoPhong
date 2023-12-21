package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.exception.PlayerException;
public class Track implements Playable{
    private String title;
    private int length;
    public Track(String title, int length) {
        super();
        this.title = title;
        this.length = length;
    }
    public Track() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public String play() throws PlayerException {
        // TODO Auto-generated method stub
        if (this.length > 0) {
            return this.title + " - " + this.length;
        } else {
            throw new PlayerException("ERROR : Track length is non-positive");
        }
    }

    @Override
    public boolean equals(Object o) {
        Track tmp = (Track)o;
        if(this.getTitle() == tmp.getTitle() && this.getLength() == tmp.getLength()) {
            return true;
        }
        else return false;
    }
}
