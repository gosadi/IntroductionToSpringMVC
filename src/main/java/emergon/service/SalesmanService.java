/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Salesman;
import emergon.repository.SalesmanRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alkinoos
 */
@Transactional
@Service
public class SalesmanService {

    @Autowired
    SalesmanRepo salesmanRepo;

    public List<Salesman> getSalesmen() {
        List<Salesman> salesmen = salesmanRepo.findAll();
        return salesmen;
    }

    public Salesman saveSalesman(Salesman salesman) {
        return salesmanRepo.save(salesman);
    }

    public void deleteSalesman(int id) {
        salesmanRepo.delete(Salesman.class, id);
    }

    public Salesman getSalesmanById(int id) {
        return salesmanRepo.findById(id);
    }

    public List<String> getCities(){
        List<String> cities = new ArrayList<>();
        
        cities.add("Patra");
        cities.add("Irakleio");
        cities.add("Manh");
        cities.add("Kerkyra");
        cities.add("Larissa");
        cities.add("Athens");
        return cities;
    }
}
