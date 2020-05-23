public class main {

    public static void main(String[] args){

        Stacja orlen = new Stacja("Orlen","Warszawa, 02-405 Złota");
        Pracownik jan = new Pracownik(1,"Jan","Kowalski");
        Pracownik andrzej = new Pracownik(2,"Adnrzej","Nowak");

        //Asocjacja zwykla
        andrzej.addStacja(orlen);
        jan.addStacja(orlen);

        System.out.println(orlen);
        System.out.println(jan);

    }

}
