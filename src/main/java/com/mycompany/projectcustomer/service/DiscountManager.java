/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcustomer.service;

import com.mycompany.projectcustomer.entity.Discount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 * Façade pour gérer les Discount_Code
 *
 * @author rakot
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager dm;

    @Transactional
    public void persist(Discount discount) {
        dm.persist(discount);
    }

    public List<Discount> getAllDiscounts() {
        Query query = dm.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public Discount findById(String code) {
        return dm.find(Discount.class, code);
    }

    /**
     * trier par ordre croissant
     * @return
     */
    public List<Discount> getAllDiscountsAscending() {
        Query query = dm.createQuery("SELECT d FROM Discount d ORDER BY d.rate ASC");
        return query.getResultList();
    }

    /**
     * trier par ordre decroisssant
     * @return
     */
    public List<Discount> getAllDiscountsDescending() {
        Query query = dm.createQuery("SELECT d FROM Discount d ORDER BY d.rate DESC");
        return query.getResultList();
    }
}
