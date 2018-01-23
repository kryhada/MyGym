package sample;



public class DbKlient {

    private int id;
    private String imie;
    private String nazwisko;
    private String nr_telefonu;
    private int wiek;
    private String gender;


    public int getId(){
        return id;
    }

    public String getStringId(){
        return ""+id;
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
    public int getWiek(){
        return wiek;
    }
    public String getStringWiek(){
        return ""+wiek;
    }
    public void setWiek(int id){
        this.wiek = wiek;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public DbKlient(){}
    public DbKlient(int id, String imie, String nazwisko, String nr_telefonu, int wiek, String gender){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.wiek = wiek;
        this.gender = gender;
    }
    public DbKlient(int id, String imie, String nazwisko){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }


    public String toString(){
        return ""+id+" "+imie+" "+nazwisko+" "+nr_telefonu+" "+wiek+" "+gender;
    }

}
