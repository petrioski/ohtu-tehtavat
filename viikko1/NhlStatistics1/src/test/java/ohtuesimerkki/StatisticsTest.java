package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;



public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  


    @Test
    public void suurinScore() {
        assertThat(stats.topScorers(1).get(0).getName(), containsString("Gretzky"));
    }

    @Test
    public void etsiNimea() {
        assertThat(stats.search("Gretz").getName(), containsString("Gretzky"));
        assertThat(stats.search("Laine"), is(nullValue()));
    }

    @Test
    public void joukkueenPelaajat() {
        assertThat(stats.team("EDM").size(), is(3));
    }
}