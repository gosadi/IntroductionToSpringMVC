/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.service;

import emergon.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author alkinoos
 */
@Service
public class ProductService {

    private List<Product> products;

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList();
            products.add(new Product(1, "GPU", 499.99));
            products.add(new Product(2, "CPU", 399.99));
            products.add(new Product(3, "MONITOR", 599.99));
        }
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
