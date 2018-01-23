package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.List;

public class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> firstCriteriaItems = criteria.meetCriteria(clients);
        List<DbKlient> otherCriteriaItems = otherCriteria.meetCriteria(clients);

        for(DbKlient client : otherCriteriaItems){
            if(!firstCriteriaItems.contains(client)){
                firstCriteriaItems.add(client);
            }
        }
        return firstCriteriaItems;
    }
}
