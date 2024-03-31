/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectcustomer.jsf;

import com.mycompany.projectcustomer.entity.Customer;
import com.mycompany.projectcustomer.entity.Discount;
import com.mycompany.projectcustomer.service.CustomerManager;
import com.mycompany.projectcustomer.service.DiscountManager;
import java.io.Serializable;
import jakarta.inject.Inject;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Backing bean pour la page customerDetails.xhtml.
 *
 * @author rakot
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;
    @Inject
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = customerManager.findById(idCustomer);
    }

    /**
     * Retourne la liste de tous les Discount.
     *
     * @return
     */
    public List<Discount> getDiscounts() {
        return discountManager.getAllDiscounts();
    }

    /**
     * Retourne discounts par ordre croissant
     * @return 
     */
    public List<Discount> getDiscountsAscending() {
        List<Discount> discounts = discountManager.getAllDiscounts();
        Collections.sort(discounts, Comparator.comparing(Discount::getRate));
        return discounts;
    }

    /**
     * Retourne discounts par ordre decroissant
     * @return 
     */
    public List<Discount> getDiscountsDescending() {
        List<Discount> discounts = discountManager.getAllDiscounts();
        Collections.sort(discounts, Comparator.comparing(Discount::getRate).reversed());
        return discounts;
    }
}
