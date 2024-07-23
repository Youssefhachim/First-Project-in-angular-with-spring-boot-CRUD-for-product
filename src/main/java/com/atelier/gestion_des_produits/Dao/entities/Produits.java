package com.atelier.gestion_des_produits.Dao.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    private String Name;
    private int quantity;
    private double price;

    public Produits(String s, double v, int i) {
    }
}
