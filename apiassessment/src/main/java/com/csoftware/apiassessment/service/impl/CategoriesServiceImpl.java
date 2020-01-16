package com.csoftware.apiassessment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import javax.transaction.Transactional;
import com.csoftware.apiassessment.model.Categories;
import com.csoftware.apiassessment.dao.CategoriesDAO;
import com.csoftware.apiassessment.service.CategoriesService;



@Service
@Transactional
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesDAO categoriesserviceimplDAO;

    @Override
    @Transactional
public void addCategories(Categories categoriesserviceimpl) {
        categoriesserviceimplDAO.addCategories(categoriesserviceimpl);
 
    }

    @Override
    @Transactional
    public List<Categories> getAllCategories() {
        return categoriesserviceimplDAO.getAllCategories();
    }

    @Override
    @Transactional
    public void deleteCategories(int categoriesserviceimplId) {
        categoriesserviceimplDAO.deleteCategories(categoriesserviceimplId);
    }

    @Override
    @Transactional
    public Categories getCategories(int categoriesserviceimplId) {
        return categoriesserviceimplDAO.getCategories(categoriesserviceimplId);
    }
    
    @Override
    @Transactional
    public Categories findOrCreateRecord(String name) {
        return categoriesserviceimplDAO.findOrCreateRecord(name);
    }
     

    @Override
    @Transactional
    public Categories updateCategories(Categories categoriesserviceimpl) {
        // TODO Auto-generated method stub
        return categoriesserviceimplDAO.updateCategories(categoriesserviceimpl);
    }

    public void setCategoriesDAO(CategoriesDAO categoriesserviceimplDAO) {
        this.categoriesserviceimplDAO = categoriesserviceimplDAO;
    }

	public String getLastGeneratedId(){
		return categoriesserviceimplDAO.getLastGeneratedId();
	}



}
