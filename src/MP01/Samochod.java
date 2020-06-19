package MP01;

public class Samochod extends MainExt {

    String numer_rejestracyjny, typ, VIN;
    int pojemnosc;
    Kierowca kierowca;

    public Samochod(String numer_rejestracyjny, int pojemnosc, String typ, String VIN){
        this.numer_rejestracyjny = numer_rejestracyjny;
        this.pojemnosc = pojemnosc;
        this.typ = typ;
        this.VIN = VIN;
    }

    public void addKierowca(Kierowca kierowca){
        if(!kierowca.equals(this.kierowca)){
            this.kierowca = kierowca;
            // I odwrotnie
            kierowca.addSamochod(this);
        }
    }
    public String toString(){
        return "Dane pojazdu:\nNumer rej. "+numer_rejestracyjny+"\nPojemnosc: "+pojemnosc+"\nTyp: "+typ+"\nVIN: "+VIN+"\n";
    }
}
