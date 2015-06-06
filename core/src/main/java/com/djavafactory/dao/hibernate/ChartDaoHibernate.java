package com.djavafactory.dao.hibernate;

import com.djavafactory.model.ItemCategory;
import com.djavafactory.dao.ItemCategoryDao;
import com.djavafactory.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("ChartDao")
public class ChartDaoHibernate extends GenericDaoHibernate<Chart, Long> implements ChartDao {

    public ChartDaoHibernate() {
        super(Chart.class);
    }
}
