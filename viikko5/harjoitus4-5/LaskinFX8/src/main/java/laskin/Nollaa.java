package laskin;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Nollaa extends Komento {
    private int vanha, operandi;

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        int laskunTulos = 0;

        this.vanha = muunna(tuloskentta);    
        this.operandi = muunna(syotekentta);

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }  

    @Override
    public void peru() {
        syotekentta.setText("" + operandi);    
        tuloskentta.setText("" + vanha);
        undo.disableProperty().set(true);
    }

    private Integer muunna(TextField kentta) {
        int luku = 0;
        try {
            luku = Integer.parseInt(kentta.getText());
        } catch (Exception e) {

        }
        return luku;
    }

}