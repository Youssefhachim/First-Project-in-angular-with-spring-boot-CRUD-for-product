package com.atelier.gestion_des_produits;

import com.atelier.gestion_des_produits.Dao.entities.Produits;
import com.atelier.gestion_des_produits.Dao.repositories.ProduitsRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionDesProduitsApplication implements CommandLineRunner {

    @Autowired
    private ProduitsRepositorie produitsRepositorie;

    public static void main(String[] args) {
        SpringApplication.run(GestionDesProduitsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produits product1 = new Produits("Product 1", 10.99, 100);
        Produits product2 = new Produits("Product 2", 20.99, 150);
        Produits product3 = new Produits("Product 3", 30.99, 200);

        produitsRepositorie.save(product1);
        produitsRepositorie.save(product2);
        produitsRepositorie.save(product3);

        produitsRepositorie.findAll().forEach(product -> {
            System.out.println("Product: " + product.getName());
        });
    }
}
