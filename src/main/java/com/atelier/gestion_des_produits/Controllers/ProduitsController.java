package com.atelier.gestion_des_produits.Controllers;

import com.atelier.gestion_des_produits.Dao.entities.Produits;
import com.atelier.gestion_des_produits.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitsController {

    @Autowired
    private ProduitService produitService;
    @PostMapping
    public Produits createProduct(@RequestBody Produits produits) {
        return produitService.CreateProduct(produits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produits> getProductById(@PathVariable Long id) {
        return produitService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Produits> getAllProducts() {
        return produitService.GetAllProducts();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produits> updateProduct(@PathVariable Long id, @RequestBody Produits productDetails) {
        return ResponseEntity.ok(produitService.updateProduct(id, productDetails));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        produitService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
