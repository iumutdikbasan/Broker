package sni.project.demo.inventory.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.repo.ProductRepository;
import sni.project.demo.inventory.service.ProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public void addProduct(@RequestBody Product product){
            productRepository.save(product);
    }
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
    @Override
    public void update(Product product) {
    }
    @Override
    public void delete(Long product_code) {
        productRepository.deleteById(product_code);
    }
    @Override
    public List<Integer> getProductByProductValue(){
        return productRepository.getProductByProductValue();
    }
    @Override
    public List<Product> getProductDetails(Long productId){
        return productRepository.findAllById(productId);
    }



}
