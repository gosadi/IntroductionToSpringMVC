/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Family;
import emergon.repository.FamilyRepo;
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
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepo;

    public List<Family> getFamilies() {
        List<Family> families = familyRepo.findAll();
        return families;
    }

    public Family saveFamily(Family family) {
        return familyRepo.save(family);
    }

    public void deleteFamily(int id) {
        familyRepo.delete(Family.class, id);
    }

    public Family getFamilyById(int id) {
        return familyRepo.findById(id);
    }

//    public List<Family> getFamiliesBySalesman(int id){
//        List<Family> families =   familyRepo.findByFk(id);
//        return families;
//    }
    
    
    public List<Family> getFamilyBySalesman(int scode){
        List<Family> family = familyRepo.findBySalesmanId(scode);
        return family;
    }
    
}
