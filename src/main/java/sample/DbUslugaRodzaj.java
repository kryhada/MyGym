package sample;

public class DbUslugaRodzaj {
    private int id;
    private String nazwa;


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

    public DbUslugaRodzaj(){}
    public DbUslugaRodzaj(int id, String nazwa){
        this.id = id;
        this.nazwa = nazwa;

    }

    public String toString(){
        return ""+id+" - "+nazwa+"";
    }
}
