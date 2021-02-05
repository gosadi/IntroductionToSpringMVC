/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.controller;

import emergon.entity.Product;
import emergon.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author alkinoos
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @RequestMapping
    public String showProducts(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("listOfProducts", products);
        return "productList";
    }
    
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String showForm(){
        return "productForm";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Product product, RedirectAttributes attributes){ //object gia to redirect pou kaname, gia na to valoume attributes sto request
        productService.addProduct(product);
        String minima = "Product " + product.getPdescr()+ " successfully created!!";
        attributes.addFlashAttribute("message",minima);
        return "redirect:/product"; //cliend send a new GET request to /customer
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id,RedirectAttributes attributes){
        productService.deleteProduct(id);
        String minima = "Product  successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/product";
    }
    
    @GetMapping("/update/{pcode}")
    public String showFormUpdate(@PathVariable(name = "pcode") int pcode, Model model){
        Product product = productService.getProductById(pcode);
        model.addAttribute("productToEdit", product);
        return "productForm";
    }
    
    @PostMapping("/update")
    public String update(Product product, RedirectAttributes attributes){
        productService.updateProduct(product);
        String minima = "Product  updated successfully!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/product"; 
    }
    
}
