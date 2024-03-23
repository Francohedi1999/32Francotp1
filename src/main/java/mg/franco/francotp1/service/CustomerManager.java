/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.franco.francotp1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.franco.francotp1.entity.Customer;

/**
 *
 * @author Franco
 */

/**
 * Gère la persistance des Customers.
 */

@RequestScoped
public class CustomerManager {
    
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    @Transactional
    public void persist(Customer customer){
        em.persist(customer);
    }
    
    public List<Customer> getAllCustomers(){
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    @Transactional
    public Customer update(Customer customer){
        return em.merge(customer);
    }
    
    public Customer findById(int idCustomer) {  
        return em.find(Customer.class, idCustomer);  
    }
}
