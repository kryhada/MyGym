package sample.CriteriaFilters;
import sample.DbKlient;

import java.util.List;

public class AndCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<DbKlient> meetCriteria(List<DbKlient> clients){
        List<DbKlient> firstCriteriaClients = criteria.meetCriteria(clients);
        return otherCriteria.meetCriteria(firstCriteriaClients);
    }
}
