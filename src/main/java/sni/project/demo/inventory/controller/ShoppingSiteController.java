package sni.project.demo.inventory.controller;

import org.springframework.web.bind.annotation.*;
import sni.project.demo.inventory.model.ShoppingSite;
import sni.project.demo.inventory.service.ShoppingService;
import sni.project.demo.inventory.service.rabbitmq.RabbitMQJsonProducer;
import sni.project.demo.inventory.service.rabbitmq.RabbitMQSender;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppingsite")
public class ShoppingSiteController {
    final
    ShoppingService shoppingService;

    private final RabbitMQSender rabbitMQSender;
    private RabbitMQJsonProducer jsonProducer;

    public ShoppingSiteController(ShoppingService shoppingService, RabbitMQSender rabbitMQSender, RabbitMQJsonProducer jsonProducer) {
        this.shoppingService = shoppingService;
        this.rabbitMQSender = rabbitMQSender;
        this.jsonProducer = jsonProducer;
    }

    @PostMapping
    public void save(@RequestBody ShoppingSite shoppingSite){
        shoppingService.save(shoppingSite);
    }
    @GetMapping()
    public List<ShoppingSite> findAll(){
        return shoppingService.findAll();
    }


}
