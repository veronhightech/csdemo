package com.csoftware.apiassessment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith; 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.csoftware.apiassessment.controller.ProductsController;
import com.csoftware.apiassessment.dto.ProductsDTO;
import com.csoftware.apiassessment.service.BrandsService;
import com.csoftware.apiassessment.service.CategoriesService;
import com.csoftware.apiassessment.service.ProductsService;
import com.csoftware.apiassessment.service.TaggedproductsService;
import com.csoftware.apiassessment.service.TagsService;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@SpringBootTest
class ProductsControllerTest {

	@InjectMocks
	ProductsController productController;
	
	@Mock
	private ProductsService productsService;
    
	@Mock
    private TagsService tagsService;
     
	@Mock
    private BrandsService brandsService;
     
	@Mock
    private CategoriesService categoriesService;
    
	@Mock
    private TaggedproductsService taggedproductsService;
     
    //@Mock
    //EmployeeDAO employeeDAO;
    
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void  listProductsDefault() { 
   	 
		PodamFactory factory = new PodamFactoryImpl();
		//ProductsDTO prodDTO=new ProductsDTO();
		ProductsDTO prodDTO = factory.manufacturePojo(ProductsDTO.class);
		ProductsDTO prodDTO2 = factory.manufacturePojo(ProductsDTO.class);
		List<ProductsDTO> prodDTOs =new ArrayList<>();
		prodDTOs.add(prodDTO); prodDTOs.add(prodDTO2);
		when(productsService.getAllProductsDTO()).thenReturn(prodDTOs);
		
		// when
		List<ProductsDTO> result = productsService.getAllProductsDTO();
 
        // then
        assertThat(result.size()).isEqualTo(2);
         
        assertThat(result.get(0).getBrand())
                        .isEqualTo(prodDTO.getBrand());
         
        assertThat(result.get(1).getCategory())
                        .isEqualTo(prodDTO2.getCategory());
		
    }

	@Test
    public void  listProducts() { 
    	 
    }
	 
    public void  listSearchedProducts( ) { 
		 
	     
    }
	 
 
    @Test
    public void  singleProducts() {
         
    }


    @Test
    public void createProducts() {
    	
		 
        
    }	

    @Test
    public void saveProducts(){
    	
		 
        
    }

    @Test
    public void deleteProducts()  {
         
    }

}
