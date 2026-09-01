
import java.util.ArrayList;
import java.util.List;

/**
 * A simple song playlist manager system that demonstrates the use of
 * the List data structure in Java.
 *
 * Songs are stored in an ArrayList and can be added, inserted,
 * removed, retrieved, and displayed using common list operations.
 * The playlist maintains the order of songs and allows access
 * by index position.
 *
 * This project demonstrates core list behaviors including:
 * adding elements to the end of a list, inserting elements at
 * specific positions, removing elements, traversing a list with
 * loops, and retrieving elements by index.
 *
 * @author DAVID WOODS
 * @version 1.0
 */
public class Unit3Project {

    private List<String> playlist = new ArrayList<>();

    public void addSong(String title) {
        //Add a song to the playlist
        playlist.add(title);

    }

    public void insertSong(int index, String title) {
        if (index <= playlist.size()-1) { // Check for proper index
            playlist.add(index, title); // Adds the song at index and shifts others right
            }
        else {
            System.out.print("Index out of range for playlist of size: " + playlist.size());
        }
    }

    public String removeSong(int index) {
        // Remove and return the song at the index
        if (index <= playlist.size()-1) {
            String removedSong = playlist.get(index);
            playlist.remove(removedSong);
            return removedSong;
        }
        else{
            return "Index out of range for playlist of size: " + playlist.size();
        }
    }

    public String getSpecificSong(int index) {
        // Return the song at the specified index
        return playlist.get(index);
    }

    public int size() {
        // return the size of the playlist
        return playlist.size();
    }

    public void displaySongs() {
        // Display "Current playlist:"
        // Traverse the playlist using a loop
        // Print each index and song title
        System.out.println("Current playlist: ");
        for (int i = 0 ; i < playlist.size(); i++){ // print each index and the song on new lines
            System.out.println(i + ": " + playlist.get(i));
        }
    }


    public static void main(String[] args) {
        Unit3Project app = new Unit3Project();

        app.addSong("Song A");
        app.addSong("Song B");
        app.insertSong(1, "Song X");

        System.out.println("Playlist size: " + app.size());
        System.out.println("Song at index 1: " + app.getSpecificSong(1));
        System.out.println("Removed song: " + app.removeSong(0));
        app.displaySongs();
    }


}

