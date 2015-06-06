package com.djavafactory.dao.hibernate;

import com.djavafactory.model.ItemCategory;
import com.djavafactory.dao.ItemCategoryDao;
import com.djavafactory.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("itemCategoryDao")
public class ItemCategoryDaoHibernate extends GenericDaoHibernate<ItemCategory, Long> implements ItemCategoryDao {

    public ItemCategoryDaoHibernate() {
        super(ItemCategory.class);
    }
}
