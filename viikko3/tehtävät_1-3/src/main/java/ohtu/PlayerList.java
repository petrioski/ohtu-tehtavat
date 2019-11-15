package ohtu;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PlayerList {
    private ArrayList<Player> pelaajat;
    private String nationality;

    public PlayerList(Player[] players) {
        this.pelaajat = new ArrayList<>();

        for (Player player : players) {
            this.pelaajat.add(player);
        }
    }

    public ArrayList<Player> getPlayersByCountry(String nationality) {
        return  pelaajat.stream()
                        .filter(p -> p.getNationality().equals(nationality))
                        .sorted()
                        .collect(Collectors.toCollection(ArrayList::new));
    }
}