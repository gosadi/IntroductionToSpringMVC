/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Family;
import emergon.service.FamilyService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author alkinoos
 */
@Controller
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService service;

    @RequestMapping
    public ModelAndView showFamilies(ModelAndView modelAndView) {
        List<Family> families = service.getFamilies();
        modelAndView.addObject("listOfFamilies", families);
        modelAndView.setViewName("family/familyList");//returns the path where the jsp page exists
        return modelAndView;
    }

    /**
     * URLs /family/create : GET (familyList.jsp - link) /family/create :
     * POST (familyForm.jsp - form)
     *
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("family") Family family) {//fiaxnoume ena antikeimeno family/
        return "family/familyForm";                                                               //topothetite mesa sto ModelAttribute kai to perni i jsp
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("family") Family family, BindingResult result ,RedirectAttributes attributes) {//object gia to redirect pou kaname gia na valoume attributes sto request
        if(result.hasErrors()){
            return "family/familyForm"; //ean ipaxoun sfalmata tote epestrepse stin idia forma
        }
        service.saveFamily(family);
        String minima = "Family " + family.getFname() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family"; //cliend send a new GET request to /family
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes) {
        String minima;
        service.deleteFamily(id);
        minima = "Family deleted successfully!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }

//    edo exoume tsimpisi to path variable  apo to update sti lista
    @GetMapping("/update/{fid}")
    public String showFormUpdate(@PathVariable(name = "fid") int fid, Model model) {
        Family family = service.getFamilyById(fid);
        model.addAttribute("family", family);
        return "family/familyForm";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("family")Family family,BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "family/familyForm";
        }
        service.saveFamily(family);
        String minima = "Family  updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/family";
    }
    
    @GetMapping("/{scode}")
    public String showFamily(@PathVariable(name = "scode") int scode, Model model){
       List<Family> families  = service.getFamiliesBySalesman(scode);
       model.addAttribute("listOfFamilies", families);
       return "family/salesmanFamilyList";
    }

//    @ExceptionHandler(DataIntegrityViolationException.class)//anti na kano trycatch kalo ton exception handler
//    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
//        String minima = "Could not commit transaction !!";
//        attributes.addFlashAttribute("message", minima);
//        return "redirect:/family";
//    }
}
