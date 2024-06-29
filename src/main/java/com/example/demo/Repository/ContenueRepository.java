package com.example.demo.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.CommandeModel;
import com.example.demo.Model.ContenueModel;

@Repository
public interface ContenueRepository extends JpaRepository<ContenueModel, Integer> {

  @Query("select c from CommandeModel c where c.datecom>=?1")
  List<CommandeModel> findByQte(Date Datedebu);
}
