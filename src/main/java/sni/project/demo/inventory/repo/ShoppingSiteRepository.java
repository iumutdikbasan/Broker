package sni.project.demo.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sni.project.demo.inventory.model.Receipt;
import sni.project.demo.inventory.model.ShoppingSite;

@Repository
public interface ShoppingSiteRepository extends JpaRepository<ShoppingSite,Long> {
}
