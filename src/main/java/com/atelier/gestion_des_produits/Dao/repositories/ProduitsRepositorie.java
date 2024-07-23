package com.atelier.gestion_des_produits.Dao.repositories;

import com.atelier.gestion_des_produits.Dao.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitsRepositorie extends JpaRepository <Produits,Long>{

}
