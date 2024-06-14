package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ReserverModel;

@Repository
public interface ReserverRepository extends JpaRepository<ReserverModel, String> {
}
