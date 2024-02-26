/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.projectcustomer.jsf;

import com.mycompany.projectcustomer.entity.Customer;
import com.mycompany.projectcustomer.service.CustomerManager;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Baccking bean pour la page JSF customerList
 *
 * @author rakot
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    @Inject
    private CustomerManager customerManager;
    private List<Customer> customerList; 

    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     * @return 
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

}
