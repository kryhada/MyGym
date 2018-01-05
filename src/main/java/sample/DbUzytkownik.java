package sample;


public class DbUzytkownik {
    private int id;
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getHaslo(){
        return haslo;
    }
    public void setHaslo(String haslo){
        this.haslo = haslo;
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

    public DbUzytkownik(){}
    public DbUzytkownik(int id, String login, String haslo, String imie, String nazwisko){
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String toString(){
        return ""+id+" - "+login+" "+haslo+" "+imie+" "+nazwisko;
    }
}
