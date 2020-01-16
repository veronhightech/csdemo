package com.csoftware.apiassessment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import javax.transaction.Transactional;
import com.csoftware.apiassessment.model.Brands;
import com.csoftware.apiassessment.dao.BrandsDAO;
import com.csoftware.apiassessment.service.BrandsService;



@Service
@Transactional
public class BrandsServiceImpl implements BrandsService {

    @Autowired
    private BrandsDAO brandsserviceimplDAO;

    @Override
    @Transactional
    public void addBrands(Brands brandsserviceimpl) {
        brandsserviceimplDAO.addBrands(brandsserviceimpl);
 
    }

    @Override
    @Transactional
    public List<Brands> getAllBrands() {
        return brandsserviceimplDAO.getAllBrands();
    }

    @Override
    @Transactional
    public void deleteBrands(int brandsserviceimplId) {
        brandsserviceimplDAO.deleteBrands(brandsserviceimplId);
    }

    @Override
    @Transactional
    public Brands getBrands(int brandsserviceimplId) {
        return brandsserviceimplDAO.getBrands(brandsserviceimplId);
    }
    
    @Override
    @Transactional
    public Brands findOrCreateBrands(String brandName) {
        return brandsserviceimplDAO.findOrCreateBrands(brandName);    	
    }

    @Override
    @Transactional
    public Brands updateBrands(Brands brandsserviceimpl) {
        // TODO Auto-generated method stub
        return brandsserviceimplDAO.updateBrands(brandsserviceimpl);
    }

    public void setBrandsDAO(BrandsDAO brandsserviceimplDAO) {
        this.brandsserviceimplDAO = brandsserviceimplDAO;
    }

	public String getLastGeneratedId(){
		return brandsserviceimplDAO.getLastGeneratedId();
	}



}
