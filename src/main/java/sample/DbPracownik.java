package sample;

public class DbPracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private String nr_telefonu;
    private String email;
    private int stanowisko;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getImie(){
        return imie;
    }
    public void setImie(String imie){
        this.imie = imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }
    public String getNr_telefonu(){
        return nr_telefonu;
    }
    public void setNr_telefonu(){
        this.nr_telefonu = nr_telefonu;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getStanowisko(){
        return stanowisko;
    }
    public void setStanowisko(int stanowisko){
        this.stanowisko = stanowisko;
    }

    public DbPracownik(){}
    public DbPracownik(int id, String imie, String nazwisko, String nr_telefonu, int wiek){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.stanowisko = stanowisko;
    }

    public DbPracownik(int id, String imie, String nazwisko){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String toString(){
        return ""+id+" "+imie+" "+nazwisko+" "+nr_telefonu+" "+email+" "+stanowisko+" ";
    }
}
