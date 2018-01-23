package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.ArrayList;
import java.util.List;


public class CriteriaSurname implements Criteria {

    private String surname;

    public CriteriaSurname(String surname){
        this.surname = surname;
    }

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> surnameClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getNazwisko().equalsIgnoreCase(surname)){
                surnameClients.add(client);
            }
        }
        return surnameClients;
    }
}
