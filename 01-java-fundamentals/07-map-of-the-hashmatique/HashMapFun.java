import java.util.HashMap;
import java.util.Set;
public class HashMapFun {
    public static void main(String[] args) {

        HashMap<String, String> TrackList = new HashMap<String, String>();
        TrackList.put("Knights of Cydonia", "Come ride with me, Through the veins of history");
        TrackList.put("Uprising", "Paranoia is in bloom, the PR transmissions will resume");
        TrackList.put("Hysteria", "It's bugging me, Grating me");
        TrackList.put("Starlight", "Far away, This ship is taking me far away");

        String lyrics = TrackList.get("Knights of Cydonia");
        System.out.println(lyrics);

        // get the keys by using the keySet method
        Set<String> keys = TrackList.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(TrackList.get(key));   
            // System.out.println(String.format("Track: %s: Lyrics: %s", key, TrackList.get(key))); 
        }
    }
}