package sni.project.demo.inventory.service.impl;

import org.springframework.stereotype.Service;
import sni.project.demo.inventory.model.ShoppingSite;
import sni.project.demo.inventory.repo.ShoppingSiteRepository;
import sni.project.demo.inventory.service.ShoppingService;

import java.util.List;

@Service
public class ShoppingSiteServiceImpl implements ShoppingService {

    final
    ShoppingSiteRepository shoppingSiteRepository;

    public ShoppingSiteServiceImpl(ShoppingSiteRepository shoppingSiteRepository) {
        this.shoppingSiteRepository = shoppingSiteRepository;
    }

    @Override
    public void save(ShoppingSite shoppingSite) {
        shoppingSiteRepository.save(shoppingSite);
    }

    @Override
    public List<ShoppingSite> findAll() {
        return shoppingSiteRepository.findAll();
    }
}
