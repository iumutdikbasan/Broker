package sni.project.demo.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sni.project.demo.inventory.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT productValue from Product")
    List<Integer> getProductByProductValue();

    List<Product> findAllById(Long productId);


}
