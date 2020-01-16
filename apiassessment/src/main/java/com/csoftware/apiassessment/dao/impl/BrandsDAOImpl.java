package com.csoftware.apiassessment.dao.impl;

import java.math.BigInteger;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.csoftware.apiassessment.model.Brands;
import com.csoftware.apiassessment.dao.BrandsDAO;



@Repository
public class BrandsDAOImpl implements BrandsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addBrands(Brands brandsdaoimpl) {
        sessionFactory.getCurrentSession().saveOrUpdate(brandsdaoimpl);
 
    }
    
    

	@SuppressWarnings("unchecked")
    public List<Brands> getAllBrands() {
 
        return sessionFactory.getCurrentSession().createQuery("from Brands")
                .list();
    }

    @Override
    public void deleteBrands(int brandsdaoimplId) {
        Brands brandsdaoimpl = (Brands) sessionFactory.getCurrentSession().load(
                Brands.class, brandsdaoimplId);
        if (null != brandsdaoimpl) {
            this.sessionFactory.getCurrentSession().delete(brandsdaoimpl);
        }
 
    }


    @Override
    public Brands getBrands(int brandsdaoimplId) {
        return (Brands) sessionFactory.getCurrentSession().get(
                Brands.class, brandsdaoimplId);
    }
    
    @Override
    public Brands findOrCreateBrands(String name) {
    	//String SQL_QUERY ="SELECT e.id, e.name, e.description, b.name AS brand, c.name AS category, e.created_at FROM Products AS e, Brands AS b, Categories AS c WHERE e.brand=b.brandId AND e.category=c.categoryId";
    	 String SQL_QUERY ="SELECT b FROM Brands AS b  WHERE b.name LIKE :name ";
		 Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
		 query.setParameter("name", name);
		 Brands record = (Brands)query.uniqueResult();
		 if(record==null){
			 Brands b=new Brands(); b.setName(name); b.setActive(true);
			 addBrands(b);
			 String idx=getLastGeneratedId();
			 record =getBrands(Integer.parseInt(idx));
         }
    	
        return record;
    }
    

    @Override
    public Brands updateBrands(Brands brandsdaoimpl) {
        sessionFactory.getCurrentSession().update(brandsdaoimpl);
        return brandsdaoimpl;
    }



	public String getLastGeneratedId(){
		String lastId =""+ ((BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
		return lastId;
	}


}
