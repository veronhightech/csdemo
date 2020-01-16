package com.csoftware.apiassessment.dao.impl;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.csoftware.apiassessment.model.Taggedproducts;
import com.csoftware.apiassessment.dao.TaggedproductsDAO;



@Repository
public class TaggedproductsDAOImpl implements TaggedproductsDAO {

    @Autowired
    private SessionFactory sessionFactory;

public void addTaggedproducts(Taggedproducts taggedproductsdaoimpl) {
        sessionFactory.getCurrentSession().saveOrUpdate(taggedproductsdaoimpl);
 
    }

@SuppressWarnings("unchecked")
    public List<Taggedproducts> getAllTaggedproducts() {
 
        return sessionFactory.getCurrentSession().createQuery("from Taggedproducts")
                .list();
    }

    @Override
    public void deleteTaggedproducts(long taggedproductsdaoimplId) {
        Taggedproducts taggedproductsdaoimpl = (Taggedproducts) sessionFactory.getCurrentSession().load(
                Taggedproducts.class, taggedproductsdaoimplId);
        if (null != taggedproductsdaoimpl) {
            this.sessionFactory.getCurrentSession().delete(taggedproductsdaoimpl);
        }
 
    }



    public Taggedproducts getTaggedproducts(long taggedproductsdaoimplId) {
        return (Taggedproducts) sessionFactory.getCurrentSession().get(
                Taggedproducts.class, taggedproductsdaoimplId);
    }

    @Override
    public Taggedproducts updateTaggedproducts(Taggedproducts taggedproductsdaoimpl) {
        sessionFactory.getCurrentSession().update(taggedproductsdaoimpl);
        return taggedproductsdaoimpl;
    }



	public String getLastGeneratedId(){
		//String lastId = ((String) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).toString();
		String lastId =""+ ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return lastId;
	}


}
