package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.ArrayList;
import java.util.List;

public class CriteriaID implements Criteria {

    private String id;

    public CriteriaID(String id){
        this.id = id;
    }



    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> idClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getStringId().equalsIgnoreCase(id)){
                idClients.add(client);
            }
        }
        return idClients;
    }
}
