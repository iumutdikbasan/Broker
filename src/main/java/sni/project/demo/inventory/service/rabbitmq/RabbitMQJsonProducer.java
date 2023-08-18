package sni.project.demo.inventory.service.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.model.Receipt;

@Service
public class RabbitMQJsonProducer {
    @Value("${rabbitmq.template.exchange}")
    private String exchange;


    @Value("${rabbitmq.template.routing-key}")
    private String routingkey;

    @Value("${rabbitmq.template.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }
    public void sendJsonMessage(Product product){
        LOGGER.info(String.format("Json message sent to -> %s", product.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,product);
    }

    public void sendJsonCargoMessage(Receipt receipt){
        LOGGER.info(String.format("Json message sent to -> %s", receipt.toString()));
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,receipt);
    }

}
