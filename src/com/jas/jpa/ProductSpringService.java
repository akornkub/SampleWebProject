package com.jas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jas.common.dao.DaoUtil;

@Controller
@RequestMapping("/Product")
public class ProductSpringService {

	@RequestMapping(value="{productId}", method=RequestMethod.GET)
	@ResponseBody
	public Product getProduct(@PathVariable("productId") int productId) {
		 DaoUtil.setEntityManagerFactory(Persistence.createEntityManagerFactory("UserProfilePersistenceUnit"));
		EntityManager em = DaoUtil.createEntityManager();
		
		Product product = null;
		
		try {
			TypedQuery<Product> query = em.createQuery(
					"SELECT e FROM Product e WHERE e.productid = :productId", Product.class);
			product = query.setParameter("productId", new Integer(productId)).getSingleResult();
		} catch (Exception e) { }
		
		if (product == null) {
			product = new Product();
			product.setProductid(1);
			product.setProductname("Java Book");
			
			em.getTransaction().begin();			
			em.persist(product);
			em.getTransaction().commit();
			
			product = em.find(Product.class, productId);
			
			em.close();
		}
		
		return product;
	}
}
