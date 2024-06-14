package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.MenuModel;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, String> {
}
