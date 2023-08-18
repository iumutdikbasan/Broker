package sni.project.demo.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sni.project.demo.inventory.model.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt,Long> {
}
