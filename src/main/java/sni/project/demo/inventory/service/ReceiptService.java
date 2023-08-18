package sni.project.demo.inventory.service;

import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.Product;
import sni.project.demo.inventory.model.Receipt;

import java.util.List;

@Service
public interface ReceiptService {
    void save(Receipt receipt);
    List<Receipt> findAll();
}
