/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Family;
import emergon.entity.Salesman;
import emergon.service.FamilyService;
import emergon.service.SalesmanService;
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
@RequestMapping("/salesman")
public class SalesmanController {

    @Autowired
    private SalesmanService service;
    
    @Autowired
    private FamilyService familyService;

    @RequestMapping
    public ModelAndView showSalesmen(ModelAndView modelAndView) {
        List<Salesman> salesmen = service.getSalesmen();
        modelAndView.addObject("listOfSalesmen", salesmen);
        modelAndView.setViewName("salesman/salesmanList");//returns the path where the jsp page exists
        return modelAndView;
    }

    /**
     * URLs /salesman/create : GET (salesmanList.jsp - link) /salesman/create :
     * POST (salesmanForm.jsp - form)
     *
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(@ModelAttribute("poliths") Salesman salesman) {//fiaxnoume ena antikeimeno salesman/
        return "salesman/salesmanForm";                                                               //topothetite mesa sto ModelAttribute kai to perni i jsp
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("poliths") Salesman salesman, BindingResult result ,RedirectAttributes attributes) {//object gia to redirect pou kaname gia na valoume attributes sto request
        if(result.hasErrors()){
            return "salesman/salesmanForm"; //ean ipaxoun sfalmata tote epestrepse stin idia forma
        }
        service.saveSalesman(salesman);
        String minima = "Salesman " + salesman.getSname() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman"; //cliend send a new GET request to /salesman
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes) {
        String minima;
        service.deleteSalesman(id);
        minima = "Salesman deleted successfully!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }

//    edo exoume tsimpisi to path variable  apo to update sti lista
    @GetMapping("/update/{scode}")
    public String showFormUpdate(@PathVariable(name = "scode") int scode, Model model) {
        Salesman salesman = service.getSalesmanById(scode);
        model.addAttribute("poliths", salesman);
        return "salesman/salesmanForm";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("poliths")Salesman salesman,BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            return "salesman/salesmanForm";
        }
        service.saveSalesman(salesman);
        String minima = "Salesman  updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }

    @ModelAttribute(name = "listOfCities")
    public List<String> getCities() {
        return service.getCities();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)//anti na kano trycatch kalo ton exception handler
    public String handleDataIntegrityViolationException(RedirectAttributes attributes) {
        String minima = "Could not commit transaction !!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/salesman";
    }
    
    
    @GetMapping("/{scode}/family")
    public String showFamily(@PathVariable(name="scode") int scode, Model model){
        List<Family> family = familyService.getFamilyBySalesman(scode);
        String message = "";
            if(family.isEmpty()){
                message = scode + "does not have any registered family members";
            }else{
                message = "Salesman family members are:";
            }
            model.addAttribute("family",family);
            model.addAttribute("message",message);
            return "salesman/familyList";
        }
    
}
