package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.ArrayList;
import java.util.List;

public class CriteriaGender implements Criteria {

    private String gender;

    public CriteriaGender(String gender){
        this.gender = gender;
    }

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> genderClients = new ArrayList<>();
        if(gender == "<default>"){

        }else {
            for (DbKlient client : clients) {
                if (client.getGender().equalsIgnoreCase(gender)) {
                    genderClients.add(client);
                }
            }
        }
        return genderClients;
    }
}
