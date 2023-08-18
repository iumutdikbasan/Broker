package sni.project.demo.inventory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sni.project.demo.inventory.model.Receipt;
import sni.project.demo.inventory.service.ReceiptService;
import sni.project.demo.inventory.service.rabbitmq.RabbitMQJsonProducer;
import sni.project.demo.inventory.service.rabbitmq.RabbitMQSender;

import java.util.List;

@RestController
@RequestMapping("/api/v1/receipts")
public class ReceiptController {
   final
   ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService, RabbitMQSender rabbitMQSender, RabbitMQJsonProducer jsonProducer) {
        this.receiptService = receiptService;
        this.rabbitMQSender = rabbitMQSender;
        this.jsonProducer = jsonProducer;
    }
    @GetMapping()
    public List<Receipt> findAll(){
        return receiptService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Receipt receipt){
        receiptService.save(receipt);
    }

    private final RabbitMQSender rabbitMQSender;
    private RabbitMQJsonProducer jsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonCargoMessage(@RequestBody Receipt receipt){
        rabbitMQSender.sendcargo(receipt);
        jsonProducer.sendJsonCargoMessage(receipt);
        return ResponseEntity.ok("RabbitMQ'ya mesaj gönderilmiştir. ");
    }

}
