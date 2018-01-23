package sample.CriteriaFilters;
import sample.DbKlient;
import java.util.ArrayList;
import java.util.List;

public class CriteriaFemale implements Criteria {

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> femaleClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getStringId().equalsIgnoreCase("Female")){
                femaleClients.add(client);
            }
        }
        return femaleClients;
    }
}
