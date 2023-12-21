package hust.soict.hedspi.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    public Book(String title, String category, float cost) {
        // TODO Auto-generated constructor stub
        super(title, category, cost);
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public void addAuthors(String authors) {
        for(String s: this.authors) {
            if(s == authors) {
                System.out.println("The authors already exists");
                return;
            }
        }
        this.authors.add(authors);
        System.out.println("The authors has been added");
    }
    public void removeAuthors(String authors) {
        boolean k = false;
        for(String s: this.authors) {
            if(s == authors) {
                k = true;
                break;
            }
        }
        if(k) {
            this.authors.remove(authors);
            System.out.println("The authors has been removed");
        }
        else {
            System.out.println("The author does not exist");
        }
    }

}