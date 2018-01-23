package sample.CriteriaFilters;
import sample.DbKlient;
import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> maleClients = new ArrayList<>();

        for(DbKlient client : clients){
            if(client.getStringId().equalsIgnoreCase("Male")){
                maleClients.add(client);
            }
        }
        return maleClients;
    }
}
