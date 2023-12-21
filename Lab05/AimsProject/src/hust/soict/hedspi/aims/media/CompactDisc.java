package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hust.soict.hedspi.aims.exception.PlayerException;
public class CompactDisc extends Disc {
    String artist;
    List<Track> tracks = new ArrayList<Track>();
    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        // TODO Auto-generated method stub
        super(title, category, director, length, cost);
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    // Add Track
    public void addTrack(Track track) {
        for(Track t: tracks) {
            if(t.getTitle() == track.getTitle()) {
                System.out.println("The track already exists");
                return;
            }
        }
        System.out.println("The track has been added");
        tracks.add(track);
    }
    // Remove Track
    public void removeTrack(Track track) {
        boolean k = false;
        for(Track t: tracks) {
            if(t.getTitle() == track.getTitle()) {
                k = true;
                break;
            }
        }
        if(k) {
            System.out.println("The track has been removed");
            tracks.remove(track);
        }
        else {
            System.out.println("The track does not exist");
        }
    }

    public int getLength() {
        int total_length = 0;
        for(Track t: tracks) {
            total_length += t.getLength();
        }
        return total_length;
    }
    public String play() throws PlayerException {
        // TODO Auto-generated method stub
        if (this.getLength() > 0) {
            String s = "";
            for (Track track : tracks) {
                s += track.play();
            }
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
            return s;
        } else {
            throw new PlayerException("ERROR : CD length is non-positive");
        }

    }

    public String printAllTracks() {
        String s = "";
        for (Track track : tracks) {
            s += track.getTitle() + " " + track.getLength() + "\n";
        }
        return s;
    }
    public String toString() {
        return super.tostring() + " - " + this.artist;
    }
}
