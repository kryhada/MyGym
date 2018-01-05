package sample;

import java.util.Date;

public class DbKlientUsluga {
    private int id;
    private int klient;
    private int usluga;
    private Date data_start;
    private Date data_stop;
    private int sprzedawca_opiekun;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getKlient(){
        return klient;
    }
    public void setKlient(int klient){
        this.klient = klient;
    }
    public int getUsluga(){
        return usluga;
    }
    public void setUsluga(int usluga){
        this.usluga = usluga;
    }
    public Date getData_start(){
        return data_start;
    }
    public void setData_start(Date data_start){
        this.data_start = data_start;
    }
    public Date getData_stop(){
        return data_stop;
    }
    public void setData_stop(Date data_stop){
        this.data_stop = data_stop;
    }
    public int getSprzedawca_opiekun(){
        return sprzedawca_opiekun;
    }
    public void setSprzedawca_opiekun(int sprzedawca_opiekun){
        this.sprzedawca_opiekun = sprzedawca_opiekun;
    }

    public DbKlientUsluga(){}
    public DbKlientUsluga(int id, int klient, int usluga, Date data_start, Date data_stop, int sprzedawca_opiekun){
        this.id = id;
        this.klient = klient;
        this.usluga = usluga;
        this.data_start = data_start;
        this.data_stop = data_stop;
        this.sprzedawca_opiekun = sprzedawca_opiekun;
    }

    public String toString(){
        return ""+id+" "+klient+" "+usluga+" "+data_start+" "+data_stop+" "+sprzedawca_opiekun+" ";
    }



}
