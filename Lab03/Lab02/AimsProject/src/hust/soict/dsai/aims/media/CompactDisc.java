package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category) {
		super(title, category);
	}
	
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }
    
    public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("The track " + track.getTitle() + " has already existed");
			return;
        }
		tracks.add(track);
		System.out.println("The track " + track.getTitle() + " has been added");
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track " + track.getTitle() + " has already existed");
			return;
        }
		tracks.remove(track);
		System.out.println("The track " + track.getTitle() + " has removed");
	}
	
	@Override
	public int getLength() {
        int length = 0;
        for (Track track: tracks) {
            length += track.getLength();
        }
        return length;
    }
	
	@Override
    public void play() {
        System.out.println("Artist: " + this.artist);
        System.out.println("List of track");
        for (Track track: tracks) {
            track.play();
        }
    }
	
	public String toString() {
        return ". CD - " + this.getTitle() + " - " + this.getArtist() + " - " + this.getDirector() + " - " + this.getCategory() + " - "  + this.getLength() + " - " + this.getCost() + "$";
    }
}