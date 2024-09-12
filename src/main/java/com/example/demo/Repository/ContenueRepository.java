package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Model.ContenueModel;
import com.example.demo.Model.Dashboard.Topplat;

@Repository
public interface ContenueRepository extends JpaRepository<ContenueModel, Integer> {

  @Query("select c from CommandeModel c where c.datecom>=?1")
  List<CommandeModel> findByQte(Date Datedebu);

  @Query("select c from ContenueModel c where c.commande.idcom=?1")
  Optional<List<ContenueModel>> findByCommandeModelId(String idcom);

  @Query("SELECT new com.example.demo.Model.Dashboard.Topplat(c.menu, SUM(c.qte)) FROM ContenueModel c GROUP BY c.menu ORDER BY SUM(c.qte) DESC")
  List<Topplat> findTop10Plats(Pageable pageable);

}
