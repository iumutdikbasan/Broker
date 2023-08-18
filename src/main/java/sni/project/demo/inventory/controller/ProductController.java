package sni.project.demo.inventory.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.service.rabbitmq.RabbitMQJsonProducer;
import sni.project.demo.inventory.service.rabbitmq.RabbitMQSender;
import sni.project.demo.inventory.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final RabbitMQSender rabbitMQSender;
    private RabbitMQJsonProducer jsonProducer;

    public ProductController(ProductService productService, RabbitMQSender rabbitMQSender, RabbitMQJsonProducer jsonProducer) {
        this.productService = productService;
        this.rabbitMQSender = rabbitMQSender;
        this.jsonProducer = jsonProducer;
    }

    @GetMapping()
    public List<Product> findAll(){
        return productService.findAll();
    }
    @PostMapping
    public void save(@RequestBody Product product){
         productService.save(product);
    }
    @DeleteMapping(value = {"/{productId}"})
    public void delete(@PathVariable Long productId){
        productService.delete(productId);

    }
    @GetMapping("/productvalue")
    public List<Integer> getProductByProductValue(){
        return productService.getProductByProductValue();
    }

    @GetMapping(value = {"/{productId}"})
    public List<Product> getProductDetails(@PathVariable Long productId){
        return productService.getProductDetails(productId);
    }
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.save(product);
        rabbitMQSender.send(product);
    }

}

























//    @GetMapping(value = "/rabbitmq/receive/message")
//    public String consume(@RequestParam("productName") String productName,@RequestParam("productCount") String productCount) {
//
//        Product product=new Product();
//        product.setProductCount(productCount);
//        product.setProductName(productName);
//        rabbitMQSender.send(product);
//
//        return "RabbitMQ Mesajı gönderildi";
//    }