package MP01;

import java.util.HashSet;
import java.util.Set;

public class KlientStacja extends MainExt {

    int iloscPaliwa;
    String paliwo;
    boolean czyFaktura;
    Set<Klient> klientSet = new HashSet<>();
    Set<Stacja> stacjaSet = new HashSet<>();

    //Asocjacja z atrybutem
    public KlientStacja(int iloscPaliwa, String paliwo, boolean czyFaktura){
        this.iloscPaliwa = iloscPaliwa;
        this.paliwo = paliwo;
        this.czyFaktura = czyFaktura;
    }

    public String toString(){
        if(czyFaktura){
            return "Klient "+klientSet+" zatankował "+iloscPaliwa+" litrów "+paliwo+" na stacji"+stacjaSet+" i brał fakturę\n";
        }else{
            return "Klient "+klientSet+" zatankował "+iloscPaliwa+" litrów "+paliwo+" na stacji"+stacjaSet+" i nie brał faktury\n";
        }
    }
}

