package com.jas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jas.common.dao.DaoUtil;

@Path("/Product")
public class ProductRestEasyService {

	@GET
	@Path("/{productId}")
	@Produces("application/json")
	public Response get(@PathParam("productId") int productId) {
		DaoUtil.setEntityManagerFactory(Persistence.createEntityManagerFactory("UserProfilePersistenceUnit"));
		EntityManager em = DaoUtil.createEntityManager();
		Product product = em.find(Product.class, productId);
		
		if (product == null) {
			em.getTransaction().begin();
			product = new Product();
			product.setProductid(1);
			product.setProductname("Java Book");
			
			em.persist(product);
			em.getTransaction().commit();
			product = em.find(Product.class, productId);
			
			em.close();
		}
		
		return Response.status(200).entity(product).build();
	}
}
