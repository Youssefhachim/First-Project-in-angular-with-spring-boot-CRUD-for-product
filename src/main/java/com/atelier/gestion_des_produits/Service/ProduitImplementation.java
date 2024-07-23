package com.atelier.gestion_des_produits.Service;

import com.atelier.gestion_des_produits.Dao.entities.Produits;

import java.util.List;
import java.util.Optional;

public interface ProduitImplementation {
    public Produits CreateProduct(Produits produits);
    public Optional<Produits> getProductById(Long id);
    public List<Produits> GetAllProducts();
    public Produits updateProduct(Long id, Produits productDetails);
    public void deleteProduct(Long id);
}
