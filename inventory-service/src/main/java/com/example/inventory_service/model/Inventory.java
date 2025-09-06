package com.example.inventory_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_inventory")
@AllArgsConstructor // tüm parametreli
@NoArgsConstructor // parametresiz
//@requiredargs da final ve non null fieldları olusturuyor
// eğer non null veya final yoksa parametresiz constructor olusturuyor
@Getter
@Setter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skuCode;
    private Integer quantity;

}
