
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5; 
    public final static int OLETUSKASVATUS = 5; 
    
    private int kasvatuskoko; 
    private int[] lukujono; // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm; 

    public IntJoukko() {
        joukonAlustus(KAPASITEETTI, OLETUSKASVATUS);        
    }

    public IntJoukko(int kapasiteetti) {
        joukonAlustus(kapasiteetti, OLETUSKASVATUS);        
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        joukonAlustus(kapasiteetti, kasvatuskoko);
    }

    private void joukonAlustus(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin tulee olla nollaa suurempi");
        }

        lukujono = new int[kapasiteetti];
        for (int i = 0; i < lukujono.length; i++) {
            lukujono[i] = 0;
        }

        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }


    public boolean lisaa(int luku) {        
        if (alkioidenLkm == 0) {
            lukujono[0] = luku;
            alkioidenLkm++;
            return true;
        }
        
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % lukujono.length == 0) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {                
                return true;
            }
        }
        
        return false;
    }

    public boolean poista(int luku) {        
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                siirraAlkioitaYksiTaaksepain(i, alkioidenLkm);
                alkioidenLkm--;
                return true;
            }
        }        

        return false;
    }

    private void siirraAlkioitaYksiTaaksepain(int indeksi, int alkioidenLkm) {
        for (int j = indeksi; j < alkioidenLkm - 1; j++) {                
            lukujono[j] = lukujono[j + 1];                
        }
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    private void kasvataTaulukkoa() {    
        int[] taulukkoOld = lukujono.clone();                
        lukujono = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, lukujono);
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukujono[i];
                tuotos += ", ";
            }
            tuotos += lukujono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {        
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(lukujono, 0, taulu, 0, alkioidenLkm);
        
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(bTaulu[i]);
        }

        return z;
    }

}
