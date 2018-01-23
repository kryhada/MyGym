package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.ArrayList;
import java.util.List;

public class CriteriaName implements Criteria {

    private String name;

    public CriteriaName(String name){
        this.name = name;
    }

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> nameClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getImie().equalsIgnoreCase(name)){
                nameClients.add(client);
            }
        }
        return nameClients;
    }
}
