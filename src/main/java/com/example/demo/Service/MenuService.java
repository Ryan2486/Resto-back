package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.MenuModel;
import com.example.demo.Repository.MenuRepository;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuModel> findAll() {
        return menuRepository.findAll();
    }

    public Optional<MenuModel> findById(String id) {
        return menuRepository.findById(id);
    }

    public MenuModel save(MenuModel menuModel) {
        return menuRepository.save(menuModel);
    }

    public void deleteById(String id) {
        menuRepository.deleteById(id);
    }
}
