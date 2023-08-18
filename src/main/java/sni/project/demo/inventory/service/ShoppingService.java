package sni.project.demo.inventory.service;

import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.ShoppingSite;

import java.util.List;

@Service
public interface ShoppingService {

    void save(ShoppingSite shoppingSite);
    List<ShoppingSite> findAll();
}
