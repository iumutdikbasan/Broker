package sni.project.demo.inventory.service.rabbitmq;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.model.Receipt;

@Service
public class RabbitMQSender {

    private final AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.template.exchange}")
    private String exchange;


    @Value("${rabbitmq.template.routing-key}")
    private String routingkey;

    public RabbitMQSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(Product productName){
        amqpTemplate.convertAndSend(exchange, routingkey, productName);
        System.out.println("Yeni ürün girişi yapıldı = " + productName); // her bir istekte ayrı ayrı gönderebilirsin
    }

    public void sendcargo(Receipt receipt){
        amqpTemplate.convertAndSend(exchange, routingkey, receipt);
        System.out.println("Sipariş verildi, Kargoya gönderilmesi lazım. " + receipt);

    }


}