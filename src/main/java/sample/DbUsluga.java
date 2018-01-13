package sample;

public class DbUsluga {
    private int id;
    private String nazwa;
    private int typ;
    private int cena;
    private int czas_trwania;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNazwa(){
        return nazwa;
    }
    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }
    public int getTyp(){
        return typ;
    }
    public void setTyp(int typ){
        this.typ = typ;
    }
    public int getCena(){
        return cena;
    }
    public void setCena(){
        this.typ = typ;
    }
    public int getCzas_trwania(){
        return czas_trwania;
    }
    public void setCzas_trwania(){
        this.czas_trwania = czas_trwania;
    }


    public DbUsluga(){}
    public DbUsluga(int id, String nazwa, int typ, int cena, int czas_trwania){
        this.id = id;
        this.nazwa = nazwa;
        this.typ = typ;
        this.cena = cena;
        this.czas_trwania = czas_trwania;

    }

    public String toString() {
        return "" + id + " - " + nazwa + " " + typ + " " + cena + " " + czas_trwania;
    }
}
