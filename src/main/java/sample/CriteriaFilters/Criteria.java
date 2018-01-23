package sample.CriteriaFilters;

import sample.DbKlient;

import java.util.List;

public interface Criteria {
    public List<DbKlient> meetCriteria(List<DbKlient> clients);
}
