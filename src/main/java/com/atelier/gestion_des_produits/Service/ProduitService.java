package com.atelier.gestion_des_produits.Service;

import com.atelier.gestion_des_produits.Dao.entities.Produits;
import com.atelier.gestion_des_produits.Dao.repositories.ProduitsRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitsRepositorie produitsRepositorie;

    public ProduitService(ProduitsRepositorie productRepository) {
        this.produitsRepositorie = productRepository;
    }

    // Create a new product
    public Produits CreateProduct(Produits produits)
    {
        return produitsRepositorie.save(produits);
    }

    // Get a product by id

    public Optional<Produits> getProductById(Long id) {
        return produitsRepositorie.findById(id);
    }

    // Get all products
    public List<Produits> GetAllProducts()
    {
        return produitsRepositorie.findAll();
    }

    // Update an existing product
    public Produits updateProduct(Long id, Produits productDetails) {
        Produits produits = produitsRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        produits.setName(productDetails.getName());
        produits.setPrice(productDetails.getPrice());
        produits.setQuantity(productDetails.getQuantity());

        return produitsRepositorie.save(produits);
    }

    // Delete a product by id
    public void deleteProduct(Long id) {
        Produits produits  = produitsRepositorie.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        produitsRepositorie.delete(produits);
    }
}
