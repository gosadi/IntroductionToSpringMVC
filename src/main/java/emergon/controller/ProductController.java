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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String create(Product product, Model model){
        productService.addProduct(product);
        List<Product> products = productService.getProducts();
        model.addAttribute("listOfProducts", products);
        return "productList";
    }
    
}
