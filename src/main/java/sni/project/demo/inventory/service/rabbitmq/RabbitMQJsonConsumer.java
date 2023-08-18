package sni.project.demo.inventory.service.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.model.Receipt;
import sni.project.demo.inventory.service.ProductService;
import sni.project.demo.inventory.service.ReceiptService;

@Service
public class RabbitMQJsonConsumer {

    @Autowired
    ReceiptService receiptService;
    final
    ProductService productService;

    public RabbitMQJsonConsumer(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = {"${rabbitmq.template.queue}"})
    public void save(Receipt receipt){
        receiptService.save(receipt);
    }
}

