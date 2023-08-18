package sni.project.demo.inventory.service;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.model.Receipt;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> findAll();
    void addProduct(@RequestBody Product product);


    void save(Product product);
    void update(Product product);
    void delete(Long product_code);
    List<Integer> getProductByProductValue(); //TODO şunu sil

    List<Product> getProductDetails(Long productId);

}


