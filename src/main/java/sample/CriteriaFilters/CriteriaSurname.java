package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.ArrayList;
import java.util.List;


public class CriteriaSurname implements Criteria {

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> surnameClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getStringId().equalsIgnoreCase("")){
                surnameClients.add(client);
            }
        }
        return surnameClients;
    }
}
