/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.franco.francotp1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.franco.francotp1.entity.Discount;

/**
 *
 * @author Franco
 */
@RequestScoped
public class DiscountManager 
{
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;
    
    public List<Discount> getAllDiscounts(){
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }
    
    public Discount findById(String code){
        return em.find(Discount.class, code);
    }
}
