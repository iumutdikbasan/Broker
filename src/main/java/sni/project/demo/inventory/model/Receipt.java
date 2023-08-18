package sni.project.demo.inventory.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name = "receipt")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String receiverName;
    private String buyerAddress;
    private String buyerTaxOffice;
    private String dealerName;
    private String dealerAddress;
    private String dealerTaxOffice;

    @JsonManagedReference
    @OneToOne(mappedBy = "receipt")
    private Product product;

}
