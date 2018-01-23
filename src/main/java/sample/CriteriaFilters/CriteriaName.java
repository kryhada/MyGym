package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.ArrayList;
import java.util.List;

public class CriteriaName implements Criteria {

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> nameClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getImie().equalsIgnoreCase("")){
                nameClients.add(client);
            }
        }
        return nameClients;
    }
}
