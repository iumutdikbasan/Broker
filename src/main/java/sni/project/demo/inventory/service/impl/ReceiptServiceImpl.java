package sni.project.demo.inventory.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.Receipt;
import sni.project.demo.inventory.repo.ProductRepository;
import sni.project.demo.inventory.repo.ReceiptRepository;
import sni.project.demo.inventory.service.ReceiptService;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {
     private final
    ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }

    @Override
    public List<Receipt> findAll() {
        return receiptRepository.findAll();
    }
}
